class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0

        red, blue, green = costs[0]

        for i in range(1, len(costs)):
            new_red = costs[i][0] + min(blue, green)
            new_blue = costs[i][1] + min(red, green)
            new_green = costs[i][2] + min(red, blue)

            red, blue, green = new_red, new_blue, new_green

        return min(red, blue, green)

        # Time Complexity: O(n), where n is the number of houses
        # Space Complexity: O(1)