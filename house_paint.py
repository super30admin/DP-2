"""
There are a row of n houses, each house can be painted with one of the three colors:
    red, blue or green.
The cost of painting each house with a certain color is different.

You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
For example,
costs[0][0] is the cost of painting house 0 with color red;
costs[1][2] is the cost of painting house 1 with color green, and so on...

Find the minimum cost to paint all houses.


Example:

Given costs = [[14,2,11],[11,14,5],[14,3,10]]
return 10

house 0 is blue, house 1 is green, house 2 is blue, 2 + 5 + 3 = 10

Time Complexity: O(n * m), where n is the number of houses and m is the number of colors.
Space Complexity optimized: O(1), for only 3 colors.
 
 
 
"""
from copy import deepcopy

def house_paint_dp(costs):
    if not costs or len(costs) == 0:
        return 0

    n, m = len(costs), len(costs[0])
    dp = [[0 for _ in range(m)] for _ in range(n)]

    for j in range(m):
        dp[0][j] = costs[0][j]

    for i in range(1, n):
        for j in range(m):
            dp[i][j] = costs[i][j] + \
                min(dp[i-1][(j+1) % m], dp[i-1][(j+2) % m])

    for i in range(n):
        print(dp[i])

    return min(dp[-1])

#optimized dp 
def house_paint_dp_optimized(costs):
    if not costs or len(costs) == 0:
        return 0
    
    previous = costs[-1]
    
    for i in range(len(costs)-2, -1, -1):
        current = deepcopy(costs[i])
        current[0] += min(previous[1], previous[2])
        current[1] += min(previous[0], previous[2])
        current[2] += min(previous[0], previous[1])
        previous = current

    return min(previous)
    


costs = [[14, 2, 11], [11, 14, 5], [14, 3, 10]]
print(house_paint_dp_optimized(costs))
