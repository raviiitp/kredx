

angular.module('kredx')
    .config(function ($stateProvider) {
        $stateProvider
            .state('kredxHome', {
                parent: 'kredx',
                url: '/',
                data: {
                    roles: []
                },
                views: {
                    'bodyContent@': {
                        templateUrl: 'scripts/app/partials/kredx/kredx.html?v=1',
                        controller: 'kredxCtrl'
                    }
                },
                resolve: {
                    dummy: function(){
                        $('body,html').animate({
                            scrollTop: 0
                        }, 10);
                    }
                }
            });
    })

;