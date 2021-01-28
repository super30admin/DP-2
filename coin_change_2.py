'''
Implementation: 
Initial array:
1 0 0 0 0 0
On Coin 1, start with index 1:
1 1 1 1 1 1
On Coin 2, start with index 2 and add existing value with a - 2 (2 steps back) and keep other same:
1 1 2 2 3 3
On Coin , start with index 5 and add exisiting value with a - 5 (5 steps back) and keep others same:
1 1 2 2 3 4

Final answer = arr[amount]

Time complexity: O(n)
Space complexity: O(n)
'''
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp = [0] * (amount + 1)
        dp[0] = 1
        
        for coin in coins:
            for a in range(1, amount + 1):
                if a - coin >= 0:
                    dp[a] += dp[a - coin] #not adding 1 since we want ot get no. of ways and not min
        return dp[amount]

s = Solution()
print(s.change(5, [1,2,5]))