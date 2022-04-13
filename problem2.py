#coin change 2


# // Time Complexity : O(n*m) n= amount, m=length of coin array
# // Space Complexity :O(n*m)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



def change( amount, coins) :
    if amount ==0:
        return 1

    dp=[[0 for i in range(amount+1)] for j in range(len(coins)+1)]
    for i in range(len(coins)+1):                                           #there is 1 combination that make up 0 amount: its 0
        dp[i][0] = 1
    
    for i in range(1, len(dp)):
        for j in range(1, len(dp[0])):
            if (j<coins[i-1]):
                dp[i][j] = dp[i-1][j]                                       #if the amount is less than the coin then choose the value from last coin
            else:
                dp[i][j]=(dp[i-1][j]+ dp[i][j-coins[i-1]])                  #add the value from last coin to the value of this coin on the last array
                

    return dp[len(coins)][amount]

#test
print(change(5,[1,2,5]))