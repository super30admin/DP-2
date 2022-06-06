// func change(amount int, coins []int) int {
//     total := 0
//     var dfs func(start int, amount int)
//     dfs = func(start int, amount int) {
//         // base
//         if amount == 0{
//             total++
//             return
//         }
//         if amount < 0 || start == len(coins) {
//             return
//         }
        
//         // logic
//         dfs(start+1, amount)
//         dfs(start, amount-coins[start])
//     }
//     dfs(0, amount)
//     return total
// }

// func change(amount int, coins []int) int {
//     m := len(coins)
//     n := amount
    
//     dp := make([][]int, m+1)
//     for idx, _ := range dp {
//         dp[idx] = make([]int, n+1)
//     }
    
//     for i := 0; i < len(dp); i++ {
//         dp[i][0] = 1
//     }
    
//     for i := 1; i < len(dp); i++ {
//         for j := 1; j < len(dp[0]); j++ {
//             coin := coins[i-1]
//             amount := j
//             if coin > amount {
//                 dp[i][j] = dp[i-1][j]
//             } else {
//                 dp[i][j] = dp[i-1][j] + dp[i][j-coin]
//             }
//         }
//     }
    
//     return dp[len(dp)-1][len(dp[0])-1] 
// }


func change(amount int, coins []int) int {
    m := len(coins)
    n := amount
    
    dp := make([]int, n+1)
    dp[0] = 1
    
    
    for i := 1; i < m+1; i++ {
        for j := 1; j < n+1; j++ {
            coin := coins[i-1]
            amount := j
            if coin > amount { continue }
            dp[j] = dp[j] + dp[j-coin]
        }
    }
    
    return dp[len(dp)-1] 
}
