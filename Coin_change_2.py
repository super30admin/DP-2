class Solution:
	def change(self, amount: int, coins: List[int]) -> int:
		if not coins and amount>0:
			return 0
		if not coins:
			return 1
		x = len(coins)+1
		y = amount+1
		matrix = [[0 for _ in range(y)] for _ in range(x)]
		for i in range(x):
			matrix[i][0] = 1
		for i in range(1, x):
			for j in range(1, y):
				if j>=coins[i-1]:
					matrix[i][j] = matrix[i-1][j] + matrix[i][j-coins[i-1]]
				else:
					matrix[i][j] = matrix[i-1][j]
		return matrix[-1][-1]


#Time complexity - O(n*m)
#Space complexity - O(n*m) as a dp array is used

#all test cases passed