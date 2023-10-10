########
# Exhaustive - Recursion
############
# TC: O(k*2 ^ n)
# SC: scales with the recursion stack depth


class Solution:
    def minCost(self, costs):
        red = self.helper(costs, 0, 0)
        blue = self.helper(costs, 0, 1)
        green = self.helper(costs, 0, 2)

        return min(red, blue, green)

    def helper(self, costs, idx, color):
        # base
        if idx == len(costs):
            return 0

        # color RED
        if color == 0:
            return (costs[idx][0] + min(self.helper(costs, idx+1, color + 1),
                                        self.helper(costs, idx+1, color + 2)))
        # color BLUE
        if color == 1:
            return (costs[idx][1] + min(self.helper(costs, idx+1, color-1),
                                        self.helper(costs, idx+1, color+1)))
        # color GREENs
        if color == 2:
            return (costs[idx][2] + min(self.helper(costs, idx+1, color-2),
                                        self.helper(costs, idx+1, color-1)))
        return None


# obj = Solution()
# print(obj.minCost([[17, 2, 7], [16, 5, 26], [14, 3, 10], [1, 7, 4]]))

############
# DP - using 2D matrix
############
# TC: O(mxn) where m = 3
# SC: O(mxn)

class Solution:
    def minCost(self, costs):
        n = len(costs)
        # create 2D matrix of mxn where m=colors, and n=len(coins)
        dp = []
        for _ in range(n):  # TC O(n)
            dp.append([0] * (3))  # 3 colors

# fill last row with the elements of costs matrix
        dp[n-1][0] = costs[n-1][0]
        dp[n-1][1] = costs[n-1][1]
        dp[n-1][2] = costs[n-1][2]

        # iterate bottom to up from second last row
        for i in range(n-2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
            print(dp)

        return min(dp[0][0], dp[0][1], dp[0][2])


# obj = Solution()
# print(obj.minCost([[17, 2, 7], [16, 5, 26], [14, 3, 10], [1, 7, 4]]))


############
# DP - using 1D matrix
############
# TC: O(mxn) where m =  number of colors
# SC: O(m) i.e O(3) since we make only 1D array of length = # of colors

class Solution:
    def minCost(self, costs):
        n = len(costs)

        # create 1D matrix
        dp = [0] * 3
        # for _ in range(n):  # TC O(m)
        #     dp.append([0] * (3))  # 3 colors

        dp[0] = costs[n-1][0]
        dp[1] = costs[n-1][1]
        dp[2] = costs[n-1][2]

        for i in range(n-2, -1, -1):
            tempB = dp[1]
            tempG = dp[2]
            tempR = dp[0]
            dp[0] = costs[i][0] + min(tempB, tempG)
            dp[1] = costs[i][1] + min(tempR, tempG)
            dp[2] = costs[i][2] + min(tempB, tempR)
            print(dp)

        return min(dp[0], dp[1], dp[2])


# obj = Solution()
# print(obj.minCost([[17, 2, 7], [16, 5, 26], [14, 3, 10], [1, 7, 4]]))
