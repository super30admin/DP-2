#322. Coin Change
#time complexity = O(nm) no of coins and amount value
#space complexity = O(nm)
# create a 2D array of amount as col and no of coins as rows.
# intialize column[0] = 0 and rest to infinity.
#check if amount in col is greater than coin denomination then copy the min value from above column
# check if (amount - value of current coin) can be made up from the i available denominations if yes add 1 to array[row][column-amount[row]]
#Ran on Leetcode: Yes
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        min_amt_of_coins = [[0] + [inf] * amount for j in range(len(coins))]
        
        for i in range(len(coins)):
            for n in range(1, amount+1):
                
                
                options = []
                
                # Doesn't include the current coin
                if i >= 1:
                    options.append(min_amt_of_coins[i-1][n])
                
                # Include the current coin
                if n >= coins[i]:
                    options.append(1 + min_amt_of_coins[i][n-coins[i]])
                
                # Calculate the minimum number of coins from the available denominations
               
                if (len(options)):
                    min_amt_of_coins[i][n] = min(options)
                
        # Return the minimum number of coins from all available denominations needed to form the amount
        if min_amt_of_coins[-1][-1] == inf:
            return -1
        else:
            return min_amt_of_coins[-1][-1]