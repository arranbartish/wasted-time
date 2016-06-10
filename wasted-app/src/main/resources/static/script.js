angular.module("WastedApp", ["ngAnimate","ui.bootstrap"])
    .config(["$httpProvider", function($httpProvider){

    }])
    .service("RequestService", function($http){
        this.doRequest = function(request, successCallback) {
            $http(request).success(successCallback);
        }
    })
    .service("WastedTimeService", function(RequestService){

        this.iHaveWastedTime = function(wastedTime) {

            var req = {
                method: 'POST',
                url: '/wasted',
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                },
                data: wastedTime
            };
            RequestService.doRequest(req,
                function(response){
                    scope.submitted = 'DONE';
                }
            );
        };
    })
    .service("TimeSliceService", function(RequestService){

        this.populateTimeSlices = function(scope) {

            var req = {
                method: 'GET',
                url: '/time-slices',
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                }
            };
            RequestService.doRequest(req,
                function(response){
                    scope.timeSlices = response;
                }
            );
        };
    })
    .controller("WastedTime", function($scope, $http, $timeout, $log, TimeSliceService, WastedTimeService){
        $scope.date = new Date();
        TimeSliceService.populateTimeSlices($scope);

        this.submitWastedTime = function() {
            payload = {
                who : $scope.name,
                activity : $scope.activity,
                duration : $scope.duration.slice,
                date : $scope.date.getTime()
            };
            WastedTimeService.iHaveWastedTime(payload);
        };
    })
    .directive('wasted', function() {
        return {
            restrict: 'E',
            replace: 'true',
            templateUrl: './templates/wasted.html',
            controllerAs: 'wastedTime',
            controller: 'WastedTime'
        }
    });

