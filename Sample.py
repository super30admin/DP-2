# Problem 1: Paint House -> Time Complexicity: O(n), Space Complexicity: O(1)
# Solution by creating variables like cr, cg, and cb is not working - please comment

class Solution:

    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def minCost(self, costs):
        
        if len(costs) == 0: return 0
        """
        cr = costs[len(costs)-1][0]
        cg = costs[len(costs)-1][1]
        cb = costs[len(costs)-1][2]
        """
        for i in reversed(range(len(costs)-1)):
            """
            tempr = cr; tempb = cb
            cr = costs[i][0] + min(cb, cg)
            cb = costs[i][1] + min(cg, tempr)
            cg = costs[i][2] + min(tempb, tempr)
            
            """
            costs[i][0] = costs[i][0] + min(costs[i+1][1], costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0], costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][0], costs[i+1][1])
            
        # return min(cr, min(cg, cb))
        return min(costs[0])
		
        
	""" BRUTE FORCE SOLUTION: (Time Limit Exceeded)
    def minCost(self, costs):
        
        def helper(costs, row, color, mini):
            
            # base case
            if row == len(costs): return mini
            # Logic
            if color == 0:
                return min(\
                    helper(costs, row+1, 1, mini + costs[row][0]),
                    helper(costs, row+1, 2, mini + costs[row][0]))
            if color == 1:    
                return min(\
                    helper(costs, row+1, 0, mini + costs[row][1]),
                    helper(costs, row+1, 2, mini + costs[row][1]))
            if color == 2:
                return min(\
                    helper(costs, row+1, 0, mini + costs[row][2]),
                    helper(costs, row+1, 1, mini + costs[row][2]))
                
            return mini
        # write your code here
        case_r = helper(costs, 0, 0, 0)
        case_g = helper(costs, 0, 1, 0)
        case_b = helper(costs, 0, 2, 0)
        
        return min(case_r, min(case_g, case_b))
	"""
	
# Problem 2: coin change #2 -> Time Complexicity: O(m*n), Space Complexicity: O(m*n)

class Solution:
    
    def change(self, amount: int, coins: List[int]) -> int:
        
        """
        Solved by creating a dp matrix progressively resulting in coin combinations for each pair of amount and coin
        """
        
        if len(coins) == 0 and amount > 0: return 0
        # elif len(coins) == 0: return 1
        else:
            w, h = amount + 1, len(coins)+1
            dp_mat = [[0 for x in range(w)] for y in range(h)] 

            for j in range(h):
                dp_mat[j][0] = 1

            for i in range(1, w):
                for j in range(1, h):
                    if coins[j-1] > i:
                        dp_mat[j][i] = dp_mat[j-1][i]
                    else:
                        dp_mat[j][i] = dp_mat[j-1][i] + dp_mat[j][i-coins[j-1]]
                        
            return dp_mat[h-1][w-1]
