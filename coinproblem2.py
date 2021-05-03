from typing import List
#using the recursion
class Solution:
    def change(self, coins: List[int], amount: int) -> int:

        if coins is None or len(coins) == 0: return -1
        return  self.helper(coins=coins,amount=amount,index=0)
    # using the recursive approach
    def helper(self,coins: List[int], amount: int, index: int):
        if amount == 0: return 1
        if index == len(coins) or amount < 0: return -1
        # logic
        # for no coin selection case
        case1 = self.helper(coins=coins, amount=amount, index=index + 1)
        # for coin selection case
        case2 = self.helper(coins=coins, amount=amount-coins[index], index=index )
        if case1 != -1 and case2 != -1: return case1+case2
        if case1 == -1:  return case2
        elif case2 == -1: return case1

# using the DP approach
class Solution:

    def coinChange(self, coins: List[int], amount: int) -> int:

        if coins is None or amount==0: return -1
        ncolums =  amount + 1
        nrows =len(coins) + 1
         # creating the DP Matrix as we to keep track of amount and coins
        dp=[[0 for _  in range(0,ncolums)]for _ in range(0,nrows)]
        # o filling in the first coliumn
        for cindex in range(nrows):
            dp[cindex][0]=1
        for rindex in range(1,nrows):
            for cindex in range(1,ncolums):
                 if cindex<coins[rindex-1]:
                    dp[rindex][cindex]=dp[rindex-1][cindex]
                 else:
                    dp[rindex][cindex] = dp[rindex - 1][cindex]+ dp[rindex][cindex - coins[rindex - 1]]


        if dp[nrows-1][ncolums-1] ==0:return -1
        else:return dp[nrows-1][ncolums-1]


if __name__ == '__main__':

    print(Solution().coinChange(coins=[1,2,5],amount=5))

