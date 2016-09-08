

'use strict';

angular.module('kredx', ['ui.router', 'ngResource', 'ui.bootstrap', 'ngCookies', 'LocalStorageModule', 'ngMaterial'])

    .run(function ($rootScope) {


        $rootScope.touchDevice = !!('ontouchstart' in window) || !!('msmaxtouchpoints' in window.navigator);

        // Copyright 2014-2015 Twitter, Inc.
        // Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
        if (navigator.userAgent.match(/IEMobile\/10\.0/)) {
            var msViewportStyle = document.createElement('style');
            msViewportStyle.appendChild(
                document.createTextNode(
                    '@-ms-viewport{width:auto!important}'
                )
            );
            document.head.appendChild(msViewportStyle)
        }




        $rootScope.$on('$stateChangeStart', function (event, toState, toStateParams) {
            $rootScope.toState = toState;
            $rootScope.toStateParams = toStateParams;
        });

        $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
            $rootScope.previousStateName = fromState['name'];
            $rootScope.previousStateParams = fromParams;
        });
    })

    .config(function ($stateProvider, $urlRouterProvider, $httpProvider, $locationProvider, localStorageServiceProvider) {

        //enable CSRF
        $httpProvider.defaults.xsrfCookieName = 'CSRF-TOKEN';
        $httpProvider.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';
        localStorageServiceProvider.setStorageType('sessionStorage');
        $locationProvider.html5Mode(true);

        $urlRouterProvider.otherwise('/');

        $stateProvider.state('kredx', {
            url: '',
            'abstract': true,
            views: {
            },
            resolve: {
            }
        });
    });
/* app.js end */

