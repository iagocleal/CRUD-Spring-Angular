'use strict';

angular.module('pessoas').controller('HeaderBoxController',["$scope", "flash", "$location", function ($scope, flash, $location) {
	
	$scope.$on('$routeChangeStart', function(next, current) { 

		var path = $location.path().replace("/","").split("/").shift();
		
		switch(path){
		
		case 'Pessoa':
			$scope.title = "Pessoa";
			$scope.subtitle = "Cadastro de Pessoa";
			break;

		default:
			$scope.title = "Seleção";
			$scope.subtitle = "Sistema de cadastro de pessoa";
		
		}
	});
	
	
	
	
}]);