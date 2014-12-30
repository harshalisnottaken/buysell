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
alert(tech);
alert();
function formController($scope,$http) {
	alert(xxx);
	  $http.get(base_url+"/buysellapp/category/sub-categories?category="+tech)
	  .success(function(response) {$scope.subCategory = response;});
	}

angular.module('app', []).controller('ContactController', formController)
