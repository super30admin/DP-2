#Time Complexity: O(n)
#Space Complexity: O(n)

class Solution:
    def rob(self, nums: List[int]) -> int:
        dp=[0 for i in range(len(nums))]
        #if len is less than 2
        if len(nums)<=2:
            return max(nums)
        dp[0]=nums[0]
        dp[1] = max(nums[0], nums[1])
        #Logic starts from 2nd index
        for i in range(2, len(nums)):
            #if we don't choose nums[i] then choose dp[i-1]
            #else nums[i]+ Value of 2 elements before that in dp array
            #take maximum of both
            dp[i] = max(dp[i-1], nums[i]+dp[i-2])
        return dp[-1]