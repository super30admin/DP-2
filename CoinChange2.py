class Solution:
    """
    Time complexity - O(n*amount) n - no of coins
    Space complexity - O(amount)
    """
    def change(self, amount: int, coins: list[int]) -> int:
        if amount == 0:
            return 1
        if amount < min(coins):
            return 0
        n = len(coins)
        # stores the no of ways to make x using all the previos coins.
        prev_dp = [0 for x in range(0,amount+1)]
        # stores the no of ways to make x using all the coins including current.
        curr_dp = [0 for x in range(0,amount+1)]
        # sum 0 can be made by not selecting any coin.
        prev_dp[0] = 1
        curr_dp[0] = 1
        for x in range(0, n):
            for y in range(1, amount+1):
                if y-coins[x] >= 0:
                    #no of ways - no of ways till previous coin + 
                    #number of ways using current coin 
                    curr_dp[y] = curr_dp[y-coins[x]] + prev_dp[y]
                else:
                    curr_dp[y] = prev_dp[y]
            prev_dp = curr_dp.copy()
        return curr_dp[amount]
                