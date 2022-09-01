## Problem2 (https://leetcode.com/problems/coin-change-2/)

def FindWays(self, arr, amount):
		dp_arr = [0] * (amount + 1)
		dp_arr[0] = 1
		for i in arr:
			for j in range(i, amount + 1):
				dp_arr[j] += dp_arr[j - i]
		return dp_arr[-1]


# Time Complexity -> o(n)
# Space Complexity -> o(n)