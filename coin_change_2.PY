class Solution:
    '''
    Time Complexity: O(N * amount) where N is the length of coins
    Space Complexity: O(amount) the space needed to keep the amount dp array
    '''
    # you need to find the number of combinations
    def change(self, amount: int, coins: List[int]) -> int:
        # similar to coin 1 you set up an array with the amount + 1
        dp = [0] * (amount + 1)
        
        dp[0] = 1 # you use 1 here instead of 0 because there is at minimum one coin
        
        for coin in coins:
            for x in range(coin, amount + 1):
                # instead of getting the minimum, you find the number of ways
                dp[x] += dp[x - coin] # x - coin gives you the row of x - coin gives you the 
        return dp[amount]
    

'''
Example table (row: coin, col: amount)
elements/cells are the combinations.  We get all 1 for coin 1becuase there is only one way
This could be true of any starting postion.
You add each row down. Ex: row 2, col 1: results in 1 because we have only 1 way from row 1 col 1
'''