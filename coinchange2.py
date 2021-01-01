class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        '''
        Missed case: counting duplicate coins. Solution: either use set to store all coins type or               create a table instead of 1D array
        Time: O(coins*amount)
        Space: O(coins*amount)
        '''
        coins.sort()
        if(amount==0):
            return 1
        if(len(coins)==0 or coins[0]>amount):
            return 0
        x = [[0 for j in range(0,len(coins))] for i in range(0,amount+1)]
        
        for i in range(0,len(coins)):
            k=0
            for j in range(coins[0],len(x)):
                if(i>0):
                    k = x[j][i-1]
                if(j-coins[i]==0):
                    x[j][i] = k + 1
                elif(j-coins[i]>0):
                    x[j][i] = k + x[j-coins[i]][i]
                else:
                    x[j][i] = k
        
        return x[-1][-1]
