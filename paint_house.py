#time complexity:O(n)
#space complexity:O(1)
#leetcode submission: successful


class Solution(object):
    def minCost(self, cost):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if not cost:
            return 0
        minr=cost[0][0]
        minb=cost[0][1]
        ming=cost[0][2]
        for i in range(1,len(cost)):
            curr=min(minb,ming)+cost[i][0]
            curb=min(minr,ming)+cost[i][1]
            curg=min(minr,minb)+cost[i][2]
            minr,minb,ming=curr,curb,curg
        return min(minr,min(minb,ming))