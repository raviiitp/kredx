
angular.module('kredx')
    // get api call to server
    .factory('kredxFactory', function ($resource) {

            return {
                getSearchResult: function () {
                    return $resource('searchctrl/');
                },

                updateBestPriceOfEachBlock: function() {
                    return $resource('updateBestPriceOfEachBlock', {},
                        {
                            updateBestPriceOfEachBlock: {
                                method: 'POST',
                                transformResponse: function (data) {
                                    return {list: angular.fromJson(data)}
                                }
                            }
                        })
                }
            };

    })
;
