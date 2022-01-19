# DP - 2

## Problem1(https://leetcode.com/problems/paint-house/)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
           
        arr = costs[len(costs)-1]
        for i in range(len(costs)-2,-1,-1):
            temp = arr.copy()
            arr[0] = costs[i][0] + min(temp[1],temp[2])
            arr[1] = costs[i][1] + min(temp[0],temp[2])
            arr[2] = costs[i][2] + min(temp[0],temp[1])
        return min(arr)