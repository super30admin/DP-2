// Time Complexity : O(m), m = number of houses
// Space Complexity : O(1), only using 3 variables
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Start backwards from the second last house 
// Determine which color gives us the min cost for each house
// Return the final answer, which will be the min of colorR, colorB, colorG

class Solution {
public:
    int minCost(vector<vector<int>> &costs) {
        int m = costs.size(); 
        if(!m) return 0;

        int colorR = costs[m-1][0];
        int colorB = costs[m-1][1];
        int colorG = costs[m-1][2];

        for(int i = m-2; i>=0; i--) {
            int tempR = colorR;
            int tempB = colorB;
            colorR = costs[i][0] + min(colorB, colorG);
            colorB = costs[i][1] + min(tempR, colorG);
            colorG = costs[i][2] + min(tempR, tempB);
        }

        return min(colorR, min(colorB, colorG));
    }
};