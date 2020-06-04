# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        array = [0] *(amount+1)
        array[0] = 1
        #for each coin for each amount use it if possible
        for i in coins:
            for j in range(i,amount + 1):
                # add  the amount - coins to the amount
                array[j] +=array[j-i]
        return array[amount]