/* jshint expr:true */
/* global require:false, alert:false */

/**
 * @file This file contain the RequireJs configuration and will start the application when all
 *       dependencies are loaded
 * @version 1.0
 * @since 1.0
 * @author rpatriarche
 */
window.require && (function(requirejs) {
    'use strict';

    // use "requirejs" variable name instead of "require":
    // see:
    // http://stackoverflow.com/questions/19472500/using-require-config-in-a-vows-file

    // Sets the require.js configuration for your application.
    requirejs.config({
        // 3rd party script alias names (Easier to type 'jquery' than
        // 'libs/jquery-1.10.1.min')
        paths : {
            // 'Package' based for our application
            'jquery' : '../frameworks/jquery/jquery',
            'bootstrap' : '../frameworks/bootstrap/js/bootstrap',
            'angular' : '../frameworks/angular/angular',
            'angular-route' : '../frameworks/angular/angular-route',
            'angular-resource' : '../frameworks/angular/angular-resource',
            'modules-descriptor' : '../web/modules'
        },

        // urlArgs: 'timestamp=' + Date.now(), // To prevent caching

        // Put in a shim your your third party scripts that are not AMD
        // compatible
        shim : {
            'jquery' : {
                // attaches 'jQuery' to the window object
                'deps' : [],
                'exports' : 'jQuery'
            },
            'bootstrap' : {
                'deps' : [ 'jquery' ]
            },
            'angular' : {
                'deps' : [ 'jquery' ],
                'exports' : 'angular'
            },
            'angular-route' : {
                'deps' : [ 'angular' ]
            },
            'angular-resource' : {
                'deps' : [ 'angular' ]
            }
        }
    });

    requirejs([ 'angular', 'bootstrap', 'app' ], function(angular) {
        // Startup manually the application
        angular.bootstrap(document, [ 'myApp' ]);
    });

}(requirejs));
