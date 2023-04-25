// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Don't have access (premium)
//    so tried elsewhere (InterviewBit has the same problem)
//    https://www.interviewbit.com/problems/paint-house/
// Any problem you faced while coding this : Need premium to submit on Leetcode

/*

Approach:
Since we know there are only 3 colors with a set of constraints that adjacent
houses cannot be painted with the same color, we follow the House Robber
pattern in order to compute the minimum cost for painting. We mutate the given
costs array in a bottom-up manner (consider it as all leaf nodes in the
decision tree) such that the top row will finally contain the minimum costs for
each path taken to paint each house, and we choose the min out of those.

*/

package main

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func paint(costs [][]int) int {
	if len(costs) == 0 {
		return 0
	}

	n := len(costs)

	for i := n - 2; i >= 0; i-- {
		// RED
		costs[i][0] += min(
			costs[i+1][1],
			costs[i+1][2])
		// BLUE
		costs[i][1] += min(
			costs[i+1][0],
			costs[i+1][2])
		// GREEN
		costs[i][2] += min(
			costs[i+1][0],
			costs[i+1][1])
	}

	return min(costs[0][0], min(costs[0][1], costs[0][2]))
}
