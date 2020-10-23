// Time Complexity : O(nm)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
initial array of amount +1 size
for each coin overwrite the number of ways for all values till amount with current + ways to make j-coins[i]
only start second loop from coins[i] value as before this all values will remain same
*/

package main

import "fmt"

func change(amount int, coins []int) int {
	if len(coins) == 0 && amount == 0 {
		return 1
	}
	if len(coins) == 0 {
		return 0
	}
	var p = make([]int, amount + 1)
	p[0] = 1

	for i:=0; i< len(coins);i++ {
		for j:=coins[i]; j <= amount; j++  {
			p[j] += p[j-coins[i]]
		}
	}
	return p[amount]
}

func MainChange() {
	fmt.Println(change(5, []int{1,2,5})) //expected 4
}

