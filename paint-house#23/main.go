/*
*
  - @param costs: n x 3 cost matrix
  - @return: An integer, the minimum cost to paint all houses

the challenge was pretty much to get started on the question. I knew there have to be combications for houses but picking those elements from the
given matrix and writing it down on board was something that I struggled at.

iterating bottom up on the dp matrix

There are 3 possible solutions
- the recursive way. going to circle back at this later
- DP1 : where you can mutate the existing given matrix
- DP2 : you initialize a dp matrix. When you draw the decision tree, you will see that when you are calculating the cost associated with when choosing a
given value, you just require the values from a level below. Hence a 1D array is good to started with.
- DP3 : where you optimize for space and do not use the dp matrix. this can be ball parked for now, but knowing that this can be done is and how you reached
to it is of essence.
*/
package main

import "fmt"

//Time : O(n) : where n is the number of rows in the dp matrix
//Space : ~O(1) - will be a constant as size of dp matrix will be constant for mXn matirx

func MinCost(costs [][]int) int {
	// write your code here
	// init a dp matrix
	fmt.Println(len(costs))
	dp := make([][]int, len(costs))

	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, 3)
	}
	// inserting values for the last row; i.e. the last row
	for i := 0; i < len(dp); i++ {
		dp[len(dp)-1][i] = costs[len(dp)-1][i]
	}
	fmt.Println(dp)

	//logic
	fmt.Println("i is 000")
	for i := len(costs) - 2; i >= 0; i-- {
		fmt.Println("i is", i)
		// its given we have 3 houses; so we can safely hardcode for colors
		dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
		dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
		dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
	}
	fmt.Println(dp)
	return min(min(dp[0][0], dp[0][1]), dp[0][2])
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	fmt.Println(MinCost([][]int{
		[]int{14, 2, 11},
		[]int{11, 14, 5},
		[]int{14, 3, 10},
	}))
}
