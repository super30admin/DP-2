'''
# Problem 198: Paint House

## Author: Neha Doiphode
## Date:   07-06-2022

## Description:
    There is a row of n houses, where each house can be painted one of three colors: red, blue, or green.
    The cost of painting each house with a certain color is different.
    You have to paint all the houses such that no two adjacent houses have the same color.
    The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

    For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
    Return the minimum cost to paint all houses.

## Examples:
    Example 1:
        Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
        Output: 10
        Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
        Minimum cost: 2 + 5 + 3 = 10.

    Example 2:
        Input: costs = [[7,6,2]]
        Output: 2

## Constraints:
    costs.length == n
    costs[i].length == 3
    1 <= n <= 100
    1 <= costs[i][j] <= 20

## Approaches:
    Try 1: Greedy
    Try 2: Exhaustive(can be done with recursive function)
    Try 3: Dynamic programming(If exhaustive runs into solving repetive problems then we should choose dynamic programming as optimization)

## Notes:
    0 = red, 1 = blue, 2 = green

                0     1    2
                R     B    G
        0      17     2    17
        1      16     16    5
        2      14     3    19

## Time complexity: O(n), where n is the number of houses.

## Space complexity: O(1), since we are not using any auxiliary dp array.

'''

from typing import List

def get_input():
    print("Enter the number of houses to be painted: ", end = "")
    number_of_houses = int(input())
    print("Enter cost to paint each house with a certain color(in the order Red Blue Green and with spaces, for example: 10(R) 12(B) 10(G)).")
    houses = []
    for house in range(number_of_houses):
        print(f"House {house + 1}: ", end = "")
        inp_list = input()
        inp_list = [int(value) for value in inp_list.split()]
        houses.append(inp_list)
    return houses

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:

        n = len(costs)

        # Start from the last house
        # Note: This solution modifies the original array
        for i in range(n-2, -1, -1):
            costs[i][0] = costs[i][0] + min(costs[i + 1][1], costs[i + 1][2])
            costs[i][1] = costs[i][1] + min(costs[i + 1][0], costs[i + 1][2])
            costs[i][2] = costs[i][2] + min(costs[i + 1][0], costs[i + 1][1])
        return min(costs[0][0], costs[0][1], costs[0][2])

# Driver code
solution = Solution()
houses = get_input()
print(f"Input list of houses: {houses}")
print(f"Dynamic programming: Minimum cost to paint all houses: {solution.minCost(houses)}")
