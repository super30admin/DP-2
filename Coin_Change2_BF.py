# We are following the same path as the coin change1 problem
# using a BruteForce Recursion method
# Complexity is exponential 2^n
# This will fail for ceratin cases as time limit excedded.
# Since we have repeated sub problems as seen in the Recursion Tree
# Lets use that as a tell tale sign of Dynamic Programming problem.


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins == None:
            return 0
        return self.helper(amount, coins, idx=0)

    def helper(self,amount, coins,idx ):
        # base case
        if amount == 0:return 1
        if amount < 0 or idx == len(coins):return 0
        # logic
        pick = self.helper(amount-coins[idx],coins, idx)
        skip = self.helper(amount, coins, idx +1)
        return pick + skip
