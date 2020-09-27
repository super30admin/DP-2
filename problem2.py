# Time Complexity: O(M) M is the max amount in the array
# Space Complexity: O(1) 
# Passed Leetcode 

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        
        m = {}
        max_value = -float("inf")
        for i in range(len(nums)):
            if nums[i] > max_value:
                max_value = nums[i]
            
            if nums[i] not in m:
                m[nums[i]] = 0
            m[nums[i]] += 1
        #Leave, Pick
        dp = (0,0)

        for i in range(1, max_value + 1):
            
            count = 0
            if i in m:
                count = m[i]
            
            leave = max(dp)
            pick = dp[0] + i * count
            
            dp = (leave, pick)
        return max(dp)
    
    

    
    