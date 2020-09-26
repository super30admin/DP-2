class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if costs == None or len(costs)==0:
            return 0
        else:
            lastR = costs[0][0]
            lastB = costs[0][1]
            lastG = costs[0][2]
        
            for i in range(1,len(costs)):
                currR = costs[i][0] + min(lastB,lastG)
                currB = costs[i][1] + min(lastR,lastG)
                currG = costs[i][2] + min(lastB,lastR)
            
                lastR = currR
                lastB = currB
                lastG = currG
            return min(lastG,lastR,lastB)