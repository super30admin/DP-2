def minCost(costs, N):
   
    
    if (N == 0):
        return 0
 
    
    dp = [[0 for i in range(3)] for j in range(3)]

    dp[0][0] = costs[0][0]
    dp[0][1] = costs[0][1]
    dp[0][2] = costs[0][2]
 
    for i in range(1, N, 1):
       
        
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0]
 
       
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1]
 
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2]
 
    
    print(min(dp[N - 1][0], min(dp[N - 1][1],dp[N - 1][2])))
 

if __name__ == '__main__':
    costs = [[14, 2, 11],
             [11, 14, 5],
             [14, 3, 10]]
    N = len(costs)
     
   
    minCost(costs, N)
     
%TC : O(n)
%SC : O(mn) 