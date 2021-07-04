class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if not costs or len(costs) ==0:
            return 0
        dp = {}
        def paint(n,color):
            if((n,color) in dp):
                return dp[(n,color)]
            if n == len(costs)-1:
                return costs[n][color]

            total_cost = costs[n][color]
            
            if color == 0:
                total_cost += min(paint(n+1,1),paint(n+1,2))
            elif color==1 :
                total_cost += min(paint(n+1,0),paint(n+1,2))
            else:
                total_cost += min(paint(n+1,0),paint(n+1,1))
            dp[(n,color)] = total_cost
            return dp[(n,color)]
        return min(paint(0,0),paint(0,1),paint(0,2))