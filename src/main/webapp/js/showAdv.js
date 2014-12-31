
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
function formController($scope,$http) {
	var base_url = window.location.origin;
	
	var title = getUrlParameter('title');
	if(title == undefined){
		title="laptop"		
	}
	$scope.title = title;
	var url1 = base_url+"/buysellapp/resources/add/search?search-req="+title;
    $http.post(url1).success(function(response) {$scope.adds = response;});
    
    $scope.submit = function() {
    	
    	var url = base_url+"/buysellapp/resources/add/search?search-req="+$scope.title;
    	 $http.post(url).success(function(response) {$scope.adds = response;});


    
    }
}