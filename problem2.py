# Time Complexity : O(NK), K is the amount 
# Space Complexity :O(NK), K is the amount

# Did this code successfully run on Leetcode : 
#yes

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approachclass Solution:


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
 
        if coins == None and len(coins) == 0:
            return 0
        min_array = [[0 for x in range(amount+1)] for y in range(len(coins)+1)]
        for j in range(1,len(coins)+1):
            min_array[j][0] = 1
        for i in range(1, len(coins)+1):
            for j in range(1,amount+1):
                if j < coins[i-1]:
                    min_array[i][j] = min_array[i-1][j]
                else:
                    min_array[i][j] = min_array[i-1][j]+ min_array[i][j-coins[i-1]]

        return min_array[len(coins)][amount] 
        