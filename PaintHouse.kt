// In this problem, we have 3 variables for each color tracking the cost of painting the houses. we start from the last house and move to the first house,
// updating the costs for each color based on the minimum cost of painting the next house with a different color.
// Time Complexity: O(n) where n is the number of houses.
// Space Complexity: O(1) constant extra space

class Solution {
    fun minCost(costs: Array<IntArray>): Int {
        val n = costs.size
        var cr = costs[n-1][0]
        var cb = costs[n-1][1] 
        var cg = costs[n-1][2]

        for(i in n-2 downTo 0) {
            val tmpR = cr
            val tmpB = cb

            cr = costs[i][0] + Math.min(cb, cg)
            cb = costs[i][1] + Math.min(tmpR, cg)
            cg = costs[i][2] + Math.min(tmpR, tmpB)
        }

        return Math.min(cr, Math.min(cb, cg))
    }
}