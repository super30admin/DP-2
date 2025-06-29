# Time Complexity: O(n)
# Space Complexity: O(1)
# Were you able to run the code on Leetcode: No
# Any problem you faced while coding this: No

class Solution:
    def minCost(self, costs):  # 0-R, 1-B, 2-G
        if not costs:
            return 0
        
        # using DP method, from bottom-up assuming we are allowed to mutate original costs matrix
        m = len(costs)
        
        # red = costs[m-1][0]
        # blue = costs[m-1][1]
        # green = costs[m-1][2]
        for i in range(m-2,-1, -1):
            # for each house, we add the cost of painting it with the minimum cost of painting the next house
            # with a different color than the current house
            costs[i][0] += min(costs[i+1][1] , costs[i+1][2])
            costs[i][1] += min(costs[i+1][0] , costs[i+1][2])
            costs[i][2] += min(costs[i+1][0] , costs[i+1][1])
                
        
        return min(costs[0][0] , costs[0][1], costs[0][2] )
                
            
if __name__ == '__main__':
    
    # Test cases
    costs1 = [[17,2,17],[16,16,5],[14,3,19]]
    costs2 = [[7,6,2],[3,8,5],[8,3,1]]
    costs3 = [[2,3,4],[5,6,7],[8,9,10]]
    
    solution = Solution()
    print(f"Minimum cost for costs1: {solution.minCost(costs1)}")  # Expected output: 10
    print(f"Minimum cost for costs2: {solution.minCost(costs2)}")  # Expected output: 6
    print(f"Minimum cost for costs3: {solution.minCost(costs3)}")  # Expected output: 16
        
        
        
        