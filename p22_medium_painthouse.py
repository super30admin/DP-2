"""

https://leetcode.com/problems/paint-house/
Given a row of n houses, each house can be coloured with any of the three colours:
let these be red blue or green. the cost for painting a particular house with a particular colour is going to be different.
you have to colour the house in such a way that no two adjacent houses will have the same colour.
the cost for painting  a house with any colour is represented by a n X 3 cost matrix where cost for
painting house 0 with colour red is cost[0][0] and cost for painting house 4 with green colour is cost[4][2]
and so on.....calculate the minimum cost to paint all houses. try to optimize it for space !!

Input: [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
Minimum cost: 2 + 5 + 3 = 10
:return

Approach- here follow bottom up to get exhaustive set of values from last row go the second last row and find
possibilities of all the min choice
Tc- O(n)
Sc-O(1)

"""


class Solution:

    def minCost(self, costs):
        ###below is the dp solution
        if len(costs)==0:
            return 0
        ##we will start from second last row to fetch the last row minimums and proceed till 0th row
        for i in range(len(costs)-2, -1, -1):
            # for j in range(len(costs[0])):
            # print("in row ")
            costs[i][0]+=min(costs[i+1][1], costs[i+1][2])
            costs[i][1]+=min(costs[i+1][0], costs[i+1][2])
            costs[i][2]+=min(costs[i+1][0], costs[i+1][1])
        return min(costs[0])



costs = [
        [17, 2, 17],
        [16, 16, 5],
        [14, 3, 19]
        ]
solve = Solution()
print(solve.minCost(costs))

    ###below is the recursive solution
    # def minCost(self, costs):
    #
    #
    #
    #     if len(costs)==0:
    #         return 0
    #
    #     ###the first house painted is red
    #     caseRed=self.helper(costs, 0, 0, 0)
    #
    #
    #     ##first house pained is blue
    #     caseBlue=self.helper(costs, 0, 1, 0)
    #
    #     ##first house painted is green
    #     caseGreen=self.helper(costs, 0, 2, 0)
    #
    #     return min(caseRed,caseBlue, caseGreen)
    #
    #
    # def helper(self, costs, rowHouse, color, minAmount):
    #     ###base case
    #
    #     if rowHouse==len(costs):
    #         return minAmount
    #
    #
    #     ###logic case
    #     if color==0:###if red is chosen then we pick minimum of either chosing blue or gree
    #         return  min(
    #             self.helper(costs, rowHouse+1, 1, minAmount+costs[rowHouse][0]),
    #             self.helper(costs, rowHouse+1, 2, minAmount+costs[rowHouse][0])
    #         )
    #     if color==1:###if blue is chosen then we pick minimum of either chosing red or green
    #         return min(
    #             self.helper(costs, rowHouse + 1, 0, minAmount + costs[rowHouse][1]),
    #             self.helper(costs, rowHouse + 1, 2, minAmount + costs[rowHouse][1])
    #                  )
    #     if color ==2:###if green is chosen then we pick minimum of either chosing red or blue
    #         return min(
    #             self.helper(costs, rowHouse + 1, 0, minAmount + costs[rowHouse][2]),
    #             self.helper(costs, rowHouse + 1, 1, minAmount + costs[rowHouse][2]))
    #
    #
    #     return 1234




