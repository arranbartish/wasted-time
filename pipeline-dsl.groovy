def gitUrl = params["BUILD_SCM_URL"]
def revision = params["BUILD_COMMIT"]
def branchName = params["BUILD_BRANCH_NAME"]
def simpleBranchName = params["BUILD_SIMPLE_BRANCH_NAME"]
def buildName = params["BUILD_NAME"]
def pipelineId = buildName+"-"+build.number

// setup pipeline data and isolate commit
build("initialise-pipeline", BUILD_SCM_URL:gitUrl,
                            BUILD_COMMIT:revision,
                            BUILD_BRANCH_NAME:branchName,
                            BUILD_SIMPLE_BRANCH_NAME:simpleBranchName,
                            BUILD_NAME:buildName,
                            PIPELINE_ID:pipelineId )

// build artifact(s) to be tested and deployed
build("build-maven-project", PIPELINE_ID:pipelineId )

// Run tests and suites against the build artifacts
parallel (
        { build("unit-test", PIPELINE_ID:pipelineId) },
        { build("integration-test", PIPELINE_ID:pipelineId) }
)

// automated gitflow behaviour
switch(simpleBranchName) {

    case ~/(^feature\/.*)/:
        build("merge-branch-to-target", PIPELINE_ID:pipelineId, TARGET_BRANCH:"develop")
        break

    case ~/(^develop$)/:
        // nothing to do, our wonderful always green integration branch
        break

    case ~/(^candidate\/.*)/:
        build("create-release", PIPELINE_ID:pipelineId)
        break

    case ~/(^hotfix\/.*)/:
        parallel (
                { build("merge-branch-to-target", PIPELINE_ID:pipelineId, TARGET_BRANCH:"master") },
                { build("merge-branch-to-target", PIPELINE_ID:pipelineId, TARGET_BRANCH:"develop") }
        )
        break

    case ~/(^release\/.*)/:
        parallel (
                {
                    build("merge-branch-to-target", PIPELINE_ID:pipelineId, TARGET_BRANCH:"master")
                    build("tag-master-for-release", PIPELINE_ID:pipelineId)
                },
                {
                    build("merge-branch-to-target", PIPELINE_ID:pipelineId, TARGET_BRANCH:"develop")
                    build("prepare-next-development-version", PIPELINE_ID:pipelineId)
                }
        )
        break

    case ~/(^master$)/:
        // nothing to do heroku will take it from here
        break
}
