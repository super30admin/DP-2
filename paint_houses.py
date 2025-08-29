'''
Solution 1: DP
Time Complexity: O(nx3) ~ O(n), n = number of houses
Space Complexity: O(1) - Using the same costs matrix
'''
# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
#         rows = len(costs)
#         cols = len(costs[0]) # 3

#         for i in range(1,rows):
#             # choose red for curr means select green or blue on previous house whichever is minimum
#             costs[i][0] = costs[i][0]+ min(costs[i-1][1],costs[i-1][2]) 
#             # choose blue for curr means select Red or green on previous house whichever is minimum
#             costs[i][1] = costs[i][1]+ min(costs[i-1][0],costs[i-1][2]) 
#             # choose green for curr means select Red or blue on previous house whichever is minimum
#             costs[i][2] = costs[i][2]+ min(costs[i-1][0],costs[i-1][1])

#         return min(costs[-1]) 
            
'''
Solution 2: Recursion
Time Complexity: O(m x 2^n)  n = number of houses, m = colors
Space Complexity: O(1) 
'''
# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
        
#         colorR = self.helper(costs,0,0) # first tree of choosing red on first house
#         colorB = self.helper(costs,0,1) # second tree of choosing blue on second house
#         colorG = self.helper(costs,0,2) # third tree of choosing green on third house

#         return min(colorR,colorB,colorG)
    
#     # j - color idx
#     # i - house idx
#     def helper(self,costs,i,j):
#         # base
#         if i==len(costs): # leaf node
#             return 0

#         #logic
#         if j==0: # current house we selected red, so we explore selecting blue and green for next house
#             case1 = self.helper(costs,i+1,1) 
#             case2 = self.helper(costs,i+1,2)
#             # return costs[i][j] + min(case1,case2)
#         elif j==1:
#             case1 = self.helper(costs,i+1,0)
#             case2 = self.helper(costs,i+1,2)
#             # return costs[i][j] + min(case1,case2)
#         else:
#             case1 = self.helper(costs,i+1,0)
#             case2 = self.helper(costs,i+1,1)
#             # return costs[i][j] + min(case1,case2)
        
#         return costs[i][j] + min(case1,case2)

'''
Solution 3: Recursion with memoization
Time Complexity: O(m x n)  n = number of houses, m = colors
Space Complexity: O(m x n) 
'''
# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
#         self.mem={}
#         colorR = self.helper(costs,0,0) 
#         colorB = self.helper(costs,0,1)
#         colorG = self.helper(costs,0,2)

#         return min(colorR,colorB,colorG)
    
#     # j - color idx
#     # i - house idx
#     def helper(self,costs,i,j):
#         # base
#         if i==len(costs):
#             return 0
#         if (i,j) in self.mem:
#             return self.mem[(i,j)]

#         #logic
#         if j==0:
#             case1 = self.helper(costs,i+1,1)
#             case2 = self.helper(costs,i+1,2)
#             # return costs[i][j] + min(case1,case2)
#         elif j==1:
#             case1 = self.helper(costs,i+1,0)
#             case2 = self.helper(costs,i+1,2)
#             # return costs[i][j] + min(case1,case2)
#         else:
#             case1 = self.helper(costs,i+1,0)
#             case2 = self.helper(costs,i+1,1)
#             # return costs[i][j] + min(case1,case2)
#         self.mem[(i,j)] = costs[i][j] + min(case1,case2)
#         return costs[i][j] + min(case1,case2)

'''
Solution 4: Recursion with memoization (but with for loop, considering if there were more colors)
Time Complexity: O(m x n)  n = number of houses, m = colors
Space Complexity: O(m x n) 
'''
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        self.mem={}
        self.colors = len(costs[0])
        ans = 2**31 #inf
        for color_idx in range(self.colors):
            color = self.helper(costs,0,color_idx) 
            ans = min(ans, color)
        return ans
    
    # j - color idx
    # i - house idx
    def helper(self,costs,i,j):
        # base
        if i==len(costs):
            return 0
        if (i,j) in self.mem:
            return self.mem[(i,j)]

        #logic
        min_cost = 2**31 # act as inf
        for color in range(0,self.colors): # for this chosen color, explore the next house with all colors except this chosen color
            if color!=j:
                case = self.helper(costs,i+1,color)
                min_cost = min(min_cost,case) # maintain a minimum between all cases, eg. for chosen red, explore next house with green and blue (and the following path)
        
        self.mem[(i,j)] = costs[i][j] + min_cost
        return costs[i][j] + min_cost