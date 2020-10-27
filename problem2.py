#timecomplexity O()??
#spacecomplexity O()??
# i am facing difficulty to find the both the complexity can you help in that
# 

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins==None: return 0
        dp=[[0]*(amount+1) for _ in range(len(coins)+1)]

        for i in range(len(coins)+1):
            dp[i][0]=1 # base case assuming with 0 coin amount0 can selected by selecting  one 0 coin

        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[-1][-1]
            
            
    """     
    #passing coins,amount, starting index for coin choose 
    return self.recCombination(coins,amount,0)
        
    def recCombination(self,coins,amount,index):
        if amount==0: return 1
        if amount<0 or index>=len(coins): return 0
        
        
        case1=self.recCombination(coins,amount-coins[index],index)
        case2=self.recCombination(coins,amount,index+1)
        
        
        return case1+case2
    """