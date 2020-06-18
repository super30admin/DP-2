#Paint House

def min_cost(array):
	if not array: #edge case
		return 0
	for i in range(1, len(inp)):
		array[i][0] = array[i][0]+min(array[i-1][1], array[i-1][2])
		array[i][1] = array[i][1]+min(array[i-1][0], array[i-1][2])
		array[i][2] = array[i][2]+min(array[i-1][1], array[i-1][0])
	return min(array[-1])

#Time complexity - O(n*m) as every row of input array is traversed
#Space complexity - O(1), no auxillary data structures used
#not tested on leetcode