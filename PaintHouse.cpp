#include<bits/stdc++.h>
using namespace std;
int minCost(vector<vector<int>>& cost) {
    int n = cost.size();
    if (n == 0) 
        return 0;
    for (int i = n - 2; i >= 0; i--) {
        cost[i][0] += min(cost[i + 1][1], cost[i + 1][2]);
        cost[i][1] += min(cost[i + 1][0], cost[i + 1][2]);
        cost[i][2] += min(cost[i + 1][0], cost[i + 1][1]);
    }
    return min({cost[0][0], cost[0][1], cost[0][2]});
}
int main() {
    vector<vector<int>> costs = {
        {17, 2, 17},
        {16, 16, 5},
        {14, 3, 19}
    };
    cout << "Minimum Cost to Paint Houses: " << minCost(costs) << endl;
    return 0;
}
