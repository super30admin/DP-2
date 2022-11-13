class Solution:
    """
    Time complexity : O(n) - n - number of houses
    Space complexity : O(1)
    """
    def minCost(self, costs: list[list[int]]) -> int:
        # stores the minimum cost of painting till previous house with colors red, blue and green respectively.
        prev_choice = [0,0,0]
        # stores the minimum cost of painting till current house with colors red, blue and green respectively.
        curr_choice = [0,0,0]
        n = len(costs)
        for j in range(0,n):
            # for each choice of color for the current house, calculate costs using prev_choice array.
            i = 0
            curr_choice[i] = min(prev_choice[i+1], prev_choice[i+2]) + costs[j][i]
            i = 1
            curr_choice[i] = min(prev_choice[i-1], prev_choice[i+1]) + costs[j][i]
            i = 2
            curr_choice[i] = min(prev_choice[i-1], prev_choice[i-2]) + costs[j][i]
            # curr_choice will be used in for next house as prev_choice
            prev_choice = curr_choice.copy()
            
        return min(curr_choice[0], curr_choice[1], curr_choice[2])