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
        alert("data entered!!!!"+$scope.adv.category);
$http.post(base_url+'/buysellapp/resources/add/post ', $scope.adv) 

window.location.href = base_url+"/buysellapp/myAdd.html?emailId="+forceUnicodeEncoding($scope.adv.addKey.emailId);


    }
    }
    $scope.countries = {
            'India': {
                'Maharashtra': ['Pune', 'Mumbai', 'Nagpur', 'Akola'],
                'Madhya Pradesh': ['Indore', 'Bhopal', 'Jabalpur'],
                'Rajasthan': ['Jaipur', 'Ajmer', 'Jodhpur']
           }
    }
    
    $scope.categories = {
            
                'Electronics': ['Laptop', 'Mobile', 'Tablet'],
                'Home Needs': ['OTG', 'Rice cooker', 'Roti Maker'],
                'Jobs': ['WorkFromHome', 'BPO', 'IT']
           }
    
    $scope.reset();
    $scope.submit();
}

angular.module('app', []).controller('ContactController', formController)
