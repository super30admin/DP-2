# Time Complexity : O(mn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


# Recursive Solution
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         return self.helper_func(amount, coins, 0)
#
#     def helper_func(self, amount: int, coins: List[int], index: int) -> int:
#         pass
#         # Base case
#         if amount == 0:
#             return 1
#         if index == len(coins) or amount < 0:
#             return 0
#         # if selected
#         ans1 = self.helper_func(amount - coins[index], coins, index)
#
#         # if not
#         ans2 = self.helper_func(amount, coins, index + 1)
#         return ans1 + ans2

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins) + 1
        n = amount + 1
        sol = []
        for i in range(m):
            temp_row = []
            for j in range(n):
                if i == 0:
                    temp_row.insert(j, 1 if j == 0 else 0)
                elif coins[i - 1] > j:
                    temp_row.insert(j, sol[j])
                else:
                    temp_row.insert(j, sol[j] + temp_row[j - coins[i - 1]])
            sol = temp_row
            del temp_row
        return sol[n-1]


if __name__ == "__main__":
    arr = [1, 2, 5]
    tot = 5
    print(Solution().change(tot, arr))
