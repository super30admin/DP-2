# Time Complexity : O(m) where m is the number of houses.
# Space Complexity : O(m) where m is the number of houses.
# Did this code successfully run on Leetcode : Yes.
# Any problem you faced while coding this : Solution based on discussion in class.
class Solution:
    def rob(self, nums: List[int]) -> int:
#         def helper(nums,index,amount):
#             # base
#             if index >= len(nums):
#                 return amount
            
#             # logic
#             # choose
#             case1 = helper(nums,index + 2, amount + nums[index])
            
#             # not choose
#             case2 = helper(nums,index+1,amount)
#             return max(case1,case2)
#         return helper(nums,0,0)
        dp = [[None for i in range(2)] for j in range(len(nums))]
        dp[0][0] = 0
        dp[0][1] = nums[0]
        for i in range(1,len(nums)):
            #Not choose
            dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            #choose
            dp[i][1] = dp[i-1][0] + nums[i]
        return max(dp[len(nums)-1])
