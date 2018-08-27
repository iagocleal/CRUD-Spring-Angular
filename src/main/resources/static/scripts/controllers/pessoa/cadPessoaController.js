var cadPessoaControllerApp = angular.module('pessoas');

cadPessoaControllerApp.controller('CadPessoaController', function($scope, $http, $location, flash ) {
	
	$scope.pessoa			= $scope.pessoa || {};
    $scope.telefone			= $scope.telefone || {};
    $scope.telefoneAdded	= [];
    $scope.tableTelefone	= [];
	
    $scope.salvar = function() { 
    	
    	$scope.pessoa.lstTelefone = $scope.telefoneAdded;
    	$scope.pessoa.nome = $scope.pessoa.nome.toUpperCase();
    	
    	if($scope.validarCampos($scope.pessoa)){
    		
    		$http.post("pessoa/salvar", $scope.pessoa)
    		.then(
                function (response) {
                	if(response && response.data && response.data.entity){
                		swal("Erro!", response.data.entity, "error");
                	} else {
                		swal("Salvo!", "Registro salvo com sucesso!.", "success");
                        $location.path('/Pessoa');
                	}
                }
            );
    		
    	}    	
    	
    };
    
    $scope.addTelefone = function(){
    	if($scope.validarCamposTelefone()){
			var telefone 		= {};
			var table	 		= {};
	
			telefone.ddd 		= $scope.telefone.ddd;
			telefone.numero 	= $scope.telefone.numero;				
			$scope.telefoneAdded.push(telefone);
			
			table.ddd 				= $scope.telefone.ddd;
			table.numero			= $scope.telefone.numero;	
			$scope.tableTelefone.push(table);
			
			$scope.telefone.ddd 		= null;
			$scope.telefone.numero 	= null;
    	}
	}
    
    $scope.removeTelefone = function(item){
    	angular.forEach($scope.telefoneAdded, function(value, key){
			if(item.ddd != undefined && item.numero != undefined){
				if(value.ddd == item.ddd 
						&& value.numero == item.numero){
					$scope.telefoneAdded.splice(key,1);
				}
			}
		});

		$scope.tableTelefone.splice($scope.tableTelefone.indexOf(item),1);
	}
    
    $scope.validarCampos = function(pessoa){
    	valido = true;
    	
    	usuario = pessoa.email.substring(0, pessoa.email.indexOf("@"));
    	dominio = pessoa.email.substring(pessoa.email.indexOf("@")+ 1, pessoa.email.length);
    	
    	if (!((usuario.length >= 1) && (dominio.length >= 3)
			&& (usuario.search("@") == -1) && (dominio.search("@") == -1)
			&& (usuario.search(" ") == -1) && (dominio.search(" ") == -1)
			&& (dominio.search(".") != -1) && (dominio.indexOf(".") >= 1)
			&& (dominio.lastIndexOf(".") < dominio.length - 1))) {
    		
    		flash.setMessage({'type': 'warning', 'text': 'E-mail inválido.'}, true);
    		valido = false;
			
		}
    	
    	if(pessoa.cpf.length < 14){
    		flash.setMessage({'type': 'warning', 'text': 'CPF inválido.'}, true);
    		valido = false;
    	}
    	
    	return valido;
    }
    
    $scope.validarCamposTelefone = function(){
    	valido = true;
    	
    	if( ($scope.telefone.ddd == "" || $scope.telefone.ddd == null || $scope.telefone.ddd == undefined)
    			&& ($scope.telefone.numero == "" || $scope.telefone.numero == null || $scope.telefone.numero == undefined) ){
    		flash.setMessage({'type': 'warning', 'text': 'Os campos DDD e Telefone são obriatórios!'}, true);
    		valido = false;
    	}else if($scope.telefone.numero == "" || $scope.telefone.numero == null || $scope.telefone.numero == undefined){
    		flash.setMessage({'type': 'warning', 'text': 'O campo DDD é obriatório!'}, true);
    		valido = false;
    	} else if($scope.telefone.numero == "" || $scope.telefone.numero == null || $scope.telefone.numero == undefined){
    		flash.setMessage({'type': 'warning', 'text': 'O campo Telefone é obriatório!'}, true);
    		valido = false;
    	}
    	
    	return valido;
    }
    
    $scope.cancelar = function() {
        $location.path("/Pessoa");
    };
    
    $scope.scrollTop = function() {
        window.scrollTo(0, 0);
    };
    
    $scope.scrollTop();
    
});