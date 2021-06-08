# Time Complexity: O(n)
# Space Complexity: O(1)
# ran on leetcode : Yes

class Solution(object):
    def minCost(self, costs):
        # check for null
        if len(costs) == 0:
            return 0
        # for each color take second to last row
        curr_r = costs[len(costs) - 1][0]
        curr_g = costs[len(costs) - 1][1]
        curr_b = costs[len(costs) - 1][2]
        # iterating reversely and updating based on next row values
        for i in range(len(costs)-2,-1,-1):
            temp_r = curr_r  # Red
            temp_g = curr_g  # Blue

            # updating the current variable with current value and minimum between other two color value in next row
            curr_r = costs[i][0] + min(curr_b, curr_g)
            curr_g = costs[i][1] + min(temp_r, curr_b)
            curr_b = costs[i][2] + min(temp_r, temp_g)

        # return min
        return min(curr_r, min(curr_b, curr_g))
