// Problem - Paint House
//  Time Complexity : O(m)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Here we use 3 variables since we have only 3 colors (RGB)
// 2. We store tempR and tempB so that we  don't lose the previous values and
// keep on calculating the minimum
// 3. In the end we return minimum of all the three values

#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
  int minCost(vector<vector<int>> &costs) {
    int m = (int)costs.size();
    int colorR = costs[0][0];
    int colorB = costs[0][1];
    int colorG = costs[0][2];

    for (int i = 1; i < m; i++) {
      int tempR = colorR;
      colorR = costs[i][0] + min(colorB, colorG);
      int tempB = colorB;
      colorB = costs[i][1] + min(tempR, colorG);
      colorG = costs[i][2] + min(tempR, tempB);
    }

    return min({colorR, colorB, colorG});
  }
};
