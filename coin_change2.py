# Time complexity: O(r*c)
# Space complexity: O(r*c)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        r = len(coins) + 1
        c = amount + 1
        
        res = [ [0 for i in range(c) ] for j in range(r)]
        
        # check if the coins list is empty or not and amount is 0 or not
        if coins is None and amount == 0:
            return 1
        
        # initialize first row and col
        # if amount is 0 and coins are present from (0,r) then add 1 way(DC)
        for i in range(r):
            res[i][0] = 1
        
        # if coins list is empty and the amount is in (1,c) then there is no way to make that amount(add 0)
        for j in range(1,c):
            res[0][j] = 0
        
        # traverse the matrix
        for i in range(1,r):
            for j in range(1,c):
                # if amount is less than the coin value then just update it with previous DC value(i.e. above row value)
                if j < coins[i-1]:
                    res[i][j] = res[i-1][j]
                # otherwise update it with sum of prev DC value and j- coins[i-1] value
                else:
                    res[i][j] = res[i][j - coins[i-1]] + res[i-1][j]
        
        # return the last element in the matrix as the solution
        return res[r-1][c-1]