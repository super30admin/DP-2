// func minCost(costs [][]int) int {
//     m := len(costs)
//     n := len(costs[0])
//     out := math.MaxInt64
//     var dfs func(r int, prevColIdxUsed int, total int)
//     dfs = func(r, prevColIdxUsed, total int) {
//         // base
//         if r == m {
//             if total < out {out = total}
//             return
//         }
        
//         // logic
//         // this is like; on each row, pick a queen and go to next row -- I find this more intuitive - its like for-loop-based recursion
//         // because on each row for a particular path, we have 2 choices, well pick one of the two and explore that deep first
//         // then come back to paused recursion and try the other choices 
//         // ( no need to backtrack anything since we do not have reference data structures)
//         for j := 0; j < n; j++ {
//             if j == prevColIdxUsed && r != 0 {continue}
//             dfs(r+1, j, total+costs[r][j])
//         }
//     }
//     dfs(0,0,0)
//     return out
// }

// func minCost(costs [][]int) int {
//     m := len(costs)
//     n := 3
//     dp := make([][]int, m)
//     for i := 0; i < m; i++ {
//         dp[i] = make([]int, n)
//         if i == m-1 {
//             for j := 0; j < n; j++ {
//                 dp[i][j] = costs[i][j]
//             }
//         }
//     }
    
//     for i := m-2; i >= 0; i-- {
//         dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
//         dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
//         dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
//     }
//     return min(dp[0][0], min(dp[0][1], dp[0][2]))
// }

func minCost(costs [][]int) int {
	m := len(costs)
	n := len(costs[0])

	for i := m - 2; i >= 0; i-- {
		for j := 0; j < n; j++ {

			// out of the 3 choices - get the min of other 2 values while excluding current j idx
			jVal := 0
			if j == 0 {
				jVal = min(costs[i+1][1], costs[i+1][2])
			}
			if j == 1 {
				jVal = min(costs[i+1][0], costs[i+1][2])
			}
			if j == 2 {
				jVal = min(costs[i+1][0], costs[i+1][1])
			}
			costs[i][j] = jVal + costs[i][j]
		}
	}

	return min(costs[0][0], min(costs[0][1], costs[0][2]))
}

func min(x, y int) int {
    if x < y {return x}
    return y
}
