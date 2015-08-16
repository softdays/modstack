/* global define:false */

/**
 * 
 */
define([ 'angular', 'modules-descriptor', 'angular-route', 'angular-resource' ], function(angular,
    ModulesDescriptor) {

    'use strict';

    var modulesDescriptor = ModulesDescriptor();

    var appDependencies = [ 'ngRoute', 'ngResource' ].concat(modulesDescriptor.modulesNames);

    angular.forEach(modulesDescriptor.modulesNames, function(moduleName) {
        loadCss(moduleName + "/" + moduleName + ".less");
    });

    loadJs('frameworks/less/less-1.7.3.min.js');

    var app = angular.module('myApp', appDependencies);

    // var app = modulesDescriptor.createApp('myApp', [ 'ngRoute', 'ngResource' ]);

    // app.service('moduleSvc', [ '$resource', function($resource) {
    // /**
    // * Load modules from server.
    // */
    // function loadModules() {
    // return $resource("api/modules").query().$promise;
    // }
    //
    // return {
    // loadModules : loadModules
    // };
    //
    // } ]);

    // Configuration of the router
    app.config([ '$httpProvider', '$routeProvider', '$locationProvider', '$logProvider',

    function($httpProvider, $routeProvider, $locationProvider, $logProvider) {

        $logProvider.debugEnabled(true);

        // Declare the basic routes
        $routeProvider.when('/', {
            templateUrl : "partials/home.html",
            controller : 'MainController',
            resolve : {
                modules : function() {
                    return modulesDescriptor.modules;
                }
            }
        });
    } ]);

    // Definition of the main controller
    app.controller('MainController', [ '$rootScope', '$scope', 'modules',
        function($rootScope, $scope, modules) {
            $rootScope.modules = modules;
        } ]);

    return app;
});
