#coin change 2
# give a set of coins and a givne amount find the total amount of combinations for that amount
#python solution accepted
#time complexity O(n*amount) where n is the list of coins 
#space complexity O(n)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if len(coins)==0:
            return 0
        dp = [0]*(amount+1) #initalizing an array of size amount plus 1(5-> 000000)
        dp[0]=1#1 0 0 0 0 0
        for c in coins:
            for j in range(c,amount+1):
                dp[j]+=dp[j-c]
        return dp[amount]