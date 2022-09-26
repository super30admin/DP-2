# Time Complexity : O(N)
# Space Complexity : O(N)  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this: No


# Your code here along with comments explaining your approach

class Solution(object):
    def paintHouse(self, costs):
        #Base case
        if not costs or len(costs) == 0:
            return 0
        
        n = len(costs)
        cols = 3
        #creating dp array
        dp = [[0 for j in range(cols)] for i in range(len(costs))]

        dp[n - 1] = costs[n - 1]

        for i in range((n - 2), -1, -1):
            #When red is chosen
            dp[i][0] = costs[i][0] + min(dp[i + 1][1], dp[i + 1][2])
            #When blue is chosen
            dp[i][1] = costs[i][1] + min(dp[i + 1][0], dp[i + 1][2])
            #When green is chosen
            dp[i][2] = costs[i][2] + min(dp[i + 1][0], dp[i + 1][1])
        
        return min(dp[0])

if __name__ == "__main__":
    ph = Solution()
    costs = [[17,2,17]]
    ans = ph.paintHouse(costs)
    print(ans)