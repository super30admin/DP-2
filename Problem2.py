#Problem 2 : https://leetcode.com/problems/coin-change-2/
#Test Cases Passed on LeetCode
#Time Complexity-O(N*T) where N is the no of coin denominations and T is the amount
#Space Complexity-O(N*T)

class Solution:
    def change(self, amount, coins):
        cols=amount+1
        rows=len(coins)+1
        #create 2 d matrix with 1st col being 1(no way) and 0 for others
        T=[[1 if col == 0 else 0 for col in range(cols)] for row in range(rows)]

        for i in range(1,rows):
            for j in range(1,cols):
               #take the value from above row and same col
                if j < coins[i-1]:
                    T[i][j] = T[i - 1][j]
                else:
                #take value from above row+ same row with column j-coins[i-1]
                    T[i][j] = T[i - 1][j]+ T[i][j - coins[i-1]]
        #last value in the matrix is our result               
        return T[len(coins)][amount]

sol=Solution()
nums = [1, 2, 5]
amount=5
print(sol.change(amount,nums))













