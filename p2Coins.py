"""
// Time Complexity : O(n^k), k is coin combo, n is height of recursive tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : havent found ideal solution with dp yet


// Your code here along with comments explaining your approach
"""


class Solution(object):
    def change(self, amount, coins):
        if amount == 0;
            return 1
        if len(coins) == 0 or amount < 0:
            return 0
        #   1) Solutions that cointain the coin at the end of the coins array 
        #   2) Solutions that don't contain that coin 
        return self.change(amount - coins[-1], coins) + self.change(amount, coins[:-1]) 