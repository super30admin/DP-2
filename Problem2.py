## Problem2 (https://leetcode.com/problems/coin-change-2/)

# Method1: Recursion Exhaustive
# m ----- no: of coins
# n ----- amount
# Time Complexity : O(2^(m + n)) -- At every step, we have two choice to make. So exponential.
# The max level or the max depth of the tree is m+n
# Space Complexity : O(1) space. But if we consider auxiliary space of the recursion stack, max would be height of the tree, 
# then space complexity would be O(m + n)
# Did this code successfully run on Leetcode : TLE because time is O(2^(m + n))
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# As we have to find all the possible combinations, so we have to be exhaustive


class Solution(object):
    def change(self, amount, coins):
        def recursion(coins, idx, amount):
            # base case
            if(amount == 0):
                # it is a valid case where we are able to make the amount using the coins. So it is a combination
                return 1

            if(idx == len(coins) or (amount < 0)):
                # invalid case
                return 0

            # logic
            # skip the coin
            case1 = recursion(coins, idx + 1, amount)

            # choose the coin
            case2 = recursion(coins, idx, amount - coins[idx])

            return (case1 + case2)

        return recursion(coins, 0, amount)

        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        
sol = Solution()
print("Method1: Recursion Exhaustive")
print(sol.change(11, [1,2,5]))
print(sol.change(5, [1,2,5]))
print(sol.change(3, [2]))
print(sol.change(10, [10]))
print(sol.change(0, [1])) # edge case making 

# Method2: Recursion with Memoization with Hashmap
# m ----- no: of coins
# n ----- amount
# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Using memoization to store the results of the repeated sub problems. It helps to reduce the time complexity of the recursion solution,
# by avoiding exploring subproblems that we have already solved before. We can use a hashmap or a 2-D array based on input variables

class Solution(object):
    def change(self, amount, coins):
        def recursion(coins, idx, amount):
            # base case
            if(amount == 0):
                # it is a valid case where we are able to make the amount using the coins. So it is a combination
                return 1

            if(idx == len(coins) or (amount < 0)):
                # invalid case
                return 0

            if((idx, amount) in memo):
                return memo[(idx, amount)]

            # logic
            # skip the coin
            case1 = recursion(coins, idx + 1, amount)

            # choose the coin
            case2 = recursion(coins, idx, amount - coins[idx])
            memo[(idx, amount)] = (case1 + case2)
            return memo[(idx, amount)]

        memo = {}
        return recursion(coins, 0, amount)

        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        

sol = Solution()
print("Method2: Recursion with Memoization with Hashmap")
print(sol.change(11, [1,2,5]))
print(sol.change(5, [1,2,5]))
print(sol.change(3, [2]))
print(sol.change(10, [10]))
print(sol.change(0, [1]))


# Method3: Recursion with Memoization with 2-D Array
# m ----- no: of coins
# n ----- amount
# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Using memoization to store the results of the repeated sub problems. It helps to reduce the time complexity of the recursion solution,
# by avoiding exploring subproblems that we have already solved before. We can use a hashmap or a 2-D array based on input variables

class Solution(object):
    def change(self, amount, coins):
        def recursion(coins, idx, amount):
            # base case
            if(amount == 0):
                # it is a valid case where we are able to make the amount using the coins. So it is a combination
                return 1

            if(idx == len(coins) or (amount < 0)):
                # invalid case
                return 0

            if(memo[idx][amount] != -1):
                return memo[idx][amount]

            # logic
            # skip the coin
            case1 = recursion(coins, idx + 1, amount)

            # choose the coin
            case2 = recursion(coins, idx, amount - coins[idx])
            memo[idx][amount] = (case1 + case2)
            return memo[idx][amount]

        memo = []
        for i in range(len(coins)):
            memoRow = []
            for j in range(amount + 1):
                memoRow.append(-1)
            memo.append(memoRow)
        
        return recursion(coins, 0, amount)

        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        

sol = Solution()
print("Method3: Recursion with Memoization with 2-D array")
print(sol.change(11, [1,2,5]))
print(sol.change(5, [1,2,5]))
print(sol.change(3, [2]))
print(sol.change(10, [10]))
print(sol.change(0, [1]))


# Method4: Bottom-up Tabulation
# m ----- no: of coins
# n ----- amount
# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# In the recursive solution above we see many repeated subproblems. So we know it is a Dynamic Programming problem. 
# In this I am using tabulation that is bottom-up approach to build the tree from the leaf that is from back. We know our first column
# of the dp matrix would always be 1 as it would be base case of our recursion where we need to return no. of combinations that would 
# make the amount of 0. Here we use first row as dummy, that are invalid cases, so we store 0 here as we are returning 0 as invalid case
# in recursion. Then we apply operation on our dp array handling two main cases. When denomination of coin > current amount, 
# then our number of combination would always come from the above row that case 0 when we dont choose that coin.
# if denomination of coin <= current amount, then we the (above row result + result we got from denomination no. of steps back in same row)

class Solution(object):
    def change(self, amount, coins):
        # tabulation
        # we construct the dp array with first row as dummy
        dp = []
        m = len(coins)
        n = amount
        for i in range(m + 1):
            dpRow = []
            for j in range(n + 1):
                if(j == 0):
                    # this is our base case of recursion when amount == 0
                    dpRow.append(1)
                else:
                    dpRow.append(0)

            dp.append(dpRow)

        # apply operation of dp table
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # if amount < denomination
                if(j < coins[i - 1]):
                    # take the above row value
                    dp[i][j] = dp[i - 1][j]
                else:
                    # add choose, not choose cases
                    # not choose case from above row
                    # choose case from the same row by denomination no. of
                    # steps back
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[m][n]

        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        
sol = Solution()
print("Method4: DP with Bottom-Up Tabulation")
print(sol.change(11, [1,2,5]))
print(sol.change(5, [1,2,5]))
print(sol.change(3, [2]))
print(sol.change(10, [10]))
print(sol.change(0, [1]))



# Method5: Bottom-up Tabulation with space optimization
# m ----- no: of coins
# n ----- amount
# Time Complexity : O(m * n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Now in this if we see closely we are relying only on one previous row result and the same row result for number of combinations
# Then we don’t need to store all the rest rows of the matrix. As the earlier rows we are not using, so we can optimize the 
# space by cutting the extra rows. If we just maintain a 1-D array and we keep overwriting on that as we apply 
# operations to find number of combinations for a particular amount.

class Solution(object):
    def change(self, amount, coins):
        # tabulation with space optimization
        # Maintain a 1-D dp array and keep overwriting
        dp = []
        m = len(coins)
        n = amount
        for j in range(n + 1):
            if(j == 0):
                # this is our base case of recursion when amount == 0
                dp.append(1)
            else:
                dp.append(0)

        # apply operation of dp table
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # if amount < denomination
                if(j >= coins[i - 1]):
                #     # take the above row value
                #     dp[i][j] = dp[i][j]
                # else:
                    # add choose, not choose cases
                    # not choose case from above row
                    # choose case from the same row by denomination no. of
                    # steps back
                    dp[j] = dp[j] + dp[j - coins[i - 1]]

        return dp[n]

        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        
sol = Solution()
print("Method5: DP with Bottom-Up Tabulation with space optimization")
print(sol.change(11, [1,2,5]))
print(sol.change(5, [1,2,5]))
print(sol.change(3, [2]))
print(sol.change(10, [10]))
print(sol.change(0, [1]))