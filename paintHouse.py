# Time complexity :- O(n)
# Space complexity :- O(n)

# Ran on leetcode :- yes
# I was able to solve it after drawing recursion tree. Yet to figure out bottom-up appraoch


class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def minCost(self, costs):
        # write your code here
        
        self.dp = {}
        
        self.n = len(costs)
        
        if self.n == 0:
            return 0
        if self.n == 1:
            return min(costs[0])
        
        self.colors = [0,1,2]
        
        r_select = costs[0][0] + self.helper(1,costs,[1,2])
        g_select = costs[0][1] + self.helper(1,costs,[0,2])
        b_select = costs[0][2] + self.helper(1,costs,[0,1])
        
        return min(r_select,g_select,b_select)

    
    def helper(self, house_no, costs, house_cost_index):

        if house_no  == self.n:
            return 0
            
        if (house_no,str(house_cost_index)) in self.dp:
            return self.dp[house_no, str(house_cost_index)]
        
        
        first_index = list(set([0,1,2]) - {house_cost_index[0]})
        first_option = costs[house_no][house_cost_index[0]] + self.helper(house_no +1, costs, first_index)
        second_index = list(set([0,1,2]) - {house_cost_index[1]})
        second_option = costs[house_no][house_cost_index[1]] + self.helper(house_no+1, costs, second_index)
        
        final_cost = min(first_option,second_option)
        self.dp[house_no,str(house_cost_index)] = final_cost
        
        return final_cost