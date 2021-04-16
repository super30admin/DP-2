class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        '''
        TC : O(n)
        SC : O(n)/O(1)
        
        Approach :
            explore all paths and finds optimal vale
                17  02  17
                18  33  7
                21  10  37
                ans = 10
        '''
        for i in range(1,len(costs)):
            costs[i][0] += min(costs[i-1][1],costs[i-1][2])
            costs[i][1] += min(costs[i-1][0],costs[i-1][2])
            costs[i][2] += min(costs[i-1][0],costs[i-1][1])
        return min(costs[-1])