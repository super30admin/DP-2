'''
Implementation: Starting by choosing min in first array won't work because we limit ourselves to on
Time complexity: O(n)
Space complexity: O(1)
'''
class Solution(object):
    def paint(self, costs):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if len(costs) == 0 or len(costs[0]) == 0:
            return 0  
        for i in range(1, len(costs)):
            # R
            costs[i][0] = costs[i][0] + min(costs[i-1][1], costs[i-1][2])
            # G
            costs[i][1] = costs[i][1] + min(costs[i-1][0], costs[i-1][2])
            # B
            costs[i][2] = costs[i][2] + min(costs[i-1][0], costs[i-1][1])
        return min(costs[len(costs) - 1][0], min(costs[len(costs) - 1][1], costs[len(costs) - 1][2]))

s = Solution()
print(s.paint([[17,2,17],[16,16,5],[14,3,19]]))