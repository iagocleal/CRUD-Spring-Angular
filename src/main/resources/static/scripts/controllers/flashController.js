'use strict';

angular.module('pessoas').controller('FlashController', ['$scope','flash', '$mdToast', '$timeout', function ($scope, flash, $mdToast, $timeout) {
	
	$scope.$watch('flash.getMessage()', function(newVal) {
		$scope.showSimpleToast(newVal);
		
        var message = newVal;
        if(message && message.text) {
            $scope.showAlert = message.text.length > 0;
            $scope.scrollTop();
        } else {
            $scope.showAlert = false;
        }
        
    });

    $scope.hideAlert = function() {
        $scope.showAlert = false;
    }
    
    $scope.scrollTop = function() {
        window.scrollTo(0, 0);
    };
    
	$scope.flash 		= flash;
    $scope.showAlert 	= false;
    var last			= {
    		bottom: true,
    		top: 	false,
    		right: 	true,
    		left:	false
    };

    $scope.toastPosition = angular.extend({},last);
    $scope.getToastPosition = function() {
    	sanitizePosition();
        return Object.keys($scope.toastPosition)
        	.filter(function(pos) { return $scope.toastPosition[pos]; })
        	.join(' ');
    };
    
    function sanitizePosition() {
    	var current = $scope.toastPosition;
        if ( current.bottom && last.top ) current.top 		= false;
        if ( current.top && last.bottom ) current.bottom 	= false;
        if ( current.right && last.left ) current.left 		= false;
        if ( current.left && last.right ) current.right 	= false;
        last = angular.extend({},current);
      }
    
    $scope.showSimpleToast = function(message) {
    	var pinTo = $scope.getToastPosition();
    	if(message.constructor == Array){
    		console.log(message.length);
    		for(var i = 0; i < message.length; i++){
    			console.log(i);
				var time = i > 0 ? 3000 : 0;
				console.log(time);
    			$timeout($mdToast.show(
        	    		$mdToast.simple()
        	            	.textContent(message[i].text)
        	            	.position(pinTo)
        	            	.hideDelay(3000)
        	        	), time);
    		}
    		
    		
    	}        
    };
}]);
