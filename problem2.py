class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
#DP single array
#         store=[0]*(amount+1)
#         store[0]=1
#         for coin in coins:
#             for i in range(1,amount+1):
#                 if coin<=i:
#                     store[i]+=store[i-coin]
#         return store[amount]
        #Time O(nm), m =amount, n=coins length
        #Space O(m)
       #through recursion
        memo=[[-1 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        return self.helper(coins,amount,0,memo)
    def helper(self,coins,amount,index,memo):
        #Base case
        if (amount==0):
            return 1
        if amount<0 or index>=len(coins):
            return 0
        
        if memo[index+1][amount]!=-1:
            return memo[index+1][amount]
        #Ignore current coin so amount will not change, index increase
        result=0
        result+=self.helper(coins,amount,index+1,memo)
        #Include current coin so amount will  change, index will not
        result+=self.helper(coins,amount-coins[index],index,memo)
        
        memo[index+1][amount]=result
        return result
        #Time O(nm)
        #Space O(nm)
