class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        ## M = amount
        ## N = len of coins        
        ## TC = O(MxN)
        ## SC = O(MxN)
        
        mat = [[0]*(amount+1) for i in range(len(coins)+1)]
        
        for i in range(len(mat)):
            mat[i][0] = 1
        
        coins.insert(0,0)
        
        for i in range(1, len(mat)):
            for j in range(1, len(mat[i])):
                
                if j >= coins[i]:
                    mat[i][j] = mat[i-1][j] + mat[i][j - coins[i]]
                else:
                    mat[i][j] = mat[i-1][j]
            
        # for i in mat:
        #     print(i)
        
        return mat[len(coins)-1][amount]