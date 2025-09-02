## Problem1(https://leetcode.com/problems/paint-house/)

# Method1: Recursion
# m ----- no: of colors (columns)
# n ----- no. of houses (rows)
# Time Complexity : O(m * (2^n)) --- for every subtree we will have 2^n complexity. 
# Space Complexity : O(1) but recursive auxiliary space of O(n) -- max depth of any subtree
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We have to be exhaustive and consider all the subtrees possible based on no. of columns ie selecting and exploring from every start cost
# of the first house. So which ever subtree gives the min cost we would return that. At any particular row, for a column we would have to
# explore options for the next row excluding the element of the current choosen column for the next row. At any step we have to add the
# current house paint cost to min we get from the subtrees


class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def min_cost(self, costs):
        # write your code here
        # row = house
        # col = color
        def helper(costs, row, col):
            # base case
            if(row == len(costs)):
                # out of bounds means cost = 0
                return 0

            # logic
            # skip the color for the next row already used in current row
            # if(col == 0):
            #     # take col1 and col2. Take min and add the cost of the current house
            #     case1 = helper(costs, row + 1, col + 1)
            #     case2 = helper(costs, row + 1, col + 2)
            #     return costs[row][col] + min(case1, case2)
            # elif(col == 1):
            #     # take col0 and col2. Take min and add the cost of the current house
            #     case1 = helper(costs, row + 1, col - 1)
            #     case2 = helper(costs, row + 1, col + 1)
            #     return costs[row][col] + min(case1, case2)
            # else:
            #     # take col0 and col1. Take min and add the cost of the current house
            #     case1 = helper(costs, row + 1, col - 2)
            #     case2 = helper(costs, row + 1, col - 1)
            #     return costs[row][col] + min(case1, case2)

            # this logic can be written as
            pathCosts = float('inf')
            for j in range(len(costs[0])):
                if(j != col):
                    pathCosts = min(pathCosts, helper(costs, row + 1, j))
                # elif(j > col):
                #     pathCosts = min(pathCosts, helper(costs, row + 1, j))

            # case where we have only single color to choose
            if(pathCosts == float('inf')):
                pathCosts = 0

            return costs[row][col] + pathCosts
        
        # If houses or colors are empty
        if(not costs or not costs[0]):
            return 0
        
        
        pathCosts = float('inf')
        # exploring tree at each column
        for j in range(len(costs[0])):
            pathCosts = min(pathCosts, helper(costs, 0, j))

        return pathCosts

sol = Solution()
print("Method1: Recursion")
print(sol.min_cost([[17, 2, 16],
  [1800, 5, 1400],
  [13000, 3, 19000]]))
print(sol.min_cost([[17, 2, 16],
  [18, 5, 14],
  [13, 3, 19], 
  [12, 8, 7]]))
print(sol.min_cost([[1]]))
print(sol.min_cost([[]]))
print(sol.min_cost([[2, 1, 5]]))

# Method2: Recursion with memoization hashmap
# m ----- no: of colors (columns)
# n ----- no. of houses (rows)
# Time Complexity : O(m * n) --- as we have two input variables of row and column
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here our input variable is row and column. So we can use a hashmap or 2-D array to store our repeated subproblems. 

class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def min_cost(self, costs):
        # write your code here
        # row = house
        # col = color
        def helper(costs, row, col):
            # base case
            if(row == len(costs)):
                # out of bounds means cost = 0
                return 0

            if((row, col) in memo):
                return memo[(row, col)]

            # logic
            # skip the color for the next row already used in current row
            pathCosts = float('inf')
            for j in range(len(costs[0])):
                if(j != col):
                    pathCosts = min(pathCosts, helper(costs, row + 1, j))
                # elif(j > col):
                #     pathCosts = min(pathCosts, helper(costs, row + 1, j))
            
            # case where we have only single color to choose
            if(pathCosts == float('inf')):
                pathCosts = 0
            memo[(row, col)] = costs[row][col] + pathCosts
            return memo[(row, col)]

            # if(col == 0):
            #     # take col1 and col2. Take min and add the cost of the current house
            #     case1 = helper(costs, row + 1, col + 1)
            #     case2 = helper(costs, row + 1, col + 2)
            #     return costs[row][col] + min(case1, case2)
            # elif(col == 1):
            #     # take col0 and col2. Take min and add the cost of the current house
            #     case1 = helper(costs, row + 1, col - 1)
            #     case2 = helper(costs, row + 1, col + 1)
            #     return costs[row][col] + min(case1, case2)
            # else:
            #     # take col0 and col1. Take min and add the cost of the current house
            #     case1 = helper(costs, row + 1, col - 2)
            #     case2 = helper(costs, row + 1, col - 1)
            #     return costs[row][col] + min(case1, case2)

        # If houses or colors are empty
        if(not costs or not costs[0]):
            return 0

        memo = {}
        pathCosts = float('inf')
        # exploring tree at each column
        for j in range(len(costs[0])):
            pathCosts = min(pathCosts, helper(costs, 0, j))

        return pathCosts
    
sol = Solution()
print("Method2: Recursion with Memoization Hashmap")
print(sol.min_cost([[17, 2, 16],
  [1800, 5, 1400],
  [13000, 3, 19000]]))
print(sol.min_cost([[17, 2, 16],
  [18, 5, 14],
  [13, 3, 19], 
  [12, 8, 7]]))
print(sol.min_cost([[1]]))
print(sol.min_cost([[]]))
print(sol.min_cost([[2, 1, 5]]))


# Method3: Bottom-up Tabulation
# m ----- no: of colors (columns)
# n ----- no. of houses (rows)
# Time Complexity : O(n * m) --- as we have two input variables of row and column.
# Space Complexity : O(n * m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here as we have 2 input variables of houses and color, we create a 2-D array of (n * m) size. We keep the last row of dp array to be 
# same as the costs array as min value would be that. We start from the last row and go to first row as we want to do bottom-up.
# For every row starting from the second last row, we want to take the minimum out of the possible values from the previous row.
# So total min cost at current = current cost + min(previous column cost excluding the current column index). To maintain the minimum cost
# at every row keeping in mind the fact that no two adjacent houses can have same color, we keep min and second min 
# along with their index of the previous row.


class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def min_cost(self, costs):
        # write your code here
        # tabulation
        

        if(not costs or not costs[0]):
            return 0

        # convert tree into matrix
        # since two variables row and columns. So 2-D matrix
        n = len(costs) # rows or houses
        m = len(costs[0]) # columns or colors
        dp = []
        # for getting min of the previous row
        minn = [float('inf'), -1] # value, column index
        secondMinn = [float('inf'), -1]
        for i in range(n):
            dpRow = []
            for j in range(m):
                if(i == n - 1):
                    # fill the last row with costs from costs array
                    dpRow.append(costs[i][j])
                    if(costs[i][j] < minn[0]):
                        # update min and second min
                        secondMinn[0] = minn[0]
                        secondMinn[1] = minn[1]
                        minn[0] = costs[i][j]
                        minn[1] = j
                    elif(costs[i][j] >= minn[0] and costs[i][j] < secondMinn[0]):
                        # update second min
                        secondMinn[0] = costs[i][j]
                        secondMinn[1] = j
                else:
                    dpRow.append(0)
            dp.append(dpRow)

        # Operations on Dp matrix
        # start from second last row
        for i in range(n - 2, -1, -1):
            newMinn = [float('inf'), -1] # value, column index
            newSecondMinn = [float('inf'), -1]
            for j in range(m):
                currMin = minn[0]
                if(minn[1] == j):
                    currMin = secondMinn[0]

                dp[i][j] = costs[i][j] + currMin

                # get min and second min for the current row
                if(dp[i][j] < newMinn[0]):
                    newSecondMinn[0] = newMinn[0]
                    newSecondMinn[1] = newMinn[1]
                    newMinn[0] = dp[i][j]
                    newMinn[1] = j
                elif(dp[i][j] >= newMinn[0] and dp[i][j] < newSecondMinn[0]):
                    newSecondMinn[0] = dp[i][j]
                    newSecondMinn[1] = j
            
            # update min and second min to be used for next row
            minn[0] = newMinn[0]
            minn[1] = newMinn[1]
            secondMinn[0] = newSecondMinn[0]
            secondMinn[1] = newSecondMinn[1]

        # the min of the first row
        return min(dp[0])
    
sol = Solution()
print("Method3: Bottom-up Tabulation")
print(sol.min_cost([[17, 2, 16],
  [1800, 5, 1400],
  [13000, 3, 19000]]))
print(sol.min_cost([[17, 2, 16],
  [18, 5, 14],
  [13, 3, 19], 
  [12, 8, 7]]))
print(sol.min_cost([[1]]))
print(sol.min_cost([[]]))
print(sol.min_cost([[2, 1, 5]]))

# Method4: Bottom-up Tabulation with optimized space
# m ----- no: of colors (columns)
# n ----- no. of houses (rows)
# Time Complexity : O(n * m) --- as we have two input variables of row and column.
# Space Complexity : O(m) -- only keeping values of all the columns
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here as we have 2 input variables of houses and color, so we start with a 2-D array. 
# Since we only require the current row and the previous min we can cut the other rows and reduce space to 1-D array
# We keep the 1-D array with last row of dp array to be same as the costs array as min value would be that. 
# We start from the last row of costs array and go to first row as we want to do bottom-up.
# For every row starting from the second last row, we want to take the minimum out of the possible values from the previous row.
# So total min cost at current = current cost + min(previous column cost excluding the current column index). To maintain the minimum cost
# at every row keeping in mind the fact that no two adjacent houses can have same color, we keep min and second min 
# along with their index of the previous row.

class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def min_cost(self, costs):
        # write your code here
        # tabulation
        

        if(not costs or not costs[0]):
            return 0

        n = len(costs) # rows or houses
        m = len(costs[0]) # columns or colors
        dp = []
        # for getting min of the previous row
        minn = [float('inf'), -1] # value, column index
        secondMinn = [float('inf'), -1]

        for j in range(m):
            dp.append(costs[n -1][j])
            if(costs[n -1][j] < minn[0]):
                # update min and second min
                secondMinn[0] = minn[0]
                secondMinn[1] = minn[1]
                minn[0] = costs[n -1][j]
                minn[1] = j
            elif(costs[n -1][j] >= minn[0] and costs[n -1][j] < secondMinn[0]):
                # update second min
                secondMinn[0] = costs[n -1][j]
                secondMinn[1] = j

        # Operations on Dp row
        # start from second last row
        for i in range(n - 2, -1, -1):
            newMinn = [float('inf'), -1] # value, column index
            newSecondMinn = [float('inf'), -1]
            for j in range(m):
                currMin = minn[0]
                if(minn[1] == j):
                    # if current column index match with previous min column index, then our min = second min
                    currMin = secondMinn[0]

                dp[j] = costs[i][j] + currMin
                if(dp[j] < newMinn[0]):
                    newSecondMinn[0] = newMinn[0]
                    newSecondMinn[1] = newMinn[1]
                    newMinn[0] = dp[j]
                    newMinn[1] = j
                elif(dp[j] >= newMinn[0] and dp[j] < newSecondMinn[0]):
                    newSecondMinn[0] = dp[j]
                    newSecondMinn[1] = j
            
            minn[0] = newMinn[0]
            minn[1] = newMinn[1]
            secondMinn[0] = newSecondMinn[0]
            secondMinn[1] = newSecondMinn[1]

        # print(dp)
        return min(dp)
    
sol = Solution()
print("Method4: Bottom-up Tabulation with optimized space")
print(sol.min_cost([[17, 2, 16],
  [1800, 5, 1400],
  [13000, 3, 19000]]))
print(sol.min_cost([[17, 2, 16],
  [18, 5, 14],
  [13, 3, 19], 
  [12, 8, 7]]))
print(sol.min_cost([[1]]))
print(sol.min_cost([[]]))
print(sol.min_cost([[2, 1, 5]]))


# Follow up question. Print the exact colors of the houses used

class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def min_cost(self, costs):
        # write your code here
        # tabulation
        

        if(not costs or not costs[0]):
            return 0

        # convert tree into matrix
        # since two variables row and columns. So 2-D matrix
        n = len(costs) # rows or houses
        m = len(costs[0]) # columns or colors
        dp = []
        path = [] # for keeping the path based on previous row index
        # for getting min of the previous row
        minn = [float('inf'), -1] # value, column index
        secondMinn = [float('inf'), -1]
        for i in range(n):
            dpRow = []
            pathRow = []
            for j in range(m):
                if(i == n - 1):
                    # fill the last row with costs from costs array
                    dpRow.append(costs[i][j])
                    if(costs[i][j] < minn[0]):
                        # update min and second min
                        secondMinn[0] = minn[0]
                        secondMinn[1] = minn[1]
                        minn[0] = costs[i][j]
                        minn[1] = j
                    elif(costs[i][j] >= minn[0] and costs[i][j] < secondMinn[0]):
                        # update second min
                        secondMinn[0] = costs[i][j]
                        secondMinn[1] = j
                else:
                    dpRow.append(0)
                pathRow.append(-1)
            dp.append(dpRow)
            path.append(pathRow)

        # Operations on Dp matrix
        # start from second last row
        for i in range(n - 2, -1, -1):
            newMinn = [float('inf'), -1] # value, column index
            newSecondMinn = [float('inf'), -1]
            for j in range(m):
                currMin = minn[0]
                # at which col index of the previous row we got min
                path[i][j] = minn[1]
                if(minn[1] == j):
                    currMin = secondMinn[0]
                    path[i][j] = secondMinn[1]

                dp[i][j] = costs[i][j] + currMin

                # get min and second min for the current row
                if(dp[i][j] < newMinn[0]):
                    newSecondMinn[0] = newMinn[0]
                    newSecondMinn[1] = newMinn[1]
                    newMinn[0] = dp[i][j]
                    newMinn[1] = j
                elif(dp[i][j] >= newMinn[0] and dp[i][j] < newSecondMinn[0]):
                    newSecondMinn[0] = dp[i][j]
                    newSecondMinn[1] = j
            
            # update min and second min to be used for next row
            minn[0] = newMinn[0]
            minn[1] = newMinn[1]
            secondMinn[0] = newSecondMinn[0]
            secondMinn[1] = newSecondMinn[1]

        # the min of the first row
        minCost = float('inf')
        houseColors = []
        firstIndex = -1
        # loop to get the color of the first house
        for i in range(len(dp[0])):
            if(dp[0][i] < minCost):
                minCost = dp[0][i]
                # index at which we got the min
                firstIndex = i

        houseColors.append(firstIndex)
        # loop to get the colors of all the houses
        for i in range(len(dp) - 1):
            houseColors.append(path[i][firstIndex])
            firstIndex = path[i][firstIndex]

        print(houseColors)

        return minCost
    
sol = Solution()
print("Follow up question. Print the exact colors of the houses used")
print(sol.min_cost([[17, 2, 16],
  [1800, 5, 1400],
  [13000, 3, 19000]]))
print(sol.min_cost([[17, 2, 16],
  [18, 5, 14],
  [13, 3, 19], 
  [12, 8, 7]]))
print(sol.min_cost([[1]]))
print(sol.min_cost([[]]))
print(sol.min_cost([[2, 1, 5]]))
