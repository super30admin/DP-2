from typing import List

"""

    Student : Shahreen Shahjahan Psyche

    Brute-Force/Recursive:
        Time Complexity : O(2^n)
        Space Complexity : O(n)
    This solution faced time limit exceeded error in Leetcode

    Dynammic Programming:
        Time Complexity : O(mn)
        Space Complexity : O(mn)
    This solution successfully passed all the test cases in Leetcode


"""

class Solution:
    
    # BF Solution
    def _helper_bf(self, amount, coins, index, num_paths):
        
        # Base-case
        if amount < 0:
            return 0
        if amount == 0:
            return 1
        if index > len(coins) - 1:
            return 0
        
        # Zero- case
        case1 = self._helper_bf(amount, coins, index+1, num_paths)
        # One-case
        case2 = self._helper_bf(amount-coins[index], coins, index, num_paths)
        
        # As our goal is to get the number of paths, thats why we are adding up the cases
        num_paths = case1 + case2
        
        return num_paths
    
    # DP Solution
    def _helper_dp(self, amount, coins):
        
        # Intializing the size of the matrix
        m = len(coins) + 1
        n = amount + 1
        
        # Intilizing the matrix with 0
        records = [[0 for _ in range(n)] for _ in range(m)]
        
        # For amount 0, only 1 possible num of ways possible for any coin
        for i in range(m):
            records[i][0] = 1
        
        # With coin 0, without 0 amount, other amounts are not possible to make. Thats why the values are put by default to 0
        for j in range(1,n):
            records[0][j] = 0
        
        # Filling up the matrix
        for i in range(1, m):
            for j in range(1, n):
                # As before the amount that is less than the current coin is not possible to make with the current coin, thats why
                # I am choosing the zero case only
                if j < coins[i-1]:
                    records[i][j] = records[i-1][j]
                else:
                # Adding up the zero case and one case
                    records[i][j] = records[i-1][j] + records[i][j-coins[i-1]]
        
        return records[m-1][n-1]
                     
    # Driver method
    def change(self, amount: int, coins: List[int]) -> int:
        
        if amount == 0:
            return 1
        if coins is None or len(coins) == 0:
            return 0
        # Brute Force
        num_paths = self._helper_bf(amount, coins, 0, 0)
        # DP
        num_paths = self._helper_dp(amount, coins)
        
        return num_paths
        
        
        
        