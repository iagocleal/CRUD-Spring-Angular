var conPessoaControllerApp = angular.module('pessoas');

conPessoaControllerApp.controller('ConPessoaController', function($scope, $http ) {
	
	$scope.pessoa				= {};
	  $scope.pageSize			= 5;
	  $scope.currentPage 		= 0;
	  $scope.searchResults 		= [];
	  $scope.filteredResults 	= [];
	  $scope.pageRange 			= [];	  
	  $scope.numberOfPages 		= function() {
			var result 					= Math.ceil($scope.searchResults.length/$scope.pageSize);
			var max 					= (result == 0) ? 1 : result;
			$scope.pageRange 	= [];
	        
			for(var ctr=0;ctr<max;ctr++) {
	            $scope.pageRange.push(ctr);
	        }
			return max;
	  };
	  
	  $scope.excluir = function(idPessoa){
			 
		  swal(
			{
	    		title				: "Você tem certeza?",
	            text				: "Não será mais possível recuperar esses registros!",
	            type				: "warning",
	            showCancelButton	: true,
	            confirmButtonColor	: "#DD6B55",
	            confirmButtonText	: "Sim, apague isso!",
	            cancelButtonText	: "Não, cancele!",
	            closeOnConfirm		: false,
	            closeOnCancel		: false },
	            function (isConfirm) {
	            	if(idPessoa != null){
	            		if (isConfirm) {
		            		$http.delete("pessoa/excluir/" + idPessoa)
		        		 	.then(
		        	            function (response) {
		        	            	if(response && response.data && response.data.entity){
		                        		swal("Erro!", response.data.entity, "error");
		                        	} else {
		                        		swal("Deletado!", "Apagado com sucesso!", "success");
		                        		$scope.buscarPessoa($scope.pessoa);
		                        	}
		        	            }
		        	        );
		            	} else {
		            		swal("Cancelado", "Seu registro está salvo! :)", "error");
		            	}
	            	} else {
	            		swal("Cancelado", "Ocorreu um erro, contate o administrador!", "error");
	            	}
	            }
	    	);
	  	}
	  
	  $scope.buscarPessoaFiltro = function(){
		  
		  $scope.buscarPessoa($scope.pessoa); 
	  }
	  
	  $scope.buscarPessoa = function(pessoa){
		 
		 $http.post("pessoa/buscarPessoa", pessoa)
		 	.then(
	            function (response) {
	            	$scope.filteredResults = response.data;
	            	$scope.searchResults = $scope.filteredResults;
	            	
	            	$scope.pessoa.nome = null;
	      		  	$scope.pessoa.cpf = null;
	            }
		 	);
	  	}
	  
	  	$scope.popularPessoa = function() {
	  		$scope.pessoa.nome = null;
	  		$scope.pessoa.cpf = null;
		};
	  
		$scope.previous = function() {
	       if($scope.currentPage > 0) {
	           $scope.currentPage--;
	       }
		};
	    
		$scope.next = function() {
	       if($scope.currentPage < ($scope.numberOfPages() - 1) ) {
	           $scope.currentPage++;
	       }
		};
	    
		$scope.setPage = function(n) {
	       $scope.currentPage = n;
		};
		
		$scope.scrollTop = function() {
	        window.scrollTo(0, 0);
	    };
		
		$scope.popularPessoa();
		$scope.buscarPessoa($scope.pessoa);
		$scope.scrollTop();
	
});