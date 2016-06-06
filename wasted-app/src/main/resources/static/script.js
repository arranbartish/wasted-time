angular.module("WastedApp", ["ngAnimate","ui.bootstrap"])
    .config(["$httpProvider", function($httpProvider){

    }])
    .controller("WastedTime", function($scope, $http, $timeout, $log){

    })
    .directive('wasted', function() {
        return {
            restrict: 'E',
            replace: 'true',
            scope: {
                purchase: '='
            },
            templateUrl: './templates/wasted.html'
        }
    });

