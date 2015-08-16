/*global define:false */

/**
 * 
 */
define(['angular', 'angular-route', 'angular-resource'], 
    
    function(angular) {
        
        'use strict';

        var module = angular.module('module1', [ 'ngRoute', 'ngResource' ]);

        module.service('module1Svc', [
            '$resource',
            function($resource) {

                var Module1Resource = $resource("api/module1/model");

                return {
                    getModel : function() {
                        return Module1Resource.get({}, function(data) {
                           console.log('getModel: '+data);
                        }, function(httpResponse) {
                            console.log('getModel: error');
                        });
                    }
                };
            } ]);
        
        // Configuration of the router
        module.config([ '$routeProvider', function($routeProvider) {

            $routeProvider.when('/module1/home', {
                templateUrl : "module1/home.html",
                controller : 'module1Ctl',
                resolve : {
                    model : [ 'module1Svc', function(module1Svc) {
                        return module1Svc.getModel().$promise;
                    } ]
                }
            });   
            
            $routeProvider.when('/module1/item1', {
                templateUrl : "module1/item1.html",
                controller : 'module1Item1Ctl',
                resolve : {
                    model : function() {
                        return {value:"item1value"};
                    }
                }
            });
            
            $routeProvider.when('/module1/item2', {
                templateUrl : "module1/item2.html",
                controller : 'module1Item2Ctl',
                resolve : {
                    model : function() {
                        return {value:"item2value"};
                    } 
                }
            });            
        }]);
        
        // Definition of the controllers
        module.controller('module1Ctl', [ '$rootScope', '$scope', '$location', 'model',
            function($rootScope, $scope, $location, model) {
              $scope.model = model;  
            }
        ]);
        
        module.controller('module1Item1Ctl', [ '$scope', 'model',
            function($scope, model) {
              $scope.model = model;  
            }
        ]);
        
        module.controller('module1Item2Ctl', [ '$scope', 'model',
            function( $scope, model) {
              $scope.model = model;  
            }
        ]);

        return module;
});
