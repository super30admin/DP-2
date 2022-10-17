# As I am using the bottom-up approach
# TC: O(n)
# SC:O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        n=len(nums)
        
        if n==1:
            return nums[0]
        
        rob_next_next=0
        rob_next=nums[n-1]
        
        for i in range(n-2,-1,-1):
            cur=max(nums[i]+rob_next_next,rob_next)
            
            rob_next_next=rob_next
            rob_next=cur
        return rob_next