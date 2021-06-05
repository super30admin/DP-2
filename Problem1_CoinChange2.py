'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 518. Coin Change 2

# You are given an integer array coins representing coins of different 
# denominations and an integer amount representing a total amount of money.

# Return the number of combinations that make up that amount. If that amount of
# money cannot be made up by any combination of the coins, return 0.

# You may assume that you have an infinite number of each kind of coin.

# The answer is guaranteed to fit into a signed 32-bit integer.

#-----------------
# Time Complexity: 
#-----------------
# O(A*N): Where A is the amount and N is the number of denominations in the 
#         "coins" list. We need a nested for loop to iterate over each
#         denomination (N) and we repeat this for all values of amount 
#         between 1 to amount -> A * N
#------------------
# Space Complexity: 
#------------------
# O(A) - We need an array to store the amount -> coin combo mapping

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  136 ms (88.64 %ile)
# Space            :  14.3 MB (84.03% ile)
from typing import List
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        print(f"amount: {amount}, coins:{coins}")

        # The number of possible combinations of coins that make amount "i"
        # is stored in amount_combo_map[i]
        # We need amount + 1 copies because we are also calculating 
        # number of coins to make amount = 0
        # 0 because we start with 0 combinations for each amount
        amount_combo_map = [0] * (amount + 1)

        #Base case: Amount = 0, number of $0 coins required to make amount = 1
        amount_combo_map[0] = 1
        
        # print(f"amount_combo_map(0):{amount_combo_map}")

        # We already know amount_combo_map[0] = 1 so we start from index "coin"
        # Consider every amount between "coin" and the desired amount
        for coin in coins:
            for i in range(coin, len(amount_combo_map)):
                
                # This coin can be used in any amount>coin
                # So add all previous possibilities . Base case will be
                # to increment by 1
                amount_combo_map[i] += amount_combo_map[i-coin]
            # print(f"amount_combo_map({coin}):{amount_combo_map}")
        return amount_combo_map[amount]

obj = Solution()
print(f"Possible combinations: {obj.change(11, [1,2,5])}")

