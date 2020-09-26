// Time Complexity : O(n) where n is length of costs array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        red, blue, green = 0, 0, 0
        for cr, cb, cg in costs:
            red, blue, green = min(blue, green) + cr, min(red, green) + cb, min(red, blue) + cg
        return min(red, blue, green)
                