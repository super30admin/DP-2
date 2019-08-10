# Space complexity : O(n) where n is the amount to be found
# Time complexity : O(mn) where m is the number of denominations and n is the amount

class Problem2:
	# find number of ways to get an amount using the given denominations.
	def FindWays(self, arr, amount):
		dp_arr = [0] * (amount + 1)
		dp_arr[0] = 1
		for i in arr:
			for j in range(i, amount + 1):
				dp_arr[j] += dp_arr[j - i]
		return dp_arr[-1]

if __name__ == '__main__':
	fw = Problem2()
	print(fw.FindWays([1,2,3], 5))