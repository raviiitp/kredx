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


 20:38:53.407  INFO 9562 --- [io-8080-exec-23]              : Searched in 75 milliseconds

 20:38:53.408  INFO 9562 --- [io-8080-exec-30]              : Searched in 39 milliseconds

 20:38:53.409  INFO 9562 --- [io-8080-exec-17]              : Searched in 51 milliseconds

 20:38:53.409  INFO 9562 --- [io-8080-exec-41]              : Searched in 34 milliseconds

 20:38:53.412  INFO 9562 --- [io-8080-exec-34]              : Searched in 48 milliseconds

 20:38:53.413  INFO 9562 --- [io-8080-exec-18]              : Searched in 84 milliseconds

 20:38:53.415  INFO 9562 --- [io-8080-exec-27]              : Searched in 83 milliseconds

 20:38:53.423  INFO 9562 --- [io-8080-exec-36]              : Searched in 89 milliseconds

 20:38:53.430  INFO 9562 --- [io-8080-exec-42]              : Searched in 66 milliseconds

 20:38:53.462  INFO 9562 --- [io-8080-exec-35]              : Searched in 44 milliseconds

 20:38:53.462  INFO 9562 --- [nio-8080-exec-3]              : Searched in 74 milliseconds

 20:38:53.467  INFO 9562 --- [io-8080-exec-13]              : Searched in 32 milliseconds

 20:38:53.469  INFO 9562 --- [io-8080-exec-19]              : Searched in 48 milliseconds

 20:38:53.470  INFO 9562 --- [io-8080-exec-20]              : Searched in 81 milliseconds

 20:38:53.475  INFO 9562 --- [nio-8080-exec-2]              : Searched in 47 milliseconds

 20:38:53.480  INFO 9562 --- [nio-8080-exec-1]              : Searched in 104 milliseconds

 20:38:53.482  INFO 9562 --- [io-8080-exec-11]              : Searched in 57 milliseconds

 20:38:53.482  INFO 9562 --- [io-8080-exec-26]              : Searched in 30 milliseconds

 20:38:53.485  INFO 9562 --- [io-8080-exec-33]              : Searched in 44 milliseconds

 20:38:53.485  INFO 9562 --- [io-8080-exec-40]              : Searched in 8 milliseconds

 20:38:53.486  INFO 9562 --- [io-8080-exec-28]              : Searched in 78 milliseconds
 20:38:53.487  INFO 9562 --- [io-8080-exec-21]              : Searched in 57 milliseconds
 20:38:53.487  INFO 9562 --- [io-8080-exec-37]              : Searched in 107 milliseconds
 20:38:53.488  INFO 9562 --- [nio-8080-exec-5]              : Searched in 71 milliseconds
 20:38:53.492  INFO 9562 --- [io-8080-exec-39]              : Searched in 48 milliseconds
 20:38:53.494  INFO 9562 --- [io-8080-exec-43]              : Searched in 53 milliseconds
 20:38:53.497  INFO 9562 --- [io-8080-exec-16]              : Searched in 43 milliseconds
 20:38:53.479  INFO 9562 --- [io-8080-exec-14]              : Searched in 23 milliseconds
 20:38:53.501  INFO 9562 --- [io-8080-exec-32]              : Searched in 12 milliseconds
 20:38:53.504  INFO 9562 --- [io-8080-exec-15]              : Searched in 102 milliseconds
 20:38:53.504  INFO 9562 --- [nio-8080-exec-9]              : Searched in 71 milliseconds
 20:38:53.504  INFO 9562 --- [nio-8080-exec-4]              : Searched in 14 milliseconds
 20:38:53.506  INFO 9562 --- [io-8080-exec-25]              : Searched in 101 milliseconds
 20:38:53.511  INFO 9562 --- [nio-8080-exec-8]              : Searched in 21 milliseconds
 20:38:53.531  INFO 9562 --- [io-8080-exec-30]              : Searched in 40 milliseconds
 20:38:53.547  INFO 9562 --- [io-8080-exec-28]              : Searched in 11 milliseconds
 20:38:53.555  INFO 9562 --- [nio-8080-exec-6]              : Searched in 53 milliseconds
 20:38:53.557  INFO 9562 --- [nio-8080-exec-2]              : Searched in 20 milliseconds
 20:38:53.558  INFO 9562 --- [io-8080-exec-10]              : Searched in 31 milliseconds
 20:38:53.558  INFO 9562 --- [nio-8080-exec-7]              : Searched in 46 milliseconds
 20:38:53.560  INFO 9562 --- [io-8080-exec-13]              : Searched in 20 milliseconds
 20:38:53.562  INFO 9562 --- [nio-8080-exec-1]              : Searched in 31 milliseconds
 20:38:53.564  INFO 9562 --- [io-8080-exec-34]              : Searched in 70 milliseconds
 20:38:53.565  INFO 9562 --- [io-8080-exec-18]              : Searched in 51 milliseconds
 20:38:53.567  INFO 9562 --- [io-8080-exec-23]              : Searched in 59 milliseconds
 20:38:53.568  INFO 9562 --- [io-8080-exec-28]              : Searched in 8 milliseconds
 20:38:53.572  INFO 9562 --- [io-8080-exec-14]              : Searched in 29 milliseconds
 20:38:53.580  INFO 9562 --- [io-8080-exec-27]              : Searched in 64 milliseconds
 20:38:53.584  INFO 9562 --- [io-8080-exec-22]              : Searched in 47 milliseconds
 20:38:53.585  INFO 9562 --- [io-8080-exec-31]              : Searched in 81 milliseconds
 20:38:53.588  INFO 9562 --- [io-8080-exec-12]              : Searched in 28 milliseconds
 20:38:53.590  INFO 9562 --- [io-8080-exec-15]              : Searched in 41 milliseconds
 20:38:53.592  INFO 9562 --- [io-8080-exec-36]              : Searched in 76 milliseconds
 20:38:53.592  INFO 9562 --- [io-8080-exec-29]              : Searched in 72 milliseconds
 20:38:53.594  INFO 9562 --- [io-8080-exec-24]              : Searched in 32 milliseconds
 20:38:53.598  INFO 9562 --- [io-8080-exec-17]              : Searched in 86 milliseconds
 20:38:53.602  INFO 9562 --- [io-8080-exec-41]              : Searched in 38 milliseconds
 20:38:53.605  INFO 9562 --- [nio-8080-exec-9]              : Searched in 9 milliseconds
 20:38:53.607  INFO 9562 --- [io-8080-exec-38]              : Searched in 90 milliseconds
 20:38:53.609  INFO 9562 --- [io-8080-exec-25]              : Searched in 9 milliseconds
 20:38:53.612  INFO 9562 --- [io-8080-exec-35]              : Searched in 45 milliseconds
 20:38:53.613  INFO 9562 --- [io-8080-exec-42]              : Searched in 55 milliseconds
 20:38:53.618  INFO 9562 --- [nio-8080-exec-8]              : Searched in 11 milliseconds
 20:38:53.633  INFO 9562 --- [io-8080-exec-23]              : Searched in 19 milliseconds
 20:38:53.635  INFO 9562 --- [io-8080-exec-38]              : Searched in 26 milliseconds
 20:38:53.636  INFO 9562 --- [io-8080-exec-35]              : Searched in 19 milliseconds
 20:38:53.639  INFO 9562 --- [nio-8080-exec-3]              : Searched in 35 milliseconds
 20:38:53.642  INFO 9562 --- [nio-8080-exec-8]              : Searched in 17 milliseconds
 20:38:53.662  INFO 9562 --- [io-8080-exec-43]              : Searched in 67 milliseconds
 20:38:53.663  INFO 9562 --- [io-8080-exec-20]              : Searched in 18 milliseconds
 20:38:53.667  INFO 9562 --- [nio-8080-exec-4]              : Searched in 47 milliseconds
 20:38:53.672  INFO 9562 --- [nio-8080-exec-2]              : Searched in 60 milliseconds
 20:38:53.676  INFO 9562 --- [io-8080-exec-11]              : Searched in 80 milliseconds
 20:38:53.677  INFO 9562 --- [nio-8080-exec-5]              : Searched in 77 milliseconds
 20:38:53.677  INFO 9562 --- [io-8080-exec-19]              : Searched in 8 milliseconds
 20:38:53.677  INFO 9562 --- [io-8080-exec-42]              : Searched in 25 milliseconds
 20:38:53.677  INFO 9562 --- [io-8080-exec-26]              : Searched in 69 milliseconds
 20:38:53.688  INFO 9562 --- [io-8080-exec-30]              : Searched in 71 milliseconds
 20:38:53.688  INFO 9562 --- [io-8080-exec-15]              : Searched in 9 milliseconds
 20:38:53.697  INFO 9562 --- [io-8080-exec-24]              : Searched in 8 milliseconds
 20:38:53.699  INFO 9562 --- [io-8080-exec-33]              : Searched in 20 milliseconds
 20:38:53.702  INFO 9562 --- [io-8080-exec-22]              : Searched in 18 milliseconds
 20:38:53.705  INFO 9562 --- [io-8080-exec-16]              : Searched in 67 milliseconds
 20:38:53.705  INFO 9562 --- [nio-8080-exec-6]              : Searched in 26 milliseconds
 20:38:53.706  INFO 9562 --- [io-8080-exec-40]              : Searched in 82 milliseconds
 20:38:53.707  INFO 9562 --- [io-8080-exec-18]              : Searched in 23 milliseconds
 20:38:53.708  INFO 9562 --- [io-8080-exec-29]              : Searched in 8 milliseconds
 20:38:53.708  INFO 9562 --- [io-8080-exec-21]              : Searched in 79 milliseconds
 20:38:53.709  INFO 9562 --- [io-8080-exec-32]              : Searched in 89 milliseconds
 20:38:53.710  INFO 9562 --- [io-8080-exec-39]              : Searched in 75 milliseconds
 20:38:53.711  INFO 9562 --- [io-8080-exec-27]              : Searched in 29 milliseconds
 20:38:53.713  INFO 9562 --- [io-8080-exec-28]              : Searched in 33 milliseconds
 20:38:53.713  INFO 9562 --- [io-8080-exec-36]              : Searched in 9 milliseconds
 20:38:53.715  INFO 9562 --- [io-8080-exec-14]              : Searched in 26 milliseconds
 20:38:53.717  INFO 9562 --- [io-8080-exec-25]              : Searched in 106 milliseconds
 20:38:53.718  INFO 9562 --- [io-8080-exec-17]              : Searched in 66 milliseconds
 20:38:53.721  INFO 9562 --- [nio-8080-exec-9]              : Searched in 73 milliseconds
 20:38:53.721  INFO 9562 --- [io-8080-exec-34]              : Searched in 32 milliseconds
 20:38:53.721  INFO 9562 --- [io-8080-exec-41]              : Searched in 96 milliseconds
 20:38:53.724  INFO 9562 --- [io-8080-exec-10]              : Searched in 73 milliseconds
 20:38:53.726  INFO 9562 --- [nio-8080-exec-7]              : Searched in 42 milliseconds
 20:38:53.727  INFO 9562 --- [io-8080-exec-37]              : Searched in 71 milliseconds
 20:38:53.727  INFO 9562 --- [io-8080-exec-35]              : Searched in 83 milliseconds
 20:38:53.728  INFO 9562 --- [io-8080-exec-13]              : Searched in 84 milliseconds
 20:38:53.730  INFO 9562 --- [io-8080-exec-23]              : Searched in 82 milliseconds
 20:38:53.734  INFO 9562 --- [nio-8080-exec-3]              : Searched in 36 milliseconds
