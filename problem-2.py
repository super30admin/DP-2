# LEETCODE PROBLEM 518. COIN CHANGE II
# TIME COMPLEXITY:O(M *N) where M is the number of coins and N is the amount
# SPACE COMPLEXITY: O(N) where N amount
# Any problem you faced while coding this: Had a few hiccup in like understanding also while 
# writing it



class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        #Approach 1
        # In this method a table is being made and the referencing is being done on the 
        # basis of the value of j example if j is 6 and is greater than the coin we are
        # referencing ie 5 we would add the value present in the row above the same
        # col and in the current row we will go back to 6-5=1 column to get value and then
        # add it
        # m=len(coins)
        # n=amount
        # dp=[[0]*(n+1) for _ in range(m+1)]
        # dp[0][0]=1
        # for i in range(1,m+1):
        #     for j in range(n+1):
        #         if (j<coins[i-1]):
        #             dp[i][j]=dp[i-1][j]
        #         else:
        #             dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        # return dp[m][n]

        #Approach 2
        # The column is updated as per the coin value that we are iterating and on that
        # basis we get a final answer which will be the last column of the given matrix
        m=len(coins)
        n=amount
        dp=[0]*(n+1)
        dp[0]=1
        for i in range(1,m+1):
            for j in range(coins[i-1],n+1):
                dp[j]=dp[j]+dp[j-coins[i-1]]
        return dp[n]