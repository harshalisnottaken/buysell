 function getUrlParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
} 
var tech = getUrlParameter('id');
function categoryController($scope,$http) {
	var base_url = window.location.origin;
    $http.post(base_url+"/buysellapp/resources/category/sub-categories?category="+tech)
    
    .success(function(response) {$scope.subcategorys = response;});
    
    $scope.category=tech;
} 