package main

import "fmt"

/*

brute force - TODO - the recursize approach

optimal
- going to see if there is a solution availble for subproblem and increment a counter
- instaed of inserting min, i think I should insert if the sum can be formed or not

*/

// Time : O(mXn) - i.e. time taken to traverse over the DP matrix and solving the problems and where m and n are the rows and columns of the matrix
// Space : O(mXn) - size of dp matrix, which be O(1) as mXn will be a constant

func change(amount int, coins []int) int {

	m := len(coins) + 1
	n := amount + 1

	// need a dp matrix
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
	}
	fmt.Println(dp)

	// while solving I got a feeling that I need to insert values for making 1 sum with 1 coin - :mindblown:
	for i := 0; i < m; i++ {
		dp[i][0] = 1
	}

	//fmt.Println(dp)
	for i := 1; i < m; i++ { // represent coin in the matrix
		for j := 1; j < n; j++ { // represent sum in the matrix
			coin := coins[i-1]
			sum := j
			//fmt.Println("sum is", sum, "coin is", coin)
			if sum < coin {
				// i cannot make sum 2 with a coin of 5 denomination
				// copy values for reference when solving another sub problem
				dp[i][j] = dp[i-1][j]
				continue
			}
			dp[i][j] = dp[i-1][j] + dp[i][j-coin]
		}
	}
	return dp[m-1][n-1]
}
