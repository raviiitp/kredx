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
 ...
