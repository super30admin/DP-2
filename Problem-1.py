#Time Complexity : O(n)
#Space Complexity : O(1) 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
       
        prev_red = 0
        prev_green = 0
        prev_blue = 0
        
        for cost_red, cost_green, cost_blue in costs:

            curr_red = min(prev_green, prev_blue) + cost_red
            curr_green = min(prev_red, prev_blue) + cost_green
            curr_blue = min(prev_red, prev_green) + cost_blue

            prev_red = curr_red
            prev_green = curr_green
            prev_blue = curr_blue
            
        return min(prev_red, prev_green, prev_blue)
