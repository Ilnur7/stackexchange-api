var app = angular.module("grubDuck", []);

app.controller("AppCtrl", function($scope, $http){
    $scope.websites= [];

    $http.get('http://localhost:8099/api/stackoverflow').then(function (response) {
        $scope.websites = response.data;
    });
});

