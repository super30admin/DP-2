""
Time Complexity O(mn)

Space complexity is O(mn)

""

class Solution_coin2:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp=[[0 for x in range(amount+1)] for j in range(len(coins)+1)]
        
        dp[0][0]=1  #If the amount is zero then there is one solution ie is dont include any coin
        for i in range(1,len(coins)+1):
            dp[i][0]=1
            for j in range(1,amount+1):
                
                x=dp[i-1][j] #if i dont include that coin 
                
                #If I inclde the coin 
                if(j>=coins[i-1]):
                #if(j-coins[i-1]>=0):
                    y=dp[i][j-coins[i-1]]
                else:
                    y=0     #curr amount is less than the coin denomination, no solution exist
                dp[i][j]=x+y  #count(include current coin )+count(prev coin)
        return dp[len(coins)][amount]
                    