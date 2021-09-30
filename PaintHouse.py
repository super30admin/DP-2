# Time complexity : O(n*m) where n is the number of houses and m is 3 colors
# Space complexity : O(n*m) where n is the number of houses and m is 3 colors
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No, had seen this question previously.
# But, haven't tried reaching dp starting from recursion, will do after class hours


# Idea here is for any house, if we have to minimize the total cost,
# we need to choose minimum costing paints for each house.
# Given the constraint that no two adjacent houses can have same color and since there are only 3 colors to choose from,
# the problem reduces to choosing one color for current house and considering the min of the other two available colors for the previous house.
# the memo dp table holds the min cost at each step and we will need to return the min of the last row


class Solution:
    def minCost(self, costs):
        memo = [[0 for _ in range(3)] for _ in range(len(costs))]
        memo[0] = costs[0]

        for idx in range(1, len(costs)):
            memo[idx][0] = costs[idx][0] + min(memo[idx-1][1], memo[idx-1][2])
            memo[idx][1] = costs[idx][1] + min(memo[idx-1][0], memo[idx-1][2])
            memo[idx][2] = costs[idx][2] + min(memo[idx-1][0], memo[idx-1][1])

        return min(memo[-1])


solution = Solution()
print(solution.minCost([[17, 2, 17], [16, 16, 5], [14, 3, 19]]))
