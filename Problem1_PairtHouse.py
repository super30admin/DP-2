#Time Complexity: O(3n) => O(n)
#Space Complexity: O(1)
#Leetcode: Should Work

class Solution:
    def paintHouse(self, nums):
        if len(nums) == 0 or nums ==None:
            return
        
        for i in range(len(nums)-2, -1,-1):
            for j in range(len(nums[i])):
                if j == 0:
                    nums[i][j] = nums[i][j]+min(nums[i+1][1], nums[i+1][2])
                if j == 1:
                    nums[i][j] = nums[i][j]+min(nums[i+1][0], nums[i+1][2])
                if j == 2:
                    nums[i][j] = nums[i][j]+min(nums[i+1][0], nums[i+1][1])

        return min(nums[0])

obj = Solution()
nums = [[17,2,3],[16,1,5],[5,3,4],[4,10,15]]
print(obj.paintHouse(nums))
