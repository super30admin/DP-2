#time complexity: O(amount*no.of.coins)
#space complexity: O(amount*no.of.coins)
#ran on leetcode: yes
#Bottom up dp approach. Incrementally calculate how many types of denmomination combination
#can make the amount. Amount ranges from 0 till amount. Store the intermedialte result
#in a 2d array and use it to calculate solution to bigger problems. 
class Solution:
    def change(self, amount: int, coins) -> int:
        dp=[]
        for i in range(len(coins)+1):
            temp=[]
            for j in range(amount+1):
                temp.append(-1)
            dp.append(temp)
        
        for i in range(1,len(dp[0])):
            dp[0][i]=0
        for j in range(0,len(dp)):
            dp[j][0]=1
        print(dp)
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                #i is the amount
                #j is the coin denomimation
                if(j-coins[i-1]<0):
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        


        return dp[-1][-1]
s=Solution()
amount=5
coins=[1,2,5]
print(s.change(amount,coins))