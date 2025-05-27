# Time Complexity : O(n) where n = number of days (len(costs))
# Space Complexity : O(1) auxiliary (only a fixed-size array of length 3 for prev/curr)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No issues

from typing import List

class Solution:

    def minCost(self, costs: List[List[int]]) -> int:

        #Space Optimization
        n = len(costs)
        if n == 0:
            return 0

        prev = costs[0][:] # copy of three color costs for day 0

        for day in range(1, n):
            curr = [0, 0, 0]
            for act in range(3):
                # choose the cheaper of the two other colors from prev
                best = min(
                   prev[(act + 1) % 3],
                   prev[(act + 2) % 3]
                )
                curr[act] = costs[day][act] + best

            prev = curr

        return min(prev)  # answer is the min cost for the last day over all three colors

#---------------------------------------------------------------------

        #Tabulation
        # n = len(costs)

        # dp = [[0] * 3 for _ in range(n)]

        # for act in range(n):
        #     dp[0][act] = costs[0][act]

        # for day in range(1, n):
        #     for act in range(3):
        #         best = float("inf")
        #         for prev in range(3):
        #             if prev == act:
        #                 continue
        #             best = min(best, dp[day-1][prev])
        #         dp[day][act] = costs[day][act] + best

        # return min(dp[n-1])

#---------------------------------------------------------------------
        # Memoization
        # n = len(costs)
        # memo = [[-1] * 4 for _ in range(n)]

        # def helper(day, last):
            
        #     if day == n:
        #         return 0
            
        #     if memo[day][last] != -1:
        #         return memo[day][last]
            
        #     best = float("inf")

        #     for color in range(3):
        #         if color == last:
        #             continue

        #         score = costs[day][color] + helper(day + 1, color)
        #         best = min(best, score)
        #     memo[day][last] = best
        #     return best
        
        # return helper(0, 3)
#---------------------------------------------------------------------
        
        # Recursive way
        # n = len(costs)

        # def helper(day, last):
            
        #     if day == n:
        #         return 0
            
        #     best = float("inf")

        #     for color in range(3):
        #         if color == last:
        #             continue

        #         score = costs[day][color] + helper(day + 1, color)
        #         best = min(best, score)
        #     return best

        # return helper(0, 3)
#---------------------------------------------------------------------   

if __name__ == "__main__":
    sol = Solution()
    # Example 1
    print(sol.minCost([[17,2,17],[16,16,5],[14,3,19]]))  # expected 10
    # Additional tests
    print(sol.minCost([]))                             # expected 0
    print(sol.minCost([[5,8,6]]))                      # expected 5
    print(sol.minCost([[1,2,3],[1,2,3]]))              # expected 3
