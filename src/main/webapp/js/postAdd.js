
function formController ($scope,$http) {
    $scope.reset = function() {
        $scope.adv = angular.copy($scope.master);
    };
    var base_url = window.location.origin;
    $scope.submit = function() {
    	if($scope.adv !== undefined){
        alert("data entered!!!!"+$scope.adv.category);
$http.post(base_url+'/buysellapp/resources/add/post ', $scope.adv)    


    }
    }
    $scope.reset();
    $scope.submit();
}

angular.module('app', []).controller('ContactController', formController)
