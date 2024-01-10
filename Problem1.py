# Time Complexity: O(n)
# Space Complexity: O(1) - 3 colors => O(3) => O(1)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
      # # 2D array house cost by colors
      # dp = [[0 for _ in range(3)] for _ in range(len(costs))]

      # for i in range(len(costs)):
      #   for color in range(3):
      #     if i == 0:
      #       dp[i][color] = costs[0][color]
      #     else:
      #       if color == 0:
      #         dp[i][color] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])
      #       elif color == 1:
      #         dp[i][color] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
      #       else:
      #         dp[i][color] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])
      
      # return min(dp[-1])


      dp = [0 for _ in range(3)]

      for i in range(len(costs)):
        prevR = dp[0] 
        prevB = dp[1]
        prevG = dp[2]
        for color in range(3):
          if i == 0:
            dp[color] = costs[0][color]
          else:
            if color == 0:
              dp[color] = costs[i][0] + min(prevB, prevG)
            elif color == 1:
              dp[color] = costs[i][1] + min(prevR, prevG)
            else:
              dp[color] = costs[i][2] + min(prevR, prevB)
      return min(dp)
