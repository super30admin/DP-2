# // Time Complexity : O(3n) = O(n)
# // Space Complexity : O(3n) = O(n)
# // Did this code successfully run on Leetcode : It should. But I couldnt try since I didnot have premium. I tested with testcases manuallly
# // Any problem you faced while coding this : No


# I tried to formulate this in a matrix. But everytime we need to calculate teh cost of each house(a row is a house) we just need info from previous row. So instead of storing it in a matrix, i used array
# dp array to store the costs of painting houses with colors respec. costs[i][j] means i=house, j=color. since no adjacent house can be same color, every time we calculate the costs, we take min of other two colors

dp=[0,0,0]
# input given manually:
costs=[[17,2,17], [16,16,5], [14,3,19]]
for i in range(len(costs)):
    dp0=costs[i][0]+min(dp[1],dp[2])
    dp1=costs[i][1]+min(dp[0],dp[2])
    dp2=costs[i][2]+min(dp[0],dp[1])
    dp=[dp0, dp1, dp2]
print(min(dp))