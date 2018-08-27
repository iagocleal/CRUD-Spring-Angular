'use strict';

angular.module('pessoas',['ngRoute','ngResource', 'ngMaterial', 'ngMessages', 'ngMask', 'material.svgAssetsCache', 'flow'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})

      .when('/Pessoa',{templateUrl:'views/Pessoa/conPessoa.jsp',controller:'ConPessoaController', isProtected: true, onlyAdmin: false, pageTitle: 'Listar Pessoa'})
      .when('/Pessoa/new',{templateUrl:'views/Pessoa/cadPessoa.jsp',controller:'CadPessoaController', isProtected: true, onlyAdmin: false, pageTitle: 'Criar Pessoa'})
      .when('/Pessoa/edit/:PessoaId',{templateUrl:'views/Pessoa/cadPessoa.jsp',controller:'EditPessoaController', isProtected: true, onlyAdmin: false, pageTitle: 'Editar Pessoa'})
      
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {})
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  }).config(function($mdDateLocaleProvider) {
  	  $mdDateLocaleProvider.formatDate = function(date) {
  		  if(angular.isUndefined(date) || date === null || date.length <= 0){
  			  return null;
  		  }else{
  			return moment(date).format('DD/MM/YYYY');
  		  }
  	  }
  	  
  	  $mdDateLocaleProvider.parseDate = function(dateString) {
  		  var m = moment(dateString, 'DD/MM/YYYY', true);
  		  return m.isValid() ? m.toDate() : new Date(NaN);
  	  };
  });

$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
	
	function getParam(name){var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);if (results==null){return null;}else{return results[1] || 0;}}
	
});


