class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp_arr = [0] * (amount + 1)
        dp_arr[0] = 1
        for i in coins:
            for j in range(i, amount + 1):
                dp_arr[j] = dp_arr[j] + dp_arr[j - i]
        return dp_arr[-1]

