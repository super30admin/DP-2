"""
    There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
    The cost of painting each house with a certain color is different.
    You have to paint all the houses such that no two adjacent houses have the same color.

    The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
    For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2]
    is the cost of painting house 1 with color green, and so on.
    Find the minimum cost to paint all houses.

    Follow Up: Optimize for Space
"""
from math import inf


class Solution:

    def min_cost(self, costs):
        """
            // Time Complexity : O(n)
                        'n' is the number of houses. The colors are constant
            // Space Complexity : O(n)
            // Did this code successfully run on Leetcode : Premium Question
            // Any problem you faced while coding this :
                    Took time to think about the sub problems
            // Your code here along with comments explaining your approach
                    At item in the dp table answers to the question -
                    If I have these many houses and these colors what is the
                    minimum cost to paint till that house. We use these sub
                    problems to find the overall minimum for all the houses
                    by storing results of the sub problems.
        """
        # Edge case
        if not costs:
            return 0

        no_of_houses = len(costs)
        no_of_colors = len(costs[0])
        dp = [[None for color in range(no_of_colors)] for house in range(no_of_houses)]
        for color in range(no_of_colors):
            dp[0][color] = costs[0][color]

        for house in range(1, no_of_houses):
            dp[house][0] = costs[house][0] + min(dp[house - 1][1], dp[house - 1][2])
            dp[house][1] = costs[house][1] + min(dp[house - 1][0], dp[house - 1][2])
            dp[house][2] = costs[house][2] + min(dp[house - 1][0], dp[house - 1][1])
        return min(dp[house][0], dp[house][1], dp[house][2])

    # def min_cost_brute_force(self, costs):
    #     return self._helper(costs, 0, 0, [0, 1, 2])
    #
    # def _helper(self, costs: int, min_cost: int, house_number: int, remaining_color: list):
    #     # base case
    #     if house_number == len(costs):
    #         return min_cost
    #
    #     # case 1
    #     # we choose to paint the house with red, then we can only choose between blue and green
    #     if 0 in remaining_color:
    #         red_cost = self._helper(costs, min_cost + costs[house_number][0], house_number + 1, [1, 2])
    #     else:
    #         red_cost = inf
    #     # case 2
    #     # we choose to paint the house with blue, then we can only choose between red and green
    #     if 1 in remaining_color:
    #         blue_cost = self._helper(costs, min_cost + costs[house_number][1], house_number + 1, [0, 2])
    #     else:
    #         blue_cost = inf
    #     # case 3
    #     # we choose to paint the house with green, then we can only choose between red and blue
    #     if 2 in remaining_color:
    #         green_cost = self._helper(costs, min_cost + costs[house_number][2], house_number + 1, [0, 1])
    #     else:
    #         green_cost = inf
    #     return min(red_cost, blue_cost, green_cost)

    def min_cost_brute_force(self, costs):
        """
            // Time Complexity : O(3 * 2^n)
                        We will have three trees. One for each color
                        'n' is the number of houses.
            // Space Complexity : O(n) if stack space is considered
        """
        # initial amount is 0

        # choosing red color for the first house
        case_1 = self._helper(costs, 0, 0, 0)
        # choosing blue color for the first house
        case_2 = self._helper(costs, 0, 0, 1)
        # choosing green color for the first house
        case_3 = self._helper(costs, 0, 0, 2)

        return min(case_1, case_2, case_3)

    def _helper(self, costs: int, amount: int, house: int, color: int):
        # base case
        if house == len(costs):
            return amount

        # for each house we will have two cases
        case_1 = case_2 = 0

        # logic

        # case 1
        # we choose to paint the current house with red color
        if color == 0:
            # add the cost to paint the current house with red
            # we can choose blue for the next house
            case_1 = self._helper(costs, amount + costs[house][0], house + 1, 1)
            # or we can choose green for the next house
            case_2 = self._helper(costs, amount + costs[house][0], house + 1, 2)

        # case 2
        # we choose to paint the current house with blue color
        elif color == 1:
            # add the cost to paint the current house with blue
            # we can choose red for the next house
            case_1 = self._helper(costs, amount + costs[house][1], house + 1, 0)
            # or we can chose green for the next house
            case_2 = self._helper(costs, amount + costs[house][1], house + 1, 2)

        # case 3
        # we choose to paint the current house with green color
        elif color == 2:
            # add the cost to pain the current house with green
            # we can choose red for the next house
            case_2 = self._helper(costs, amount + costs[house][2], house + 1, 0)
            # or we can choose blue for the next house
            case_1 = self._helper(costs, amount + costs[house][2], house + 1, 1)

        return min(case_1, case_2)


if __name__ == '__main__':
    """
              R   B   G
    """
    h = Solution()
    costs = [[17, 2, 4],
             [7, 16, 5],
             [4, 6, 7],
             [1, 50, 100]]
    print(h.min_cost_brute_force(costs))
    print(h.min_cost(costs))
    costs = [[5, 17, 4],
             [6, 17, 3],
             [21, 1, 10]]
    print(h.min_cost_brute_force(costs))
    print(h.min_cost(costs))
    costs = [[17, 2, 17],
             [16, 16, 5],
             [14, 3, 19]]
    print(h.min_cost_brute_force(costs))
    print(h.min_cost(costs))
