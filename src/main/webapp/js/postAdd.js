
function formController ($scope,$http) {
   alert($http.defaults.headers.post["Content-Type"]);
    $scope.reset = function() {
        $scope.adv = angular.copy($scope.master);
    };
    
    $scope.submit = function() {
    	if($scope.adv !== undefined){
        alert("data entered!!!!"+$scope.adv.category);
$http.post('http://localhost:8086/buysellapp/resources/add/post ', $scope.adv)    


    }
    }
    $scope.reset();
    $scope.submit();
}

angular.module('app', []).controller('ContactController', formController)
