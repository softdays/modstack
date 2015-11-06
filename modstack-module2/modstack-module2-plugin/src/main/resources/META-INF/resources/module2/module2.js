/*global define:false */

/**
 * 
 */
define(
    [ 'angular', 'angular-route', 'angular-resource' ],
    function(angular) {
        'use strict';

        var module = angular.module('module2', [ 'ngRoute', 'ngResource' ]);

        module.service('module2Svc', [ '$resource',
            function($resource) {

                var ModuleResource = $resource("api/module2/model");

                /**
                 * 
                 */
                return {
                    /**
                     * 
                     */
                    getModel : function() {
                        return ModuleResource.get({}, function(data) {
                           console.log('getModel: '+data);
                        }, function(httpResponse) {
                            console.log('getModel: error');
                        });
                    }
                };
            } ]);
        
        // Configuration of the router
        module.config([ '$routeProvider', function($routeProvider) {

            // Declare the basic routes
            $routeProvider.when('/module2/home', {
                template : "<div class='module-2'><h5>Yop, je suis le module n°2, je ne suis composé que d'un seul écran, ma couleur est 'Sandstorm' et voici la donnée que j'ai récupéré via un appel Ajax sur mon API REST dédiée = <code>{{ model.value }}</code></h5></div>",
                controller : 'module2Ctl',
                resolve : {
                    model : [ 'module2Svc', function(module2Svc) {
                        return module2Svc.getModel().$promise;
                    } ]
                }
            });          
        } ]);
        
        // Definition of the loading controller
        module.controller('module2Ctl', [ '$rootScope', '$scope', '$location', 'model',
            function($rootScope, $scope, $location, model) {
              $scope.model = model;  
            }
        ]);

        return module;
    });
