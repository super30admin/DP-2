"""
Time: O(3^n) for recursive, O(n) for DP
Space : O(3^n) for recursive, O(1) for DP
Leet: Could not check
Problems faced: Struggled to break problem into subproblems for DP.
Not sure if approach is right for recursive solution.
"""

#recursive
def paint(costarray):
    helper(costarray,3,0,0)
    def helper(costarray, prev_color, current_house, cost):
        if current_house == len(costarray):
            #base case return cost if end of array
            return cost

        #maintain possible_costs array to keep track of cost in each call stack
        possible_costs = [float('inf')] * 3

        for i in range(3):
            #if color is not equal to prev_color then call for next house with updated values
            if prev_color != i:
                possible_costs[i] = helper(costarray, i, current_house + 1, cost + costarray[current_house][i])
        #return minimum at current level. Thus min value will be filtered upward via recursion
        return min(possible_costs)



#DP
def paint(costarray):
    #referred solution online
    for i in range(1,len(costarray)):
        #start with house at index 1, find min value possible upto that point
        costarray[i][0] = min(costarray[i-1][1],costarray[i-1][2])
        costarray[i][1] = min(costarray[i-1][0],costarray[i-1][2])
        costarray[i][2] = min(costarray[i-1][0],costarray[i-1][1])
        #update again and again till last house. Then return min
    return min(costarray[-1])
