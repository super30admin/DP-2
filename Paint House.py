# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : NO (Premium)
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

#exhaustive approach - TLE
#TC - O((m-1)^n) m = no of colors n= no of house
def minCost(costs):
    caseR = helper(costs,0,0,0)
    caseB = helper(costs,0,1,0)
    caseG = helper(costs,0,2,0)
    return min(caseB,caseG,caseR)

def helper(costs, index, color, amount):
    #base
    if index == len(costs):
        return amount


    #logic
    if color == 0: #red
        return min(helper(costs, index+1, 1, amount+costs[index][0]),
                    helper(costs,index+1,2,amount+costs[index][0]))
    if color == 1: #blue
        return min(helper(costs, index+1, 0, amount+costs[index][1]),
                    helper(costs,index+1,2,amount+costs[index][1]))
    if color == 2: #green
        return min(helper(costs, index+1, 0, amount+costs[index][2]),
                    helper(costs,index+1,1,amount+costs[index][2]))




#dp approach with 2D array 
#TC & SC - O(n)
def minCostDP2D(costs):
    if costs == None or len(costs) == 0 :
        return 0

    n = len(costs) #no of huoses
    dp = [[0 for i in range(3)] for j in range(3)]

    #base case
    dp[0][0] = costs[0][0]
    dp[0][1] = costs[0][1]
    dp[0][2] = costs[0][2]

    for i in range(1, n, 1):
        # red
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0]
 
        # blue
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1]
 
        # green
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2]
 
    return (min(dp[n- 1][0], min(dp[n - 1][1],dp[n - 1][2])))



#dp approach with 1D array 
#TC & SC - O(n) & O(1)
def minCostDP1D(costs):
    dp = [0,0,0]

    for i in range(len(costs)):
        dp0 = costs[i][0] + min(dp[1],dp[2])
        dp1 = costs[i][1] + min(dp[0],dp[2])
        dp2 = costs[i][2] + min(dp[0],dp[1])
        dp = [dp0,dp1,dp2]
    return min(dp)




costs=[[17,2,17],[16,16,5],[14,3,19]]
print(minCost(costs))
print(minCostDP2D(costs))
print(minCostDP1D(costs))
