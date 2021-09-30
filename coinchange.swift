// Time Complexity : 0(amount*n)
// Space Complexity : 0(amount)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
    func change(_ amount: Int, _ coins: [Int]) -> Int {
        var dp = Array(repeating: Array(repeating: 0, count: amount + 1),count: 2)
        dp[0][0] = 1
        for i in 1...coins.count {
            for j in 0...amount {
                if coins[i-1] > j {
                    dp[1][j] = dp[0][j]
                } else {
                    dp[1][j] = dp[1][j - coins[i-1]] + dp[0][j]
                    dp[0][j] = dp[1][j]
                }
            }
        }
        return dp[1][amount]
    }