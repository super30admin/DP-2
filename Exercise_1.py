#Time Complexity : O(N), N being the total number of houses.
#Space Complexity : O(N), because of dp array.
#Did this code successfully run on Leetcode : Was not able to access problem on 
#leetcode as I do not have premium. 
#Any problem you faced while coding this : I was able to solve this after 
# being told the method. 

#Your code here along with comments explaining your approach in three sentences only
'''Used dynamic programming where the dp array is the minimum cost at each row, 
starting from the bottom row. Final answer is the minimum of the first row. 
'''
def paint_house(array): 
    #define a dp array and initialize the last row to the last row or array.
    dp = [[0 for i in range(3)] for j in range(len(array))]
    for i in range(3):
        dp[len(array)-1][i] = array[len(array)-1][i]
    #define the dp row above as the corresponding array value + minimum of the 
    #other columns in row below. 
    for j in range(len(dp)-1):
        index = len(array)-2-j
        dp[index][0] = array[index][0]+min(dp[index+1][1], dp[index+1][2])
        dp[index][1] = array[index][1]+min(dp[index+1][0], dp[index+1][2])
        dp[index][2] = array[index][2]+min(dp[index+1][0], dp[index+1][1])
    #return minimum of first row. 
    return min(dp[0][1], dp[0][0], dp[0][2])

array = [[1, 2, 3], [5, 1, 56], [1, 8, 9], [3, 2, 4]]

print(paint_house(array))