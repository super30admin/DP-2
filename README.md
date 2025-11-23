# DP-2

## Problem1(https://leetcode.com/problems/paint-house/)
* paint houses with colors R, B, G such that no 2 houses have same color.
* Greedy - choose min from first row, then choose min from other 2. This fails when 1st choice is wrong. Try exhaustive.
* Keep the last row as it is, the elements will be that sum of that element + min of element of other 2 colors  in the below row.
             

## Problem2 (https://leetcode.com/problems/coin-change-2/)
* indefinite - Return the number of combinations that make up that amount
* if denomination > amount, return from top row
* else that element + smae row element & denomination steps back

