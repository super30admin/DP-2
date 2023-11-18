class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        lis=[[0 for i in range(0,amount+1)] for j in range(len(coins)+1)]
        lis[0][0]=1
        for i in range(1,(len(coins)+1)):
            for j in range(0,(amount+1)):
                if j<coins[i-1]:
                    lis[i][j]=lis[i-1][j]
                else:
                    lis[i][j]=lis[i-1][j]+lis[i][j-coins[i-1]]
        print(lis)
        return lis[len(coins)][amount]       