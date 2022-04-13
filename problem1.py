#paint house

# // Time Complexity : O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no




def paintHouse(nums):
    dp = [[0 for i in range(3)] for j in range(len(nums))]

    for i in range(3):
        dp[0][i] = nums[0][i]                   #copy the first row to a new array
    
    for i in range(1, len(nums)):                                       #for each column, the cost should be that column's cost + cost of the other two arrays on the previous row
        dp[i][0] = nums[i][0] + min(dp[i-1][1],dp[i-1][2])
        dp[i][1] = nums[i][1] + min(dp[i-1][0],dp[i-1][2])
        dp[i][2] = nums[i][2] + min(dp[i-1][1],dp[i-1][0])
    return min(dp[len(nums)-1][0], dp[len(nums)-1][1], dp[len(nums)-1][2])


#test

costs = [[17,2,17],[16,16,5],[14,3,19]]
print(paintHouse(costs))