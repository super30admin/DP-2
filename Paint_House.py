class Solution:

    #bruteforce
    def minCost(self, costs: List[List[int]]) -> int:

        if not costs:
            return 0

        case1 = self.helper(costs, 0, 0, 0)
        case2 = self.helper(costs, 0, 1, 0)
        case3 = self.helper(costs, 0, 2, 0)

        return min(case1, case2, case3)

    def helper(self, costs, row, color, min_cost):
        # base
        if (len(costs) == row):
            return min_cost

        # logic
        if color == 0:
            return min(self.helper(costs, row + 1, 1, min_cost + costs[row][1]),
                       self.helper(costs, row + 1, 2, min_cost + costs[row][2]))

        if color == 1:
            return min(self.helper(costs, row + 1, 0, min_cost + costs[row][0]),
                       self.helper(costs, row + 1, 2, min_cost + costs[row][2]))

        if color == 2:
            return min(self.helper(costs, row + 1, 1, min_cost + costs[row][1]),
                       self.helper(costs, row + 1, 0, min_cost + costs[row][0]))

#Approach1

    def minCost(self, costs: List[List[int]]) -> int:

        if not costs:
            return 0

        for i in range(len(costs) - 2, -1, -1):
            costs[i][0] = costs[i][0] + min(costs[i + 1][1], costs[i + 1][2])
            costs[i][1] = costs[i][1] + min(costs[i + 1][0], costs[i + 1][2])
            costs[i][2] = costs[i][2] + min(costs[i + 1][0], costs[i + 1][1])

        return min(costs[0])

#Approach2

    def minCost(self, costs: List[List[int]]) -> int:

        if not costs:
            return 0

        cr = costs[-1][0]
        cb = costs[-1][1]
        cg = costs[-1][2]

        for i in range(len(costs) - 2, -1, -1):
            temp_cr = cr
            temp_cb = cb
            cr = costs[i][0] + min(cb, cg)
            cb = costs[i][1] + min(temp_cr, cg)
            cg = costs[i][2] + min(temp_cr, temp_cb)

        return min(cr, cb, cg)