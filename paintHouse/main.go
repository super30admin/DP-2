// func minCost(costs [][]int) int {        
//     var dfs func(r, c, cost int) int
//     dfs = func(r,c, cost int) int {
//         // base
//         if r == len(costs) {
//             return cost
//         }
        
//         // logic
//         if c == 0 {
//             return int(math.Min(float64(dfs(r+1,1,cost+costs[r][0])), float64(dfs(r+1,2,cost+costs[r][0])) ))
//         }
        
//         if c == 1 {
//             return int(math.Min(float64(dfs(r+1,0,cost+costs[r][1])), float64(dfs(r+1,2,cost+costs[r][1])) ))
//         }
//         return int(math.Min(float64(dfs(r+1,0,cost+costs[r][2])), float64(dfs(r+1,1,cost+costs[r][2])) ))
        
//     }
//     case0 := dfs(0,0,0)
//     case1 := dfs(0,1,0)
//     case2 := dfs(0,2,0)
    
//     return int(math.Min(float64(case0), math.Min(float64(case1),float64(case2))))
// }


// func minCost(costs [][]int) int {
//     min := math.MaxInt64
//     var dfs func(r, c, cost int)
//     dfs = func(r,c, cost int) {
//         // base
//         if r == len(costs) {
//             if cost < min {
//                 min = cost
//             }
//             return
//         }
//         // logic
//         // this is like; on each row, pick a queen and go to next row -- I find this more intuitive - its like for-loop-based recursion
//         // because on each row for a particular path, we have 2 choices, well pick one of the two and explore that deep first
//         // then try the other choice
//         for i := 0; i < len(costs[r]); i++ {
//             if i == c && r != 0 { continue }
//             dfs(r+1,i,cost+costs[r][i])
//         }
//     }
//     dfs(0,0,0)
//     return min
// }

// bottom up dp
// solving from bottom to top solves repeated subproblems that we saw in our decision tree
// time: o(m) - where m is the number of rows in costs array -- since number of cols is constant, i.e: 3
// space: o(m) - where m is the number of cols in costs array -- since number of cols is constant, i.e: 3
// func minCost(costs [][]int) int {        
//     m := len(costs)
//     n := len(costs[0])
//     dp := make([][]int, m)
//     for idx, _ := range dp {
//         dp[idx] = make([]int, n)
//     }
//     for j := 0; j < n; j++ {
//         dp[m-1][j] = costs[m-1][j]
//     }
//     for i := m-2; i >= 0; i-- {
//         for j := 0; j < n; j++ {
            
//             // out of the 3 choices - get the min of other 2 values while excluding current j idx
//             jVal := 0
//             if j == 0 {jVal = int(math.Min(float64(dp[i+1][1]),float64(dp[i+1][2])))}
//             if j == 1 {jVal = int(math.Min(float64(dp[i+1][0]),float64(dp[i+1][2])))}
//             if j == 2 {jVal = int(math.Min(float64(dp[i+1][0]),float64(dp[i+1][1])))}
//             dp[i][j] = jVal + costs[i][j]
//         }
//     }
//     min := dp[0][0]
//     if dp[0][1] < min {min = dp[0][1]}
//     if dp[0][2] < min {min = dp[0][2]}
//     return min
// }

// // Bottom up DP - mutating existing costs array
// // time: o(m) - where m is the number of rows in costs array -- since number of cols is constant, i.e: 3
// // space: o(1)
func minCost(costs [][]int) int {        
    m := len(costs)
    n := len(costs[0])

    for i := m-2; i >= 0; i-- {
        for j := 0; j < n; j++ {
            
            // out of the 3 choices - get the min of other 2 values while excluding current j idx
            jVal := 0
            if j == 0 {jVal = int(math.Min(float64(costs[i+1][1]),float64(costs[i+1][2])))}
            if j == 1 {jVal = int(math.Min(float64(costs[i+1][0]),float64(costs[i+1][2])))}
            if j == 2 {jVal = int(math.Min(float64(costs[i+1][0]),float64(costs[i+1][1])))}
            costs[i][j] = jVal + costs[i][j]
        }
    }
    min := costs[0][0]
    if costs[0][1] < min {min = costs[0][1]}
    if costs[0][2] < min {min = costs[0][2]}
    return min
}


