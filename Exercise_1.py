'''
256 Paint House
https://leetcode.com/problems/paint-house/description/

There is a row of N houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color. Find the minimum cost to paint all houses.

The cost of painting each house in red, blue or green colour is given in the cost matrix [][3] where cost[i][0], cost[i][1], and cost[i][2] is the cost of painting ith house with colors red, blue, and green respectively, the task is to find the minimum cost to paint all the houses such that no two adjacent houses have the same color.

Example 1:
Input: N = 3
       costs = [ [1, 2, 3],
                [1, 2, 3],
                [1, 2, 3] ]
Output: 4
Explanation: We can color the houses in RBR manner to incur minimum cost.
We could have obtained a cost of 3 if we coloured all houses red, but we
cannot color adjacent houses with the same color.

Example 2:
Input: N = 3
        costs = [ [2, 3, 1],
                 [1, 2, 3],
                 [3, 1, 2] ]
Output: 3
Explanation: We can color the houses in GRB manner to incur minimum cost.

Expected Time Complexity: O(N), Space Complexity: O(N)

Constraints:
1 <= N <= 5*104
1 <= r[i], g[i], b[i] <= 106

Solution:
1. Brute Force (Recursion): Generate all possible ways of coloring all the houses with the RBG colors and find the minimum cost among all the possible combinations such that no two adjacent houses have the same colors.
Time: O(2^N), Space: O(N)

2. Recursion with memoization (top-down approach): Same as recursion but using hash map to avoid repeated computation of sub problems.
Time: O(N), Space: O(N)

3. Tabulation (bottom-up approach):
Construct a 2-D DP array of size N x 3 to store the minimum cost of previously colored houses. Thus, dp[i][j] = cost of coloring ith house with color j
+ cost of coloring all the remaining houses i+1, i+2, ..., N-1 with some coloring sequence which yields the minimum cost. This means:
dp[i][j] = costs[i] [j] + {min(dp[i+1][k])},
where i = 0,...,N-2
where k != j, 0 <= k <= 2

Thus, for i = N-1, (last house)
dp[N-1][j] = costs[N-1] [j] (since there are no remaining houses after the last house)

Hence, initialize the dp array from the last house (indexed N-1) and fill the dp array for the remaining houses N-2, N-3, ..., 0 using the dp formula.

https://youtu.be/idtGVUZdg28?t=2860

Time: O(N), Space: O(3N) = O(N) (if we do not mutate the original costs matrix and instead create a new dp matrix to store the min cost values)
Time: O(N), Space: O(1) (if we mutate the original costs matrix to store the min cost values)

4. Iterative (bottom-up approach): The tabulation approach can be further improved in terms of space complexity by maintaining only three new variables to calculate the min cost. We do not have to mutate the original costs matrix.
Time: O(N), Space: O(3) = O(1)
'''
import time

def paint_house(costs, N):
    '''
    recursion
    '''
    def recurse(costs,row,col):
        if row == N-1:
            return costs[N-1][col]

        if col == 0:
            a = recurse(costs, row+1, 1)
            b = recurse(costs, row+1, 2)
        elif col  == 1:
            a = recurse(costs, row+1, 0)
            b = recurse(costs, row+1, 2)
        else: # col == 3
            a = recurse(costs, row+1, 0)
            b = recurse(costs, row+1, 1)

        this_cost = costs[row][col]
        tot_cost = this_cost + min(a,b)
        return tot_cost

    assert len(costs) == N, f"Num rows in costs matrix {len(costs)} should be equal to N {N}"
    if N == 0:
        return 0

    a = recurse(costs,0,0)
    b = recurse(costs,0,1)
    c = recurse(costs,0,2)
    return  min(a,b,c)

def paint_house_dp(costs, N):
    '''
    DP tabulation
    '''
    assert len(costs) == N, f"Num rows in costs matrix {len(costs)} should be equal to N {N}"

    if N == 0:
        return 0

    # init dp matrix with 0's
    dp = [[0]*3 for _ in range(N)]

    # copy the last row of costs matrix (RGB cost of last house) to the dp matrix
    for j in range(3):
        dp[N-1][j] = costs[N-1][j]

    for i in range(N-2,-1,-1):
        dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
        dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
        dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])

    print(dp)
    return min(dp[0])

def paint_house_iterative(costs, N):
    '''
    DP iterative using three variables to reduce space complexity to O(1)
    '''
    assert len(costs) == N, f"Num rows in costs matrix {len(costs)} should be equal to N {N}"

    if N == 0:
        return 0

    # init a list of size 3 (three variables)
    dp = [costs[N-1][0], costs[N-1][1], costs[N-1][2]]

    for i in range(N-2,-1,-1):
        dp =  [costs[i][0] + min(dp[1], dp[2]), costs[i][1] + min(dp[0], dp[2]), costs[i][2] + min(dp[0], dp[1])]
    return min(dp)


def run_paint_house():
    tests = [ ([[2, 3, 1],[1, 2, 3],[3, 1, 2]],3,3), ([[14,2,11],[11,14,5],[14,3,10]],3,10), ([[17,2,17],[16,16,5],[14,3,19]], 3, 10)]
    for test in tests:
        costs, N, ans = test[0], test[1], test[2]
        start = time.time()*1000
        min_cost = paint_house(costs, N)
        elapsed =  time.time()*1000 - start
        print(f"\ncost matrix = {costs}")
        print(f"Min cost to paint = {min_cost}, time = {elapsed:.2f} ms (recursion)")
        print(f"Pass: {ans == min_cost}")

    for test in tests:
        costs, N, ans = test[0], test[1], test[2]
        start = time.time()*1000
        min_cost = paint_house_dp(costs, N)
        elapsed =  time.time()*1000 - start
        print(f"\ncost matrix = {costs}")
        print(f"Min cost to paint = {min_cost}, time = {elapsed:.2f} ms (dp tabulation)")
        print(f"Pass: {ans == min_cost}")

    for test in tests:
        costs, N, ans = test[0], test[1], test[2]
        start = time.time()*1000
        min_cost = paint_house_iterative(costs, N)
        elapsed =  time.time()*1000 - start
        print(f"\ncost matrix = {costs}")
        print(f"Min cost to paint = {min_cost}, time = {elapsed:.2f} ms (dp three variables)")
        print(f"Pass: {ans == min_cost}")


run_paint_house()
