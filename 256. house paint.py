# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : No premium subscription
# Any problem you faced while coding this : No

class HousePainting(object):
    '''
    Create a matrix with column of RGB colors and 
    rows storing the minimum cost if that color is selected 
    for that specific house number.
    '''

    def minCost(self, costs):
        if (costs == None or len(costs) <= 0):
            return -1
        
        result = [[None for i in range(3)] for j in range(len(costs))]

        # base case initialization
        for i in range(3):
            result[0][i] = costs[0][i]

        for i in range(1, len(costs)):
            result[i][0] = result[i][0] + min(result[i-1][1], result[i-1][2])
            result[i][1] = result[i][1] + min(result[i - 1][0], result[i - 1][2])
            result[i][2] = result[i][2] + min(result[i - 1][1], result[i - 1][0])

        return min(result[len(costs) - 1][0], min(result[len(costs) - 1][1], result[len(costs) - 1][2]))