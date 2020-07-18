
"""
Running on Leetcode
Time complexity - o(N)
The approach here is to intialize an array dp of len + 1 of the given array. now intialize the first 
index of the dp array to 1 and the remaining elements to 0and then iterative over the given array and 
the dp array if value of ith element of the given array is less than or equal to the index of the dp 
array set that index position of the dp array to value at index of the dp array - the element of the
given array. do this for all and finally return the last index value of the dp array.
"""
def change(self, amount, coins):
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for j in range(len(dp)):
                if coin <= j:
                    dp[j] += dp[j-coin]
        return dp[amount]