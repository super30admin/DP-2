"""
TC:O(mn)
TC:O(mn)
"""
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        main_arr=[([0]*((amount)+1)) for _ in range(0,len(coins)+1)]
        for i in range(len(coins)+1):
            for j in range(0,amount+1):
                if i==0:
                    main_arr[i][j]=0
                if j==0:
                    main_arr[i][j]=1
        for i in range(1,len(coins)+1):
            for j in range(0,amount+1):
                if coins[i-1] > j:
                    main_arr[i][j]=main_arr[i-1][j]
                else:
                    main_arr[i][j]=main_arr[i-1][j]+main_arr[i][j-coins[i-1]]
        return main_arr[-1][-1]