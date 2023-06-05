# Time Complexity : O(cn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution
{
    public:
    int minCost(std::vector<std::vector<int>> &costs)
    {
        int N = costs.size();
        int r = costs[0][0];
        int b = costs[0][1];
        int g = costs[0][2];
        for (int i = 1; i < N; i++)
        {
            int prevR = r;
            int prevB = b;
            int prevG = g;
            r = min(prevB,prevG) + costs[i][0];
            b = min(prevR,prevG) + costs[i][1];
            g = min(prevR,prevB) + costs[i][2];
        }
        return min(r,min(b,g));
    }
};