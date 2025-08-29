'''
Solution 1: Recursion
at each iteration, I have 2 options, choose/no-choose. 
Base condition: if remaining amount=0 | all types of coins considered | amount<0
Time Complexity: O(2^(m+n)), m = Different denomination of coins, n = amount
Space Complexity: O(1)
'''
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         ans = self.helper(coins,amount,0)
#         return ans
    
#     # int function returns combinations
#     def helper(self,coins,amount,idx):
#         # Base Condition
#         if amount==0:
#             return 1
#         if idx==len(coins) or amount<0:
#             return 0

#         # No choose
#         case1 = self.helper(coins,amount,idx+1)

#         # choose
#         case2 = self.helper(coins,amount-coins[idx],idx)
        
#         return case1+case2

'''
Solution 2: Recursion with memoization
at each iteration, I have 2 options, choose/no-choose. I keep maintaining a hashMap
to store the values. {(start_idx,amount) : # of ways} Start idx tells me about how many
denominations I have. 
Base condition: if remaining amount=0 | all types of coins considered | amount<0
Time Complexity: O(m x n), m = Different denomination of coins, n = amount
Space Complexity: O(m x n)
'''
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         self.mem = {}
#         ans = self.helper(coins,amount,0)
#         return ans

    
#     # int type function
#     def helper(self,coins,amount,idx):
#         # Base Condition
#         if amount==0:
#             return 1 # we got a combination
#         if idx==len(coins) or amount<0:
#             return 0 # no combinations found

#         if (idx,amount) in self.mem:
#             return self.mem[(idx,amount)] # memoization

#         # No choose
#         case1 = self.helper(coins,amount,idx+1) # combinations from not choosing

#         # choose
#         case2 = self.helper(coins,amount-coins[idx],idx) # combinations from choosing

#         self.mem[(idx,amount)] = case1 + case2

#         return case1 + case2

'''
Solution 3: DP array
rows = different denomination coins, 
cols = amount 
We'll add a dummy row with coin value = 0
Overlapping repeated sub-problems : with coin [2,5] to make amount 6 
Time complexity: O(m x n) , m = different denomination coins, n = Amount
Space Complexity: O(m x n), matrix (tabulation)  
'''
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        rows = len(coins) + 1 # dummy row with coin denomination = 0
        cols = amount + 1 # amount : 0 - amount 
        dp_mat = [[None]*cols for i in range(rows)]

        # first row
        for j in range(cols):
            dp_mat[0][j] = 0 # with coin denomination 0, I can't make any combinations to meet desired amount
        
        dp_mat[0][0] = 1 #Coin_denomination = 0, amount =0, 1 way 
        
        # first col: Denomination = x, amount = 0, 1 way - (not choose that coin)
        for i in range(1,rows):
            dp_mat[i][0] = 1


        for i in range(1,rows):
            for j in range(1,cols):
                # denomination > amount, only no choose condition
                if coins[i-1]>j:
                    dp_mat[i][j] = dp_mat[i-1][j]
                else:
                    # no choose ways
                    case1 = dp_mat[i-1][j]
                    # choose ways
                    case2 = dp_mat[i][j-coins[i-1]]
                    dp_mat[i][j] = case1 + case2

        return dp_mat[-1][-1]

