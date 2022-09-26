# Time Complexity : O(N+M) where M is the maximum value of nums array and N is the number of elements in the nums array
# Space Complexity : O(M)  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this: No


# Your code here along with comments explaining your approach
class Solution(object):
    def deleteAndEarn(self, nums):
        #base case
        if not nums or len(nums) == 0:
            return 0
        #creating an array of integers by adding the individual numbers of nums together to corresponding indices
        res = [0 for i in range(max(nums)+1)]
        for i in range(len(nums)):
            res[nums[i]] += nums[i]
        
        n = len(res)
        col = 2
        #creating the dp array
        dp = [[0 for j in range(col)] for i in range(len(res))]  
        dp[0][1] = res[0]
        for i in range(len(res)):
            #not choosing to earn points
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
            #chossing to earn points
            dp[i][1] = res[i] + dp[i - 1][0]
        
        return max(dp[n - 1])

if __name__ == "__main__":
    de = Solution()
    nums = [3, 4, 2]
    ans = de.deleteAndEarn(nums)
    print(ans)