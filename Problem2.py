"""
Time Complexity : O(mn) m is amount, n is number of coins
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yup
Any problem you faced while coding this : No issues faced


Your code here along with comments explaining your approach

We use a double loop and identify that for a certain amount, how many different combinations of coins are possible
We are using the knapsack approach

"""

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        ref = [1] + [0] * amount

        for i in range(len(coins)):
            for j in range(amount+1):
                if (j-coins[i]) >= 0:
                    ref[j] += ref[j-coins[i]]

        return ref[-1]