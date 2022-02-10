"""
 Time Complexity : O(n)
 Space Complexity : O(amount * coins)
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this : no


 Your code here along with comments explaining your approach      """
def CoinChange2(amount, coins)-> int:
    dp = [[0 for _ in range(amount + 1)] for _ in range(len(coins)+ 1)]

    for i in range(0,len(dp) ):
        dp[i][0] = 1

    for i in range(1, len(dp)):
        for j in range(1, len(dp[0])):
            if(coins[i-1]> j):
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

    return dp[len(dp)-1][len(dp[0])-1]

output = CoinChange2(5, [1,2,5])

"""def helper(amount, coins, combinations) -> int:
    # base
    if amount == 0:
        return 1
    if amount < 0 or len(coins)<=0:
        return 0


    #logic
    #Choose Case
    case1 = helper(amount - coins[0], coins, combinations + 1)

    #Not Choose Case
    case2 = helper(amount, coins[1:], combinations)

    return case1 + case2



output = CoinChange2(5, [2])
print(output)

output = CoinChange2(500, [200,40,100,5,1,600])
print(output)
"""