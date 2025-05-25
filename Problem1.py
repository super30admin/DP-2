'''
Time Complexity: O(N)
Space Complexity: O(N)

where N is the number of houses.
Approach: 
Top Down Approach: 
Recursively traverse the houses and find the minimum cost to paint each house.
Space Complexity: O(N * 3) for the memoization table.
Space Complexity: O(N) for the recursion stack.

Bottom Up Approach: 
Use Dynamic Programming to store the minimum cost to paint each house.
Space Complexity: O(N * 3) for the memoization table.

'''

# Recusive Top Down Approach 
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        N = len(costs)

        dp = [[-1 for i in range(3)] for i in range(N)]

        def solve(idx, color):
            if idx >= N:
                return 0

            if dp[idx][color] != -1:
                return dp[idx][color]

            temp = -1
            if color == 0:
                temp = costs[idx][0] + min(
                    solve(idx + 1, 1),
                    solve(idx + 1, 2),
                )
            if color == 1:
                temp = costs[idx][1] + min(
                    solve(idx + 1, 0),
                    solve(idx + 1, 2),
                )
            elif color == 2:
                temp = costs[idx][2] + min(
                    solve(idx + 1, 1),
                    solve(idx + 1, 0),
                )
            dp[idx][color] = temp
            return dp[idx][color]

        return min(solve(0, 0), solve(0, 1), solve(0, 2))


# Bottom Up Approach: 

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        N = len(costs)

        dp = [[float('inf') for i in range(3)] for i in range(N)]

        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        dp[0][2] = costs[0][2]

        for i in range(1, N):
            for c in range(3):
                if c == 0:
                    dp[i][c] = costs[i][c] + min(dp[i - 1][1], dp[i - 1][2])
                if c == 1:
                    dp[i][c] = costs[i][c] + min(dp[i - 1][2], dp[i - 1][0])
                if c == 2:
                    dp[i][c] = costs[i][c] + min(dp[i - 1][0], dp[i - 1][1])

        return min(dp[N - 1][0], dp[N - 1][1], dp[N - 1][2])

