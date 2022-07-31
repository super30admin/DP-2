# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No, As I don't have leetcode premium
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def paint_house(self, costs: List[list[int]]) -> int:
        no_of_houses = len(costs)
        no_of_colors = 3
        sol_list = costs[no_of_houses - 1]
        for i in range(no_of_houses - 2, -1, -1):
            temp_sol = [0, 0, 0]
            for j in range(no_of_colors):  # Constant Time as the variable is constant
                if j == 0:
                    temp_sol.insert(j, costs[i][j] + min(sol_list[j + 1], sol_list[j + 2]))
                elif j == 1:
                    temp_sol.insert(j, costs[i][j] + min(sol_list[j - 1], sol_list[j + 1]))
                else:
                    temp_sol.insert(j, costs[i][j] + min(sol_list[j - 2], sol_list[j - 1]))
            sol_list = temp_sol
            del temp_sol
        return min(sol_list[0], sol_list[1], sol_list[2])


if __name__ == "__main__":
    costs = [[17, 2, 17], [16, 16, 5], [14, 3, 19]]
    # costs = [[17, 2, 17]]
    print(Solution().paint_house(costs))
