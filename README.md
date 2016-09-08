# kredx

Deployed at https://ravics27.herokuapp.com/

Input set: 50,000 reviews in food_review.txt

How to run in UI:
  1. Enter one or more query
  2. Click on search button
  
Result:
  Top 20 reviews based on queries
  
Performance benchmark:

wrk -t5 -c40 -d10s "http://localhost:8080/searchctrl?queries=wow&queries=hello&queries=cat&queries=dog&numReview=20"

Running 10s test @ http://localhost:8080/searchctrl?queries=wow&queries=hello&queries=cat&queries=dog&numReview=20
  5 threads and 40 connections
  
  Thread  Stats   Avg    Stdev    Max     +/- Stdev
  
    Latency   174.08ms   89.45ms 707.17ms   84.96%
    
    Req/Sec   49.63     22.39   120.00     69.15%
    
    2366 requests in 10.01s, 41.96MB read
    
Requests/sec:      236.31
Transfer/sec:      4.19MB

Time taken for getting top 20 reviews for queries (wow, hello, cat, dog)


2016-09-08 20:38:53.407  INFO 9562 --- [io-8080-exec-23] com.kr.rest.SearchController             : Searched in 75 milliseconds
2016-09-08 20:38:53.408  INFO 9562 --- [io-8080-exec-30] com.kr.rest.SearchController             : Searched in 39 milliseconds
2016-09-08 20:38:53.409  INFO 9562 --- [io-8080-exec-17] com.kr.rest.SearchController             : Searched in 51 milliseconds
2016-09-08 20:38:53.409  INFO 9562 --- [io-8080-exec-41] com.kr.rest.SearchController             : Searched in 34 milliseconds
2016-09-08 20:38:53.412  INFO 9562 --- [io-8080-exec-34] com.kr.rest.SearchController             : Searched in 48 milliseconds
2016-09-08 20:38:53.413  INFO 9562 --- [io-8080-exec-18] com.kr.rest.SearchController             : Searched in 84 milliseconds
2016-09-08 20:38:53.415  INFO 9562 --- [io-8080-exec-27] com.kr.rest.SearchController             : Searched in 83 milliseconds
2016-09-08 20:38:53.423  INFO 9562 --- [io-8080-exec-36] com.kr.rest.SearchController             : Searched in 89 milliseconds
2016-09-08 20:38:53.430  INFO 9562 --- [io-8080-exec-42] com.kr.rest.SearchController             : Searched in 66 milliseconds
2016-09-08 20:38:53.462  INFO 9562 --- [io-8080-exec-35] com.kr.rest.SearchController             : Searched in 44 milliseconds
2016-09-08 20:38:53.462  INFO 9562 --- [nio-8080-exec-3] com.kr.rest.SearchController             : Searched in 74 milliseconds
2016-09-08 20:38:53.467  INFO 9562 --- [io-8080-exec-13] com.kr.rest.SearchController             : Searched in 32 milliseconds
2016-09-08 20:38:53.469  INFO 9562 --- [io-8080-exec-19] com.kr.rest.SearchController             : Searched in 48 milliseconds
2016-09-08 20:38:53.470  INFO 9562 --- [io-8080-exec-20] com.kr.rest.SearchController             : Searched in 81 milliseconds
2016-09-08 20:38:53.475  INFO 9562 --- [nio-8080-exec-2] com.kr.rest.SearchController             : Searched in 47 milliseconds
2016-09-08 20:38:53.480  INFO 9562 --- [nio-8080-exec-1] com.kr.rest.SearchController             : Searched in 104 milliseconds
2016-09-08 20:38:53.482  INFO 9562 --- [io-8080-exec-11] com.kr.rest.SearchController             : Searched in 57 milliseconds
2016-09-08 20:38:53.482  INFO 9562 --- [io-8080-exec-26] com.kr.rest.SearchController             : Searched in 30 milliseconds
2016-09-08 20:38:53.485  INFO 9562 --- [io-8080-exec-33] com.kr.rest.SearchController             : Searched in 44 milliseconds
2016-09-08 20:38:53.485  INFO 9562 --- [io-8080-exec-40] com.kr.rest.SearchController             : Searched in 8 milliseconds
2016-09-08 20:38:53.486  INFO 9562 --- [io-8080-exec-28] com.kr.rest.SearchController             : Searched in 78 milliseconds
2016-09-08 20:38:53.487  INFO 9562 --- [io-8080-exec-21] com.kr.rest.SearchController             : Searched in 57 milliseconds
2016-09-08 20:38:53.487  INFO 9562 --- [io-8080-exec-37] com.kr.rest.SearchController             : Searched in 107 milliseconds
2016-09-08 20:38:53.488  INFO 9562 --- [nio-8080-exec-5] com.kr.rest.SearchController             : Searched in 71 milliseconds
2016-09-08 20:38:53.492  INFO 9562 --- [io-8080-exec-39] com.kr.rest.SearchController             : Searched in 48 milliseconds
2016-09-08 20:38:53.494  INFO 9562 --- [io-8080-exec-43] com.kr.rest.SearchController             : Searched in 53 milliseconds
2016-09-08 20:38:53.497  INFO 9562 --- [io-8080-exec-16] com.kr.rest.SearchController             : Searched in 43 milliseconds
2016-09-08 20:38:53.479  INFO 9562 --- [io-8080-exec-14] com.kr.rest.SearchController             : Searched in 23 milliseconds
2016-09-08 20:38:53.501  INFO 9562 --- [io-8080-exec-32] com.kr.rest.SearchController             : Searched in 12 milliseconds
2016-09-08 20:38:53.504  INFO 9562 --- [io-8080-exec-15] com.kr.rest.SearchController             : Searched in 102 milliseconds
2016-09-08 20:38:53.504  INFO 9562 --- [nio-8080-exec-9] com.kr.rest.SearchController             : Searched in 71 milliseconds
2016-09-08 20:38:53.504  INFO 9562 --- [nio-8080-exec-4] com.kr.rest.SearchController             : Searched in 14 milliseconds
2016-09-08 20:38:53.506  INFO 9562 --- [io-8080-exec-25] com.kr.rest.SearchController             : Searched in 101 milliseconds
2016-09-08 20:38:53.511  INFO 9562 --- [nio-8080-exec-8] com.kr.rest.SearchController             : Searched in 21 milliseconds
2016-09-08 20:38:53.531  INFO 9562 --- [io-8080-exec-30] com.kr.rest.SearchController             : Searched in 40 milliseconds
2016-09-08 20:38:53.547  INFO 9562 --- [io-8080-exec-28] com.kr.rest.SearchController             : Searched in 11 milliseconds
2016-09-08 20:38:53.555  INFO 9562 --- [nio-8080-exec-6] com.kr.rest.SearchController             : Searched in 53 milliseconds
2016-09-08 20:38:53.557  INFO 9562 --- [nio-8080-exec-2] com.kr.rest.SearchController             : Searched in 20 milliseconds
2016-09-08 20:38:53.558  INFO 9562 --- [io-8080-exec-10] com.kr.rest.SearchController             : Searched in 31 milliseconds
2016-09-08 20:38:53.558  INFO 9562 --- [nio-8080-exec-7] com.kr.rest.SearchController             : Searched in 46 milliseconds
2016-09-08 20:38:53.560  INFO 9562 --- [io-8080-exec-13] com.kr.rest.SearchController             : Searched in 20 milliseconds
2016-09-08 20:38:53.562  INFO 9562 --- [nio-8080-exec-1] com.kr.rest.SearchController             : Searched in 31 milliseconds
2016-09-08 20:38:53.564  INFO 9562 --- [io-8080-exec-34] com.kr.rest.SearchController             : Searched in 70 milliseconds
2016-09-08 20:38:53.565  INFO 9562 --- [io-8080-exec-18] com.kr.rest.SearchController             : Searched in 51 milliseconds
2016-09-08 20:38:53.567  INFO 9562 --- [io-8080-exec-23] com.kr.rest.SearchController             : Searched in 59 milliseconds
2016-09-08 20:38:53.568  INFO 9562 --- [io-8080-exec-28] com.kr.rest.SearchController             : Searched in 8 milliseconds
2016-09-08 20:38:53.572  INFO 9562 --- [io-8080-exec-14] com.kr.rest.SearchController             : Searched in 29 milliseconds
2016-09-08 20:38:53.580  INFO 9562 --- [io-8080-exec-27] com.kr.rest.SearchController             : Searched in 64 milliseconds
2016-09-08 20:38:53.584  INFO 9562 --- [io-8080-exec-22] com.kr.rest.SearchController             : Searched in 47 milliseconds
2016-09-08 20:38:53.585  INFO 9562 --- [io-8080-exec-31] com.kr.rest.SearchController             : Searched in 81 milliseconds
2016-09-08 20:38:53.588  INFO 9562 --- [io-8080-exec-12] com.kr.rest.SearchController             : Searched in 28 milliseconds
2016-09-08 20:38:53.590  INFO 9562 --- [io-8080-exec-15] com.kr.rest.SearchController             : Searched in 41 milliseconds
2016-09-08 20:38:53.592  INFO 9562 --- [io-8080-exec-36] com.kr.rest.SearchController             : Searched in 76 milliseconds
2016-09-08 20:38:53.592  INFO 9562 --- [io-8080-exec-29] com.kr.rest.SearchController             : Searched in 72 milliseconds
2016-09-08 20:38:53.594  INFO 9562 --- [io-8080-exec-24] com.kr.rest.SearchController             : Searched in 32 milliseconds
2016-09-08 20:38:53.598  INFO 9562 --- [io-8080-exec-17] com.kr.rest.SearchController             : Searched in 86 milliseconds
2016-09-08 20:38:53.602  INFO 9562 --- [io-8080-exec-41] com.kr.rest.SearchController             : Searched in 38 milliseconds
2016-09-08 20:38:53.605  INFO 9562 --- [nio-8080-exec-9] com.kr.rest.SearchController             : Searched in 9 milliseconds
2016-09-08 20:38:53.607  INFO 9562 --- [io-8080-exec-38] com.kr.rest.SearchController             : Searched in 90 milliseconds
2016-09-08 20:38:53.609  INFO 9562 --- [io-8080-exec-25] com.kr.rest.SearchController             : Searched in 9 milliseconds
2016-09-08 20:38:53.612  INFO 9562 --- [io-8080-exec-35] com.kr.rest.SearchController             : Searched in 45 milliseconds
2016-09-08 20:38:53.613  INFO 9562 --- [io-8080-exec-42] com.kr.rest.SearchController             : Searched in 55 milliseconds
2016-09-08 20:38:53.618  INFO 9562 --- [nio-8080-exec-8] com.kr.rest.SearchController             : Searched in 11 milliseconds
2016-09-08 20:38:53.633  INFO 9562 --- [io-8080-exec-23] com.kr.rest.SearchController             : Searched in 19 milliseconds
2016-09-08 20:38:53.635  INFO 9562 --- [io-8080-exec-38] com.kr.rest.SearchController             : Searched in 26 milliseconds
2016-09-08 20:38:53.636  INFO 9562 --- [io-8080-exec-35] com.kr.rest.SearchController             : Searched in 19 milliseconds
2016-09-08 20:38:53.639  INFO 9562 --- [nio-8080-exec-3] com.kr.rest.SearchController             : Searched in 35 milliseconds
2016-09-08 20:38:53.642  INFO 9562 --- [nio-8080-exec-8] com.kr.rest.SearchController             : Searched in 17 milliseconds
2016-09-08 20:38:53.662  INFO 9562 --- [io-8080-exec-43] com.kr.rest.SearchController             : Searched in 67 milliseconds
2016-09-08 20:38:53.663  INFO 9562 --- [io-8080-exec-20] com.kr.rest.SearchController             : Searched in 18 milliseconds
2016-09-08 20:38:53.667  INFO 9562 --- [nio-8080-exec-4] com.kr.rest.SearchController             : Searched in 47 milliseconds
2016-09-08 20:38:53.672  INFO 9562 --- [nio-8080-exec-2] com.kr.rest.SearchController             : Searched in 60 milliseconds
2016-09-08 20:38:53.676  INFO 9562 --- [io-8080-exec-11] com.kr.rest.SearchController             : Searched in 80 milliseconds
2016-09-08 20:38:53.677  INFO 9562 --- [nio-8080-exec-5] com.kr.rest.SearchController             : Searched in 77 milliseconds
2016-09-08 20:38:53.677  INFO 9562 --- [io-8080-exec-19] com.kr.rest.SearchController             : Searched in 8 milliseconds
2016-09-08 20:38:53.677  INFO 9562 --- [io-8080-exec-42] com.kr.rest.SearchController             : Searched in 25 milliseconds
2016-09-08 20:38:53.677  INFO 9562 --- [io-8080-exec-26] com.kr.rest.SearchController             : Searched in 69 milliseconds
2016-09-08 20:38:53.688  INFO 9562 --- [io-8080-exec-30] com.kr.rest.SearchController             : Searched in 71 milliseconds
2016-09-08 20:38:53.688  INFO 9562 --- [io-8080-exec-15] com.kr.rest.SearchController             : Searched in 9 milliseconds
2016-09-08 20:38:53.697  INFO 9562 --- [io-8080-exec-24] com.kr.rest.SearchController             : Searched in 8 milliseconds
2016-09-08 20:38:53.699  INFO 9562 --- [io-8080-exec-33] com.kr.rest.SearchController             : Searched in 20 milliseconds
2016-09-08 20:38:53.702  INFO 9562 --- [io-8080-exec-22] com.kr.rest.SearchController             : Searched in 18 milliseconds
2016-09-08 20:38:53.705  INFO 9562 --- [io-8080-exec-16] com.kr.rest.SearchController             : Searched in 67 milliseconds
2016-09-08 20:38:53.705  INFO 9562 --- [nio-8080-exec-6] com.kr.rest.SearchController             : Searched in 26 milliseconds
2016-09-08 20:38:53.706  INFO 9562 --- [io-8080-exec-40] com.kr.rest.SearchController             : Searched in 82 milliseconds
2016-09-08 20:38:53.707  INFO 9562 --- [io-8080-exec-18] com.kr.rest.SearchController             : Searched in 23 milliseconds
2016-09-08 20:38:53.708  INFO 9562 --- [io-8080-exec-29] com.kr.rest.SearchController             : Searched in 8 milliseconds
2016-09-08 20:38:53.708  INFO 9562 --- [io-8080-exec-21] com.kr.rest.SearchController             : Searched in 79 milliseconds
2016-09-08 20:38:53.709  INFO 9562 --- [io-8080-exec-32] com.kr.rest.SearchController             : Searched in 89 milliseconds
2016-09-08 20:38:53.710  INFO 9562 --- [io-8080-exec-39] com.kr.rest.SearchController             : Searched in 75 milliseconds
2016-09-08 20:38:53.711  INFO 9562 --- [io-8080-exec-27] com.kr.rest.SearchController             : Searched in 29 milliseconds
2016-09-08 20:38:53.713  INFO 9562 --- [io-8080-exec-28] com.kr.rest.SearchController             : Searched in 33 milliseconds
2016-09-08 20:38:53.713  INFO 9562 --- [io-8080-exec-36] com.kr.rest.SearchController             : Searched in 9 milliseconds
2016-09-08 20:38:53.715  INFO 9562 --- [io-8080-exec-14] com.kr.rest.SearchController             : Searched in 26 milliseconds
2016-09-08 20:38:53.717  INFO 9562 --- [io-8080-exec-25] com.kr.rest.SearchController             : Searched in 106 milliseconds
2016-09-08 20:38:53.718  INFO 9562 --- [io-8080-exec-17] com.kr.rest.SearchController             : Searched in 66 milliseconds
2016-09-08 20:38:53.721  INFO 9562 --- [nio-8080-exec-9] com.kr.rest.SearchController             : Searched in 73 milliseconds
2016-09-08 20:38:53.721  INFO 9562 --- [io-8080-exec-34] com.kr.rest.SearchController             : Searched in 32 milliseconds
2016-09-08 20:38:53.721  INFO 9562 --- [io-8080-exec-41] com.kr.rest.SearchController             : Searched in 96 milliseconds
2016-09-08 20:38:53.724  INFO 9562 --- [io-8080-exec-10] com.kr.rest.SearchController             : Searched in 73 milliseconds
2016-09-08 20:38:53.726  INFO 9562 --- [nio-8080-exec-7] com.kr.rest.SearchController             : Searched in 42 milliseconds
2016-09-08 20:38:53.727  INFO 9562 --- [io-8080-exec-37] com.kr.rest.SearchController             : Searched in 71 milliseconds
2016-09-08 20:38:53.727  INFO 9562 --- [io-8080-exec-35] com.kr.rest.SearchController             : Searched in 83 milliseconds
2016-09-08 20:38:53.728  INFO 9562 --- [io-8080-exec-13] com.kr.rest.SearchController             : Searched in 84 milliseconds
2016-09-08 20:38:53.730  INFO 9562 --- [io-8080-exec-23] com.kr.rest.SearchController             : Searched in 82 milliseconds
2016-09-08 20:38:53.734  INFO 9562 --- [nio-8080-exec-3] com.kr.rest.SearchController             : Searched in 36 milliseconds
