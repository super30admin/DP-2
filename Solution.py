class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        costs = 
        [17,2,17],
        [16,16,5],
        [14,3,19]
        m = #colors
        n = #houses
        """
        red, green, blue = range(3)        
        #time = O(mn), 
        #space = O(1) as we use the input array.
        def helper_dp_use_input_array():
            for i in range(1, len(costs)):
                for j in range(3):
                    if j == 0:
                        costs[i][j] = costs[i][j] + min(costs[i-1][1], costs[i-1][2])
                    elif j == 1:
                        costs[i][j] = costs[i][j] + min(costs[i-1][0], costs[i-1][2])
                    else:
                        costs[i][j] = costs[i][j] + min(costs[i-1][1], costs[i-1][0])
            return min(costs[-1])
        
        #time = O(mn)
        #space = O(m)
        def helper_dp_1d():
            cur = costs[0][:]
            for i in range(1, len(costs)):
                prev = cur[:]
                for j in range(3):                    
                    if j == 0:
                        cur[j] = costs[i][j] + min(prev[1], prev[2])
                    elif j == 1:
                        cur[j] = costs[i][j] + min(prev[0], prev[2])
                    else:
                        cur[j] = costs[i][j] + min(prev[0], prev[1])
            return min(cur)
        
        # time = O(m * 2^n)
        # space = O(n) stack depth
        def helper_recursive(color, idx):
            if idx == len(costs):
                return 0
            if color == red:
                return costs[idx][red] + min(helper_recursive(blue, idx + 1), 
                helper_recursive(green, idx + 1))
            elif color == blue:
                return costs[idx][blue] + min(helper_recursive(red, idx + 1),
                helper_recursive(green, idx + 1))
            else:
                return costs[idx][green] + min(helper_recursive(red, idx + 1),
                helper_recursive(blue, idx + 1))
        
        return min(
            helper_recursive(red, 0),
            helper_recursive(green, 0),
            helper_recursive(blue, 0)
        )

    def coin_change(self, target, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        n = total number of coins
        m = target
        """
        # time = O(m*n)
        # space = O(m)
        def helper_dp_1d():
            dp = [0] * (target+1)
            dp[0] = 1
            for i in range(len(coins)):
                for j in range(target+1):
                    if j < coins[i-1]:
                        dp[j] = dp[j]
                    else:
                        dp[j] = dp[j] + dp[j - coins[i-1]]
            return dp[-1]
        return helper_dp_1d()
        
        # time = O(m*n)
        # space = O(m*n)
        
        def helper_dp_2d():
            dp = [[0] * (target+1) for _ in range(-1, len(coins))]
            dp[0][0] = 1
            for i in range(1, len(dp)):
                for j in range(len(dp[0])):
                    if j < coins[i-1]:
                        dp[i][j] = dp[i-1][j]
                    else:
                        dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
            return dp[-1][-1]
        


        # time = O(2^(n+m))
        # space = O(n+m)
        def helper_recursive(idx, amt_so_far):
            if amt_so_far == target:
                return 1
            if amt_so_far > target or idx == len(coins):
                return 0
            return helper_recursive(idx, amt_so_far + coins[idx]) + helper_recursive(idx + 1, amt_so_far)
        
        # function call
        # return helper_recursive(0, 0) 
        