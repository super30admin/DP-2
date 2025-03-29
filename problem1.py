# Problem1(https://leetcode.com/problems/paint-house/)

# FIRST THE BRUTE FORCE - RECURSIVE APPROACH

# TC : O(3^n) - Exponential because for each house we try up to 2 colors

# SC : O(n) - Where n is the number of houses (recursion stack depth)

# On Leetcode the subimission shows Time limit exceeded


def minCost(self, costs):
    if not costs:
        return 0  # Handle empty input case
        
    # Start with each possible color for the first house
    colorR = self.helper(costs, 0, 0, 0)  # Try starting with red (color 0)
    colorB = self.helper(costs, 0, 1, 0)  # Try starting with blue (color 1)
    colorG = self.helper(costs, 0, 2, 0)  # Try starting with green (color 2)
    
    # Return the minimum of all three possible starting colors
    return min(colorR, min(colorB, colorG))
   
def helper(self, costs, i, color, totalCost):
    # Recursive helper function to find minimum cost
    # costs: list of cost triplets
    # i: current house index
    # color: color of the current house (0=red, 1=blue, 2=green)
    # totalCost: accumulated cost so far
    
    # base case - if we've processed all houses, return the total cost
    if i == len(costs):
        return totalCost
    
    # For each current color, we can only choose the other two colors for the next house
    if color == 0:  # If current house is red
        return min(self.helper(costs, i+1, 1, totalCost + costs[i][0]),  # Next house blue
                    self.helper(costs, i+1, 2, totalCost + costs[i][0]))   # Next house green
    elif color == 1:  # If current house is blue
        return min(self.helper(costs, i+1, 0, totalCost + costs[i][1]),  # Next house red
                    self.helper(costs, i+1, 2, totalCost + costs[i][1]))   # Next house green
    elif color == 2:  # If current house is green
        return min(self.helper(costs, i+1, 0, totalCost + costs[i][2]),  # Next house red
                    self.helper(costs, i+1, 1, totalCost + costs[i][2]))   # Next house blue
    
    return -1  # Unreachable code (safety return)

#____________________________________________________________________________________

# THEN THE TABULATION METHOD

# TC: O(n) - where n is the number of houses

# SC: O(1) - we only use a fixed size 2D array (m*n where m=number of houses, n=3 colors)

# On Leetcode could submit this

def minCost(costs):
    if not costs:
        return 0
        
    m = len(costs)         # Number of houses
    n = len(costs[0])      # Number of colors (3 in this case)
    
    # Initialize dp array to store minimum costs
    dp = [[0 for j in range(n)] for i in range(m)]
    
    # Base case: cost of painting the first house
    dp[0][0] = costs[0][0]
    dp[0][1] = costs[0][1]
    dp[0][2] = costs[0][2]
    
    # Fill dp table
    for i in range(1, m):
        dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])  # Red color
        dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])  # Blue color
        dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])  # Green color
    
    # Return minimum cost of painting all houses
    return min(dp[m-1][0], min(dp[m-1][1], dp[m-1][2]))


#____________________________________________________________________________________

# Rolling Variable approach

# TC: O(n) - where n is the number of houses

# SC: O(1) - we only use a fixed-size array of 3 elements

# Approach:
# State Reduction: Rather than storing the entire dynamic programming table, 
#                   we only track the essential state information required for the next calculation.
# Rolling Optimization: We "roll" or update a fixed set of variables that represent our current state, 
#                   discarding previous states that are no longer needed.
# Bottom-Up Processing: We solve the problem iteratively, starting from the first house and moving forward, 
#                   building the solution based on previously computed optimal costs.
# Constant Space: By only tracking the most recent set of states (the minimum cost ending with each color), 
#                   we achieve O(1) space complexity regardless of input size.

# On Leetcode could submit this

def minCost(costs):
    # Time Complexity: O(n) - where n is the number of houses
    # Space Complexity: O(1) - we only use a fixed-size array of 3 elements
    
    if not costs:
        return 0
    
    # Keep track of minimum cost for each color
    # We only need to track the previous state
    prev_red = costs[0][0]
    prev_blue = costs[0][1]
    prev_green = costs[0][2]
    
    for i in range(1, len(costs)):
        # Calculate new costs based on previous house colors
        curr_red = costs[i][0] + min(prev_blue, prev_green)
        curr_blue = costs[i][1] + min(prev_red, prev_green)
        curr_green = costs[i][2] + min(prev_red, prev_blue)
        
        # Update previous costs for next iteration
        temp = (curr_red, curr_blue, curr_green)  # Create a tuple
        prev_red = temp[0]  # Unpack first value
        prev_blue = temp[1]  # Unpack second value
        prev_green = temp[2]  # Unpack third value
    
    return min(prev_red, prev_blue, prev_green)

