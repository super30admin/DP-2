class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        i=0
        d={}
        def dfs(a,c,i,memo):
            if a==0:
                return 1
            if a<0 :
                return 0
            if i==len(coins):
                return 0
            if (i, a) in memo:
                return memo[(i, a)]
            if i<len(coins):
                count=dfs(a-coins[i],coins,i,memo)+dfs(a,coins,i+1,memo)
                memo[(i,a)]=count
                return count
        return dfs(amount,coins,i,d)
   