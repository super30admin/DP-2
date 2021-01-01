'''
    Time Complexity:
        O(n) (where n = number of houses)
        -> The height of the tree will be n and each node will have as much
            as 2 children (except the root). So, actually the TC = O(2n).

    Space Complexity:
        O(n) (where n = number of houses)
        -> Since key of the HashMap is a tuple of (house, paint), at the most
            there could be 3n k,v pairs in the HashMap.

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        -> The deciding factor at each step is the current house and the previous
            house's paint color. So, the variables are house and prev_paint.
        -> For all the three paints, find the min cost of painting this house
            with the colors which != prev house's paint color.
        -> Return the min cost.
        -> Memoize it to get better TC.
'''
MAX_INT = sys.maxsize

class Solution:
    def __init__(self):
        self.costs = []
        self.dp = {}

    def minCost(self, costs: List[List[int]]) -> int:
        self.costs = costs
        return self.paint_house(0, -1)

    def paint_house(self, house, prev_paint):
        if (house, prev_paint) in self.dp:
            return self.dp[(house, prev_paint)]

        if house >= len(self.costs):
            return 0

        min_cost = MAX_INT
        paint_costs = self.costs[house]
        for paint, paint_cost in enumerate(paint_costs):
            if paint == prev_paint:
                continue

            cost = paint_cost + self.paint_house(house + 1, paint)
            min_cost = min(min_cost, cost)

        self.dp[(house, prev_paint)] = min_cost
        return min_cost
