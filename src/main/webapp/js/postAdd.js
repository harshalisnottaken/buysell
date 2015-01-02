function forceUnicodeEncoding(string) {
  return unescape(encodeURIComponent(string));
}

function formController ($scope,$http) {
    $scope.reset = function() {
        $scope.adv = angular.copy($scope.master);
    };
    var base_url = window.location.origin;
    $scope.submit = function() {
    	if($scope.adv !== undefined){
$http.post(base_url+'/buysellapp/resources/add/post ', $scope.adv) 

window.location.href = base_url+"/buysellapp/myAdd.html?emailId="+forceUnicodeEncoding($scope.adv.addKey.emailId);


    }
    }
    
    $scope.reset();
    $scope.submit();
}

angular.module('app', []).controller('ContactController', formController)
