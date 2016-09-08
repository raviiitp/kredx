angular.module('kredx')
    .controller('kredxCtrl',
    function ($rootScope, $scope, $window, $timeout, $state, $q, localStorageService, $location, kredxFactory) {

        /* meta tags */
        var queryList = $location.search()['q'];

        $scope.queries = [];

        $scope.prevQueries = [];

        $scope._newQuery = '';


        $scope.searchInProgress = '';

        var newQueryId = angular.element(document.querySelector('#newQueryId'));

        $scope.editQuery = function(query, index){
            if(index < $scope.queries.length){
                if(query !== null && query.length){
                    $scope.queries[index] = query;
                } else if(query !== null && !query.length ){
                    $scope.queries.splice(index, 1);
                }
            }

        };

        $scope.newQuery = function(_newQuery){
            if(_newQuery !== null && _newQuery.length > 0) {
                $scope.queries.push(_newQuery);
                $scope._newQuery = '';
                $timeout(function(){
                    newQueryId.focus();
                });
            }
        };

        $scope.searchResult = [];
        
        var process = function(){
            for(var i = 0; i < $scope.searchResult.length; i++){
                
            }
            angular.forEach($scope.searchResult, function (result) {
                    result.text_full = result.text;
                    if (result.text_full !== null) {
                        if (result.text_full.length > 225) {
                            result.text = result.text_full.substr(0, 225) + '...';
                            result.show_text_full = false;
                        }
                    }
            });
        };

            if (localStorageService.isSupported && localStorageService.get('prevQueries')!== null) {
                $scope.prevQueries = localStorageService.get('prevQueries');
                $scope.searchResult = localStorageService.get('searchResult', $scope.searchResult);

                if($scope.searchResult !== null && $scope.searchResult.length) {
                    process();
                }
            }


        $scope.search = function(){

            if($scope._newQuery.length){
                $scope.queries.push($scope._newQuery);
                $scope._newQuery = '';
            }

            if($scope.queries.length){

                $scope.searchInProgress = 'indeterminate';

                var deferredObject = $q.defer();
                kredxFactory.getSearchResult().query({
                    queries: $scope.queries,
                    numReview: 20
                })
                    .$promise
                    .then(function (result) {
                        deferredObject.resolve(result);
                        $scope.prevQueries = $scope.queries;
                        $scope.queries = [];
                        $scope.searchResult = result;
                        if (localStorageService.isSupported) {
                            localStorageService.set('prevQueries', $scope.prevQueries);
                            localStorageService.set('searchResult', $scope.searchResult);
                        }
                        process();
                        $scope.searchInProgress = '';
                    }, function (errorMsg) {
                        deferredObject.reject(errorMsg);
                        $scope.searchInProgress = '';
                    });
            }
        };

        $scope.testQueryResult = {
            timeDiff : 0,
            noOfTestQueries: 0
        };

        $scope.runTestQueries = function(){
            $scope.searchInProgress = 'indeterminate';

            var deferredObject = $q.defer();
            kredxFactory.runTestQueries().runTestQueries({
            })
                .$promise
                .then(function (result) {
                    deferredObject.resolve(result);
                    $scope.testQueryResult = result.testQueryResult;
                    $scope.searchInProgress = '';
                }, function (errorMsg) {
                    deferredObject.reject(errorMsg);
                    $scope.searchInProgress = '';
                });
        };
    })
;

