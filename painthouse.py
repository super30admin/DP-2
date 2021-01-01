class Solution:
    '''
    Complexity: 
    Time: O(n)
    Space: O(3n) which is O(n)
    '''
    def minCost(self, costs: List[List[int]]) -> int:
        if(len(costs)==0):
            return 0
        x = [[float(inf) for j in range(0,3)] for i in range(0,len(costs))]
        if(len(costs)==1):
            return min(costs[0])
        x[-1][0] = costs[-1][0]
        x[-1][1] = costs[-1][1]
        x[-1][2] = costs[-1][2]
        for i in range(len(x)-2,-1,-1):
            for j in range(0,3):
                a = x[i+1].copy()
                a[j] = float(inf)
                x[i][j] = costs[i][j] + min(a)         
        return min(x[0])
