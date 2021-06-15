class Solution:
    def minCost(self, costs: List[List[int]]) -> int:

        if not costs:
            return 0
        
        #Looping over the costs list in reverse calculating the total cost from second last row element
        for n in reversed(range(len(costs)-1)):

            #Calculating the total cost of painting the house red

            costs[n][0] = costs[n][0] + min(costs[n+1][1],costs[n+1][2])

            #Calculating the total cost of painting the house b;ue

            costs[n][1] = costs[n][1] + min(costs[n+1][0],costs[n+1][2])

            #Calculating the total cost of painting the house green

            costs[n][2] = costs[n][2] + min(costs[n+1][0],costs[n+1][1])

        #Returning the minimum costs from the first row
        return min(costs[0])

#The problem calculates the minimum cost of painting the houses with no adjacent houses with same color and each house having diff cost for each color
#Solved this problem using dynamic programming iterating over bottom up.
#Time complexity - O(n)
#Space complexity - O(1)
