"""
# DP-2

## Problem1(https://leetcode.com/problems/paint-house/)
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
  Find the minimum cost to paint all houses.

Follow Up: Optimize for Space

Example:

Input: [[17,2,17],[16,16,5],[14,3,19]]
Output: 10

Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.

Minimum cost: 2 + 5 + 3 = 10.
// Time Complexity : O(mn) m here is 3 as we have 3 colors so we can say O(3n) or O(n)
// Space Complexity : O(mn) m here is 3 as we have 3 colors so we can say O(3n) or O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
"""
def Paint_house(costs):
    if len(costs)==0:    #if no houses then cost of paint is 0
        return 0
    dp=[[0]*3 for i in range(len(costs))]  # create a dp matrix
    print(dp)

    for i in range(3):               # copy first row think as if we have only 1 house
        dp[0][i]=costs[0][i]


    for i in range(1,len(costs)):   # loop starts from 1 as we have filled the dp matrix above with first row of costs

        # first position in dp matrix, means we are choosing red color
        # hence we will pick the min cost from previous row of other two colours green or blue plus cost of painting red
        dp[i][0] = costs[i][0] + min(costs[i-1][1],costs[i-1][2])

        # 2nd position in dp matrix, means we are choosing Blue color
        # hence we will pick the min cost from previous row of other two colours green or red plus cost of painting blue
        dp[i][1] = costs[i][1] + min(dp[i - 1][0], dp[i - 1][2])

        # 3rd position in dp matrix, means we are choosing green color
        # hence we will pick the min cost from previous row of other two colours blue or red plus cost of painting green
        dp[i][2] = costs[i][2] + min(dp[i - 1][0], dp[i - 1][1])

    return min(dp[len(costs)-1][0],dp[len(costs)-1][1],dp[len(costs)-1][2]) # return min  from last row of dp matrix


print(Paint_house([[17,2,17],[16,16,5],[14,3,19],[14,19,3]]))








