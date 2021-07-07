
# WITHOUT MUTATING THE GIVEN MATRIX USING 3 VARIABLES 

# Time Complexity: O(M*N), M: no.of.rows, N: no.of. columns
# Space Complexity: O(1), No extra Data Structure used
# Did problem run on Leetcode: yes

class Solution:
    def minCost(self, costs):
        if not costs:
            return 0
        lastR = costs[0][0]
        lastB = costs[0][1]
        lastG = costs[0][2]

        for i in range(1, len(costs)):
            currentR = costs[i][0] + min(lastB, lastG)
            currentB = costs[i][1] + min(lastR, lastG)
            currentG = costs[i][2] + min(lastR, lastB)
            lastR = currentR
            lastB = currentB
            lastG = currentG
        return min(lastR, lastB, lastG)
        

obj = Solution()
print(obj.minCost(costs=[[17,2,17],[16,16,5],[14,3,19]]))

