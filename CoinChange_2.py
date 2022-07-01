from pip import List


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if(len(coins)==0):
            return -1
        m = len(coins)
        n = amount
        list1 = [0] * (m+1)
        for i in range(len(list1)):
            list1[i] = [0] * (n+1)
        for i in range(m+1):
            for j in range(n+1):
                if j == 0:
                    list1[i][j] = 1
                if i == 0 and j!= 0:
                    list1[i][j] = 0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if(j < coins[i-1]):
                    list1[i][j]= list1[i-1][j]
                else:
                    list1[i][j] = list1[i-1][j] + list1[i][j-coins[i-1]]
        return list1[m][n]
        
            
        
        