'''
518. Coin Change 2

TIME COMPLEXITY: O(amount * len(coins))
SPACE COMPLEXITY: O(amount * len(coins))
LEETCODE: Yes
DIFFICULTY: Yes, it took a while to figure out the logic
'''


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if amount == 0:
            return 1
        
        n = len(coins)
        rl = n + 1 # row length
        cl = amount + 1 # column length
        m = [[0 for i in range(0, cl)] for i in range(0, rl)]
        
        
        for i in range(1 ,rl):
            for j in range(1, cl):
                
                # taken
                if j - coins[i-1] == 0: 
                    # if its 0, that means j added an additional way
                    # that's why it is '+1'
                    taken = m[i][j-coins[i-1]] + 1
                elif j - coins[i-1] > 0:
                    taken = m[i][j-coins[i-1]]
                else:
                    taken = 0
                
                # not taken
                not_taken = m[i-1][j]
                m[i][j] = taken + not_taken
        
        return m[rl-1][cl-1]
        
        
