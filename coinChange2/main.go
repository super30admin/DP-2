/*
    approach: brute force
    - using dfs explore all paths
*/
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


/*
    Variation of coin change 
    
    approach: bttom up DP using dp matrix
    - We saw repeated subproblems in our decision tree
    - Therefore we can explore using DP to optimize our brute force
    - We will start by solving smaller sub problems from bottom of the decision tree and work our selves up
    - But what about DP matrix ? size? representation?
    - We have 2 constraints in this problem
    - 1. The coins we are allowed to use
    - 2. The amount we have to make
    - So that means we can use dp row to represent coins
    - and we can use dp cols to represent each subproblem amount
    - matrix m = rows = len(coins)+1 --- we will take a extra dummy row ( coin val 0 )
    - matrix n = cols = 0 to $amount
    - Remember we are looking for total number of ways to form $amount using coins given to us
    - So for each coin we have 2 choices, whether to use this coin or to not use this coin
    - We will sum both branches - 0 case might be giving us an answer and 1 case might be giving us another ans - we need to add both
    - In our dp matrix, the 0 case for a specific i,j is right above ( i-1,j )
    - In our dp matrix, the 1 case for a specific i,j is $i steps (coinVal) back in the same row ( i,j-$i )
    - If the coinVal ( $i ) > amount to form - we do not have a 1 case ( obv )
        - Therefore, just take the 0 case val from above
    - otherwise sum both 0case and 1 case vals.
    - Finally the last row, last col will be our ans
    Time: o(mn)
        - m = len(coins)
        - n = amount
        - we will be filling out the matrix
    Space: o(mn)
*/
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

/*
    Variation of coin change 
    
    approach: bttom up DP using dp 1D array
    - this is identical to dp matrix but space optimized
    - we saw that in our dp matrix, the only values we cared about were
        1. a row above in same col
        2. $coin steps back in the same row
    - We do not need the entire matrix for this.
    - We can just use a 1D array and keep on overriding the values in the same 1D array
    - The 0 case in 1D array is the same idx we are solving for
    - The 1 casse in 1D array is $coinSteps back..

    Time: o(mn)
        - m = len(coins)
        - n = amount
        - we will be filling out the matrix
    Space: o(n)
    
*/
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
