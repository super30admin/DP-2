"""
// Time Complexity : O(M*N) M : number of coins N : amount
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

"""
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dparr = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]

        dparr[0][0] = 1
        for j in range(1, len(dparr)):
            dparr[j][0] = 1

        for i in range(1, len(dparr)):
            for j in range(1, len(dparr[0])):
                if j < coins[i - 1]:
                    dparr[i][j] = dparr[i - 1][j]
                else:
                    dparr[i][j] = dparr[i - 1][j] + dparr[i][j - coins[i - 1]]

        return dparr[len(dparr) - 1][len(dparr[0]) - 1]