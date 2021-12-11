# Time Complexity : O(coins * amount)
# Space Complexity: O(coins * amount)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins is None or len(coins) == 0:
            return 0
        arr = [[0] * (int(amount) + 1)] * (len(coins) + 1)

        for i in range(1, len(arr)):
            arr[i][0] = 1

        for i in range(1, len(arr)):
            for j in range(1, len(arr[0])):
                if (j < coins[i - 1]):
                    arr[i][j] = arr[i - 1][j]
                else:
                    arr[i][j] = arr[i - 1][j] + arr[i][j - coins[i - 1]]

        return arr[-1][-1]