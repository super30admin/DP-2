# Time Complexity : O(N+1*3) - N no of houses
# Space Complexity : O(N+1*3)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        no_of_houses = len(costs)
        DP_matrix = [[0 for _ in range(3)] for _ in range(no_of_houses+1)]
        for i in range(1, no_of_houses+1):
            for j in range(3):
                DP_matrix[i][j] = costs[i-1][j] + min(DP_matrix[i-1][(j+1)%3], DP_matrix[i-1][(j+2)%3])
        print(DP_matrix)
        return min(DP_matrix[no_of_houses][0], DP_matrix[no_of_houses][1], DP_matrix[no_of_houses][2] )