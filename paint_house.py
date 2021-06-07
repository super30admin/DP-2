# Time Complexity: O(n x 3) = O(n)
# Space Complexity: O(1)
class Solution(object):
    def minCost(self, costs):
        #         check if given matrix has any elements or not
        if len(costs) == 0:
            return 0
        #       Take second last row values of given matrix in variables for respective colors
        curr_r = costs[len(costs) - 1][0]
        curr_g = costs[len(costs) - 1][1]
        curr_b = costs[len(costs) - 1][2]
        #         Now iterate reversly over the matrix and update the defined variables based on next row values
        for i in range(len(costs) - 2, -1, -1):
            temp_r = curr_r  # Red
            temp_g = curr_g  # Blue

            #           update the current variable with current value and minimum between other two color value in next row
            curr_r = costs[i][0] + min(curr_b, curr_g)
            curr_g = costs[i][1] + min(temp_r, curr_b)
            curr_b = costs[i][2] + min(temp_r, temp_g)

        #         In the end return minimum between three variable values
        return min(curr_r, min(curr_b, curr_g))

        """
        :type costs: List[List[int]]
        :rtype: int
        """
