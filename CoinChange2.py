# Time Complexity : O(m*n) where m is the number of denominations available and n is the amount + 1

#  Space Complexity : O(m*n)

# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
#I maintain a 2d array where I keep the track of number of ways required to reach the amount.

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        if coins == None or len(coins) == 0:
            if amount == 0:
                return 1
            else:
                return 0

        m, n = len(coins) + 1, amount + 1
        nums = [[0] * n] * m
        nums[0][0] = 1

        for i in range(1, m):
            for j in range(1, n):
                if j < coins[i - 1]:
                    nums[i][j] = nums[i - 1][j]
                else:
                    nums[i][j] = nums[i - 1][j] + nums[i][j - coins[i - 1]]
        print(nums)

        return nums[m - 1][n - 1]




