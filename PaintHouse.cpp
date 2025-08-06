#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We work backwards from the last house, storing just 3 variables for the colors.
For each house, we update the color costs based on the min of the other two from the next house.
Finally, we return the minimum among the three updated values
*/
class Solution{
public:
    int minCost(vector<vector<int>>& costs) {
        int m = costs.size();
        int n = costs[0].size();

        int colorR = costs[m-1][0];
        int colorB = costs[m-1][1];
        int colorG = costs[m-1][2];

        for(int i = m - 2; i >= 0; i--) {
            int tempR = colorR;
            int tempB = colorB;

            colorR = costs[i][0] + min(colorB, colorG);
            colorB = costs[i][1] + min(tempR, colorG);
            colorG = costs[i][2] + min(tempR, tempB);
        }

        return min(colorR, min(colorB, colorG));
    }
};
