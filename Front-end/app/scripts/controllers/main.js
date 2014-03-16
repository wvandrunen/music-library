'use strict';

var app = angular.module('frontEndApp');

app.controller('MainCtrl', ['$scope', function ($scope) {	
		$scope.onButton1Click = function () {
			alert('hello test');
		}
  }]);

app.controller('ContactCtrl', ['$scope', function ($scope) {} ] );