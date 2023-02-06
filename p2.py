#TC = O(m * n)
#Sc = O(m * n)
# successfully submitted on leetcode: Yes


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        #can't make up to the amount
        if len(coins) == 0:
            return 0
        
        rows = len(coins) + 1 #4
        cols = amount + 1 # 6 [0,1,2,3,4,5]

        arr = [[0 for j in range(cols)] for i in range(rows)]
        #change arr[0][0] to 1, becoz with coin 0 there is one way to make 0 amount
        arr[0][0] = 1
        #fill the arr, start from arr[1][j] becoz row 0 are filled with 0s already 
        for i in range(1, len(arr)):
            for j in range(0, len(arr[0])):
                #when amount is less than coins[i-1]
                if j < coins[i-1]:
                    arr[i][j] = arr[i - 1][j]
                else:
                    arr[i][j] = arr[i-1][j] + arr[i][j - coins[i-1]]
        ans = arr[rows - 1][cols - 1]
        return ans
