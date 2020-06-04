# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    # Iteravtive solution , TC = O(n) | SC = O(1)
    def paintHouses(self,nums):
        if not nums or len(nums)==0:
            return 0 
        for i in range(1,len(nums)):
            nums[i][0] = nums[i][0] + min(nums[i-1][1],nums[i-1][2])
            nums[i][1] = nums[i][1] + min(nums[i-1][0],nums[i-1][2])
            nums[i][2] = nums[i][2] + min(nums[i-1][0],nums[i-1][1])
        return min(nums[-1])
    
    # Recursive solution, TC = 3 x O(2 ^ n) | SC = 3 x O(2 ^ n)
    # def paintHouses(self,nums):
    #     if not nums or len(nums) == 0:
    #         return 0 
        
    #     case1 = self.helper(nums,0,0,0)
    #     case2 = self.helper(nums,0,0,1)
    #     case3 = self.helper(nums,0,0,2)
    #     return min(case1,case2,case3)
    
    # def helper(self,nums,min1,row,color):
    #     #base case 
    #     if row == len(nums):
    #         return min1
    #     case1 = case2 = case3 = float("inf")
    #     #logic 
    #     if color == 0:
    #         case1 = min(self.helper(nums,min1+nums[row][1],row+1,1), self.helper(nums,min1 + nums[row][2],row+1,2))
        
    #     if color == 1:
    #         case2 = min(self.helper(nums,min1+nums[row][0],row+1,0), self.helper(nums,min1 + nums[row][2],row+1,2))
        
    #     if color == 2 :
    #         case3 = min(self.helper(nums,min1+nums[row][1],row+1,1), self.helper(nums,min1 + nums[row][0],row+1,0))
        
    #     return min(case1,case2,case3)
           

if __name__ == "__main__":
    s = Solution()
    nums = [[17,2,17],[16,16,5],[14,3,19]]
    res = s.paintHouses(nums)
    print(res)