'use strict';

angular.module('frontEndApp', [
  'ngCookies',
  'ngResource',
  'ngSanitize',
  'ngRoute'
])
  .config(['$routeProvider', function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
	  .when('/contact', {
		templateUrl : 'views/contact.html',
		controller : 'ContactCtrl'
	  })
      .otherwise({
        redirectTo: '/'
      });
  }]);
