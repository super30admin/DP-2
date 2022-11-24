"""
    Problem Statement: Paint House

    Time complexity: O(n)

    Space complexity: O(1)

    Accepted on LeetCode? Yes! 

    LeetCode Link: https://leetcode.com/problems/paint-house/
"""
class Solution:

    def solve(self, costs) -> None:
        for i in range(1, len(costs)):
            costs[i][0] += min(costs[i-1][1], costs[i-1][2])
            costs[i][1] += min(costs[i-1][0], costs[i-1][2])
            costs[i][2] += min(costs[i-1][0], costs[i-1][1])
        
        return min(costs[-1])

if __name__ == "__main__":
    sol = Solution()
    costs = [[7, 6, 2]]
    ret = sol.solve(costs)
    print(ret)
    assert ret == 2