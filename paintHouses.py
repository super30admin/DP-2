"""
Given a row of n houses, each house can be coloured with any of the three colours: let these be red blue or green. 
the cost for painting a particular house with a particular colour is going to be different. you have to colour the house in such a way 
that no two adjacent houses will have the same colour. the cost for painting  a house with any colour is represented by a n X 3 cost matrix
where cost for painting house 0 with colour red is cost[0][0] and cost for painting house 4 with green colour is cost[4][2] and 
so on.....calculate the minimum cost to paint all houses. try to optimize it for space !! 

Example:
    [[1,2,3],
     [4,5,6],
     [7,8,9],
     [10,11,12]]


Solution:
    Greedy doesn't work
    Brute force: O(2^n)
             1                                 2
      5             6                   4             6
  7       9      8      9           8      9      7       8
11 12   10,11  10,12  10,11       10,12  10,11  11,12    10,12

we could see repeated sub problems. Brute force would be exponential.

def paintHouses(costs):
    if(costs==None or len(costs)==0):
        return 0
    case1 = helper(costs, 0, 0, 0) -> row=0, col=0, sum=0
    case2 = helper(costs, 0, 1, 0) -> row=0, col=1, sum=0
    case3 = helper(costs, 0, 2, 0) -> row=0, col=2, sum=0

    return min(case1, min(case2, case3))

def helper(costs, row, col, sum):
    #base
    if(row == len(costs)-1):
        return sum

    #logic
    if(col ==0):
        return min(helper(costs, row+1, 1, sum+costs[0][0]), helper(costs, row+1, 2, sum+costs[0][0]))
    if(col ==1):
        return min(helper(costs, row+1, 0, sum+costs[0][1]), helper(costs, row+1, 2, sum+costs[0][1]))
    if(col ==2):
        return min(helper(costs, row+1, 0, sum+costs[0][2]), helper(costs, row+1, 1, sum+costs[0][2]))

"""
"""
Use Dynamic programming to memorize the result of each sub problem

Build the 2d array from bottom
[[1+23, 2+22, 3+22],   -> 24 would be the answer
 [4+18, 5+18, 6+18],
 [7+11, 8+10, 9+10],  -> pick the minimum from the bottom row for each element and add itself. For 7 add 11 (min(11, 12))
 [10,11,12]]

 above solution - O(mn)
 can be done in place -  no extra memory - Space complexity O(1)

"""
def paintHouses(costs):
    if(costs==None or len(costs)==0):
        return 0
    
    for i in range(len(costs)-2, -1, -1):
        costs[i][0] = costs[i][0] + min(costs[i+1][1], costs[i+1][2])
        costs[i][1] = costs[i][1] + min(costs[i+1][0], costs[i+1][2])
        costs[i][2] = costs[i][2] + min(costs[i+1][0], costs[i+1][1])
    
    return min(costs[0][0], min(costs[0][1], costs[0][2]))

arr = [[1,2,3],
     [4,5,6],
     [7,8,9],
     [10,11,12]]
print(paintHouses(arr))