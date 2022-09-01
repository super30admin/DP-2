## Problem1(https://leetcode.com/problems/paint-house/)

def PaintHouse(self, costs):
    single_arr = [costs[0][0], costs[0][1], costs[0][2]]
    for i in range(1, len(costs)):
        temp1 = single_arr[0]
        temp2 = single_arr[1]
        single_arr[0] = costs[i][0] + min(temp2, single_arr[2])
        single_arr[1] = costs[i][1] + min(temp1, single_arr[2])
        single_arr[2] = costs[i][2] + min(temp1, temp2)
    return min(single_arr)

# Time Complexity -> o(n)
# Space Complexity -> o(1)