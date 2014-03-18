'use strict';


angular.module('frontEndApp', [
  'ngCookies',
  'ngResource',
  'ngSanitize',
  'ngRoute'
])
  .config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/contact', {
		templateUrl : 'views/contact.html',
		controller : 'ContactcontrollerCtrl'
	  });
	$routeProvider.when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      });
    $routeProvider.otherwise({
        redirectTo: '/'
      });
  }]);
