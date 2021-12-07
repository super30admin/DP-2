// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* For each house we have 3 choices and each choice depends on the choices selected for previous house.
 * Maintain three variables for each color, each variable indicates a minimum cost achieved till that point if a given color is selected.
 * Iterate over the houses and compute the cost of each color selection using previous color cost values stored in the color variables.
 * Update the color variables with the new computed value to store minimum cost achieved till that house for a specific color selection.
 */

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        // Top down approach
        if (costs.size() == 0)
            return 0;
        
        int red, blue, green;
        int tr, tb, tg;
        red = blue = green = 0;

        for (auto itr : costs)
        {
            tr = itr[0] + min(blue, green);
            tb = itr[1] + min(red, green);
            tg = itr[2] + min(red, blue);
            
            red = tr;
            blue = tb;
            green = tg;
        }
        
        return min(min(red, blue), green);
    }
};