#Not Mutating Matrix-
""""// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
def minCost(cost):
    if not cost or len(cost)==0:
        return 0
    n=len(cost)
    Red = cost[n - 1][0]
    Blue = cost[n - 1][1]
    Green = cost[n - 1][2]

    for i in range(n-2,-1,-1):
        TempRed=Red
        TempBlue=Blue
        TempGreen=Green
        Red = cost[i][0]+min(TempBlue, TempGreen)
        Blue = cost[i][1]+min(TempRed, TempGreen)
        Green = cost[i][2]+min(TempRed ,TempBlue)
    return min(Red ,Blue, Green)

print(minCost([[17,2,17],[16,16,5],[14,3,19]]))



#Not Mutating Matrix-
""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# def minCost(cost):
#     if not cost or len(cost)==0:
#         return 0
#     n=len(cost)
#     dp = [[0 for i in range(n)] for j in range(3)]
#     dp[n - 1][0] = cost[n - 1][0]
#     dp[n - 1][1] = cost[n - 1][1]
#     dp[n - 1][2] = cost[n - 1][2]
#
#     for i in range(n-2,-1,-1):
#         dp[i][0] = cost[i][0]+min(dp[i + 1][1] , dp[i + 1][2])
#         dp[i][1] = cost[i][1]+min(dp[i + 1][0] , dp[i + 1][2])
#         dp[i][2] = cost[i][2]+min(dp[i + 1][0] , dp[i + 1][1])
#     return min(dp[0][0], dp[0][1], dp[0][2])
#
# print(minCost([[17,2,17],[16,16,5],[14,3,19]]))


#Mutating Matrix-
""""// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# def minCost(cost):
#     if not cost or len(cost)==0:
#         return 0
#     n=len(cost)
#
#     for i in range(n-2,-1,-1):
#         cost[i][0] += min(cost[i + 1][1] , cost[i + 1][2])
#         cost[i][1] += min(cost[i + 1][0] , cost[i + 1][2])
#         cost[i][2] += min(cost[i + 1][0] , cost[i + 1][1])
#     return min(cost[0][0], cost[0][1], cost[0][2])
#
# print(minCost([[17,2,17],[16,16,5],[14,3,19]]))




#Exhaustive Approach(Recursive)
# def minCost(cost):
#     if not cost or len(cost)==0:
#         return
#     CaseR = helper(cost, 0, 0, 0)
#     CaseB = helper(cost, 0, 1, 0)
#     CaseG = helper(cost, 0, 2, 0)
#     return min(CaseR, min(CaseB, CaseG))
# def helper(cost, r, color, minCost):
#
#     #base
#     if r==len(cost):
#         return minCost
#
#     #logic
#     if color==0:
#         return min(helper(cost, r+1, 1, minCost+cost[r][0]), helper(cost, r+1, 2, minCost+cost[r][0]))
#     if color==1:
#         return min(helper(cost, r+1, 0, minCost+cost[r][1]), helper(cost, r+1, 2, minCost+cost[r][1]))
#     if color==2:
#         return min(helper(cost, r+1, 0, minCost+cost[r][2]), helper(cost, r+1, 1, minCost+cost[r][2]))
#     return 9
#
# print(minCost([[17,2,17],[16,16,5],[14,3,19]]))
