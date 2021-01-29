# Time complexity: O(r*c)
# Space complexity: O(1)
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        r = len(costs)
        
        # check if costs is empty or not
        if r == 0:
            return 0
        
        c = len(costs[0])
        
        # traverse the matrix
        # start from the middle row
        for i in range(1,r):
            # calculate each color possibility of the house
            for j in range(c):
                # color 1
                if j == 0:
                    costs[i][j] += min(costs[i-1][j+1], costs[i-1][j+2])
                # color 2
                elif j == 1:
                    costs[i][j] += min(costs[i-1][j-1], costs[i-1][j+1])
                # color 3
                else:
                    costs[i][j] += min(costs[i-1][j-2], costs[i-1][j-1])
        # return the min in the last row of costs matrix
        return min(costs[r-1])