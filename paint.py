class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def minCost(self, costs):
        # write your code here
        # DP
        # TC O(n)
        # SC O(1)
        if costs is None or len(costs) == 0:
            return 0

        # Start from second last row
        for i in range(len(costs)-2,-1,-1):
            costs[i][0] += min(costs[i+1][1],costs[i+1][2])
            costs[i][1]+= min(costs[i+1][0],costs[i+1][2])
            costs[i][2] += min(costs[i+1][1],costs[i+1][0])
        return min(costs[0][0],costs[0][1],costs[0][2])

    # Exhaustive search : Time limit exceeded

    # def minCost(self, costs):
    #     # write your code here
    #     if costs is None or len(costs) == 0:
    #         return 0
    #     def helper(costs, row, color, minCost):
    #         # base
    #         if row == len(costs):
    #             return minCost

    #         #logic
    #         if color == 0:
    #             #Cost = minimum cost + current row and current color ie 0 
    #             return min(helper(costs, row + 1,1, minCost + costs[row][0]),
    #             helper(costs, row + 1,2, minCost + costs[row][0]))
    #         if color == 1:
    #             #Cost = minimum cost + current row and current color ie 1
    #             return min(helper(costs, row + 1,0, minCost + costs[row][1]),
    #             helper(costs, row + 1,2, minCost + costs[row][1]))
            
    #         #Cost = minimum cost + current row and current color ie 0 
    #         return min(helper(costs, row + 1,1, minCost + costs[row][2]),
    #         helper(costs, row + 1,0, minCost + costs[row][2]))
            
           
    #     case1 = helper( costs, 0, 0 , 0)
    #     case2 = helper( costs, 0, 1 , 0)
    #     case3= helper( costs, 0, 2 , 0)
    #     return min(case1,case2,case3)
       

