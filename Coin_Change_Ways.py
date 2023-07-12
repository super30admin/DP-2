# // Time Complexity : O(m*n) n= coins, m= amount
# // Space Complexity :O(m) m= amount
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
# 1) the first way was exhaustive, then converted the exhaustive way to Dp, via a DP matrix, added the amount-coins[i] and the element above
# 2) then converted the matrix to array as we are only using the elements in the same row. and the element above gets used before getting over written.
# 3) return the final element of the array.

class Solution:
    def helper(self, coins, i, amount):
        #base case
        if(amount<0):
            return 0
        if(i==len(coins)):
            return 0
        if(amount==0):
            return 1
        #logic
        #choose
        case1=self.helper(coins, i, amount-coins[i])
        #not choose
        case2=self.helper(coins, i+1, amount)

        #return condition
        return case1+case2

    def change(self, amount: int, coins: List[int]) -> int:
        #exhaustive way
        # return self.helper(coins, 0, amount)
        # dp way
        dp_matrix=[None for i in range(amount+1)]
        dp_matrix[0]=1
        for i in range(1,amount+1):
            dp_matrix[i]=0

        for i in range(1,len(coins)+1):
            for j in range(amount+1):
                if(j<coins[i-1]):
                    dp_matrix[j]=dp_matrix[j]
                else:
                    dp_matrix[j]=dp_matrix[j]+dp_matrix[j-coins[i-1]]
        # print(dp_matrix)
        return dp_matrix[amount]