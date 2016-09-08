
angular.module('kredx')
    // get api call to server
    .factory('kredxFactory', function ($resource) {

            return {
                getSearchResult: function () {
                    return $resource('searchctrl/');
                },

                runTestQueries: function() {
                    return $resource('runTestQueries/', {},
                        {
                            runTestQueries: {
                                method: 'GET',
                                transformResponse: function (data) {
                                    return {testQueryResult: angular.fromJson(data)}
                                }
                            }
                        })
                }
            };

    })
;
