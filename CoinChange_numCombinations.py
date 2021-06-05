class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        arr = [[None for _ in range(0,(amount)+1)] for _ in range(len(coins)+1)]
        for i in range(len(arr)):
            arr[i][0]=1
        for i in range(1, len(arr[0])):
            arr[0][i]=0
        for i in range(1, len(arr)):
            for j in range(1, len(arr[0])):
                if coins[i-1]>j:
                    arr[i][j]=arr[i-1][j]
                else:
                    arr[i][j]=arr[i-1][j]+arr[i][j-coins[i-1]]
        return arr[len(arr)-1][len(arr[0])-1]
#         if not coins:
#             return 0
#         return self.helper(amount, coins, 0)
    
#     def helper(self, amount: int, coins: List[int], index):
#         print("hi")
#         if amount==0:
#             return 1
#         elif index==len(coins) or amount<0:
#             return 0
#         case1=self.helper(amount-coins[index], coins, index)
#         case2=self.helper(amount, coins, index+1)
#         return case1+case2

""" Time complexity - O(nm) where n is the number of coins and m is the amount given
# space complexity - O(nm) as we are utilizing array as the intermediate data structure for dynamic programming.

For the commented recursion code, the time complexity would be 2^n 
and space complexity O(n) where n is the number of coins"""
        