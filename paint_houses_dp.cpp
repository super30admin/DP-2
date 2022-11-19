/*
 * @Author: Yuvaraj Nagi
 * @Date: 2022-11-17 02:08:21
 * @Last Modified by: Yuvaraj Nagi
 * @Last Modified time: 2022-11-18 19:50:53
 */
// Test case
// R G B
/*  [17,2,17]
    [16,16,5]
    [14,3,19]
*/
// Time complexity

// Goal is to return the minimum cost of painting the houses without any two adjacent colors being the same
#include <vector>
#include <math.h>
using namespace std;

Class Solution{
    public int mincost(vector<vector<int>> costs){
        // using dp to find our solution
        // declare number of rows and columns
        int r = costs.size();
int c = costs[0].size();
int red, blue, green = 0;

int case1 = helper(costs, 0, 0, 0);
int case2 = helper(costs, 0, 1, 0);
int case3 = helper(costs, 0, 2, 0);

return min(case1, case2, case3);
}
private
int helper(vector<vector<int>> costs, int index, int color, int total_cost)
{

    if (color == 0)
    {
        return min(helper(costs, index + 1, 1, total_cost + costs[index][0]), helper(costs, index + 1, 2, total_cost + costs[index][0]));
    }

    else if (color == 1)
    {
        return min(helper(costs, index + 1, 0, total_cost + costs[index][0]), helper(costs, index + 1, 2, total_cost + costs[index][0]));
    }

    else
    {
        return min(helper(costs, index + 1, 1, total_cost + costs[index][0]), helper(costs, index + 1, 2, total_cost + costs[index][0]));
    }
}
}
;