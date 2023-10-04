#TC: O(coins*amount) SC:O(coins*amount)
#DP problem
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins:
            return 0

        row = len(coins) + 1
        col = amount + 1

        db=[[None for i in range(col) ] for j in range(row)]

        for i in range(row):
            db[i][0]=1
            
        for j in range(col):
            db[0][j]=0

        for i in range(1,row):
            for j in range(1,col):
                if j<coins[i-1]:
                    db[i][j]=db[i-1][j]
                else:
                    db[i][j]=db[i-1][j]+db[i][j-coins[i-1]]

        return db[row-1][col-1]            
