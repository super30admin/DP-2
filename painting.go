// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No premium question
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
initial 3 vars with 0
in loop find value for all 3 vars as current = previous + min of non adjacent current
return minimum of the 3 vars
*/

package main

import "fmt"

func minCost(costs [][]int) int {
	if len(costs) == 0 {
		return 0
	}
	n := len(costs)
	r,b,g := 0,0,0
	for i := 0; i < n; i++ {
		tr,tb := r, b
		r = costs[i][0] + min(b, g)
		b = costs[i][1] + min(tr, g)
		g = costs[i][2] + min(tr, tb)
	}
	return min(r, min(g,b))
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func MainPainting() {
	fmt.Println(minCost([][]int {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}})) //expected 10
}
