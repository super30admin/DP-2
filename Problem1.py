class Solution(object):
#     // Time Complexity : O(n) where n is the number of houses
# // Space Complexity : O(1), constant space O(3) -> O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        # ok we were given a matrix where the cols are 3 each index represent a color
        # oth index red, 1st index blue, 2nd index green
        # the condition is if one house is painted with x color the next house cannot be same
        # so in first row if we selected 0th index, next row we have to select 1st or 2nd index 
        # tric part: with what index should i start in the begining and also the following rowsthat will give min cost
        # since we cannot defnity say the index we start will give the min cost until end of all housed, we havr to check evry possiblity
        # we need the cost of every possiblity in different stages in the matrix but we don't need to calculate the subproblems all the time
        # we can avoid recrussivey calculating the min cost of painting x houses wtih color y instead we can use dp and store the cost once we calcualted a subproblem and use it 
        # savs the time complexity
        # Thinking of using a matrix to store the min cost required to paint x number of houses with y color 
        # but i don't need to store cost of painting one to n houses, in the end i just need the min cost of the 
        # painting all n houses, so won't use an matrix,   saves the space complexity

        # constructing an array
        houses = len(costs)
        colors = len(costs[0])

        # painting from last house to first house, 
        colorR = costs[houses-1][0] # cost if we start paiting the last house with red
        colorB = costs[houses-1][1]
        colorG = costs[houses-1][2]

        for i in range(houses-2, -1, -1): # painting from bottom to top #tc: O(n)
           tempR = colorR
           tempB = colorB
           # if we choose red to paint in this path, then the cost will be min of cost of blue or green in the previous house
           colorR = costs[i][0] + min(colorB,colorG) 
           colorB = costs[i][1] + min(tempR, colorG)
           colorG = costs[i][2] + min(tempR,tempB)

        # the above for loop gives us the min cost required if we start from red, blue and green in the start
        # the next step is to decide which path has the min cost

        return min(colorR,colorB,colorG)



            

