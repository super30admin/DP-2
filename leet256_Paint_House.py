# Solution

# // Time Complexity : 
# Three variables approach: O(n), it is actually O(3*n) but 3 is constant, 3 is number of colors. We go from last house to first
#                           house so time complexity reduces. 2D Matrix approach should be written and tried to understand how 
#                           this works clearly. This is same as 2D matrix, only thing is to save space using three variables.
#                           The reason is, we always need one previous house values and we have exactly three colors to be worked with.
# 2D Matrix approach: O(n), it is actually O(3*n) but 3 is constant.We go from last house to first house so time complexity reduces.
#                     write a 2D matrix and fill it from bottom to understand this clearly
# Exhaustive approach: O(k*2^n). K is the number of colors
#                      This is because from first row, we can build a tree for choosing each color.
#                      Each color you choose, will result in a tree, at each level you will have two other color
#                      options to choose from, so basically at each level you will have two options to choose from
#                      and each color will have an option to choose/no choose. Causing 2^n options for each tree.
#                      Since three colors it will be 3*2^n
# // Space Complexity : 
# Three variables approach: O(1) since we just use three variables to achieve the functionality
# 2D Matrix approach: O(n), it is actually O(3*n) but 3 is constant. This is because we use a 2D matrix to solve the solution.
#                     Size of matrix will be 3*n, 3 is number of colors and n is number of houses.
#                     if we do bottom up, basically coming from the last but one row/house, for each house
#                     we can check the previous house costs for each color and update the current house cost values.
# Exhaustive approach: O(2^n) it is actually O(k*(2^n)), but k is constant here, ideally it is number of colors.
#                      This is because from first row, we can build a tree for choosing each color.
#                      Each color you choose, will result in a tree, at each level you will have two other color
#                      options to choose from, so basically at each level you will have two options to choose from
#                      and each color will have an option to choose/no choose. Causing 2^n options for each tree.
#                      Since three colors it will be 3*2^n
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : 

# // Your code here along with comments explaining your approach
# Three Variables Approach: This is exactly same as 2D approach, only thing is, we can use
#                           three variables instead of a 2D array. The reason is, we always need one previous house
#                           values and we have exactly three colors to be worked with.
# 
# 2D Matrix Approach: if we do bottom up, basically coming from the last but one row/house, for each house
#                     we can check the previous house costs for each color and update the current house cost
#                     values.
# 
# Exhaustive Approach: From first row, we can build a tree for choosing each color.
#                      Each color you choose, will result in a tree, at each level you will have two other color
#                      options to choose from, so basically at each level you will have two options to choose from
#                      and each color will have an option to choose/no choose. Causing 2^n options for each tree.

def minCost(costs):
    # three variables approach. This is exactly same as 2D approach, only thing is, we can use
    # three variables instead of a 2D array. The reason is, we always need one previous house
    # values and we have exactly three colors to be worked with.
    # time complexity is O(3*n) == O(n), space complexity is O(1)
    n = len(costs)
    
    color0 = costs[n-1][0]
    color1 = costs[n-1][1]
    color2 = costs[n-1][2]
    
    for i in range(n-2,-1,-1):
        temp0 = color0
        temp1 = color1

        color0 = costs[i][0]+min(temp1,color2)
        color1 = costs[i][1]+min(temp0,color2)
        color2 = costs[i][2]+min(temp0,temp1)

    return min(color0,color1,color2)
    
    # 2D matrix approach. O(n*3) which is nothing but O(n), space will be O(n*3) nothing but O(n)
    # if we do bottom up, basically coming from the last but one row/house, for each house
    # we can check the previous house costs for each color and update the current house cost
    # values.
    # n = len(costs)
    # result = [[] for _ in range(n)]

    # result[n-1].append(costs[n-1][0])
    # result[n-1].append(costs[n-1][1])
    # result[n-1].append(costs[n-1][2])

    # for i in range(n-2,-1,-1):
    #     result[i].append(costs[i][0]+min(result[i+1][1],result[i+1][2]))
    #     result[i].append(costs[i][1]+min(result[i+1][0],result[i+1][2]))
    #     result[i].append(costs[i][2]+min(result[i+1][0],result[i+1][1]))

    # return min(result[0][0],result[0][1],result[0][2])


    # Exhaustive approach, Space will be O(n) implicit stack size, since the depth of tree will
    # be maximum of n
    # Time complexity will be O(k*2^n). K is the number of colors
    # This is because from first row, we can build a tree for choosing each color.
    # Each color you choose, will result in a tree, at each level you will have two other color
    # options to choose from, so basically at each level you will have two options to choose from
    # and each color will have an option to choose/no choose. Causing 2^n options for each tree.
    # Since three colors it will be 3*2^n
    # def helper(costs,coloridx,amount,houseNum):

    #     if houseNum == len(costs):
    #         return amount

    #     if coloridx == 0:
    #         return min(helper(costs,1,amount+costs[houseNum][1],houseNum+1),helper(costs,2,amount+costs[houseNum][2],houseNum+1))
    #     elif coloridx == 1:
    #         return min(helper(costs,0,amount+costs[houseNum][0],houseNum+1),helper(costs,2,amount+costs[houseNum][2],houseNum+1))
    #     elif coloridx == 2:
    #         return min(helper(costs,1,amount+costs[houseNum][1],houseNum+1),helper(costs,0,amount+costs[houseNum][0],houseNum+1))

    # return min(helper(costs,0,costs[0][0],1), min(helper(costs,1,costs[0][1],1),helper(costs,2,costs[0][2],1)))

if __name__ == "__main__":
    costs = [[17,2,17],[16,16,5],[14,3,19]]
    print(minCost(costs))