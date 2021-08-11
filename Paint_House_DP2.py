# Second Dynamic Programing Approach where we are not allowed to change the orignal array.
# Time complexity O(n) and Space complexity is constant

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs: return 0
        cr = costs[len(costs)-1][0]
        cb = costs[len(costs)-1][1]
        cg = costs[len(costs)-1][2]
        for i in range(len(costs)-2, -1, -1):
            tempr, tempb = cr,cb
            cr = costs[i][0] + min(cb,cg)
            cb = costs[i][1] + min(tempr,cg)
            cg = costs[i][2] + min(tempr,tempb)
        return min(cr,cb,cg)
