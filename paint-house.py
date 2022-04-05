# TC: O(N)
# SC: O(1)
# LC: NO - IT'S PREMIUM PROBLEM, but i've tested it against input shows in videos and custom input so

from typing import List


def minCost(costs: List[List [int]]):
    print('hi : ' , len(costs) )
    for i in range(len(costs)-2, -1, -1):
        costs[i][0] += min(costs[i+1][1],costs[i+1][2])
        costs[i][1] += min(costs[i+1][0],costs[i+1][2])
        costs[i][2] += min(costs[i+1][0],costs[i+1][1])
    return min(costs[0])
        
costs = [
    [17,2,17],
    [16,16,5],
    [14,3,19]
]
print(minCost(costs))