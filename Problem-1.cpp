#include <bits/stdc++.h>
using namespace std;

//TC. O(n^2)
//SC O(1)
int minCost(vector<vector<int>> &costs) {

    if(costs.size() == 0)
        return 0;
    int res = 0;
    for(int i =0;i<costs.size();i++){
        res+= *min_element (costs[i].begin(), costs[i].end());
    }
    return res;
}

int main()
{
    vector<vector<int>> costs = {
        {17, 2, 17},
        {16, 16, 5},
        {14, 3, 19}
    };
    int k = minCost(costs);
    cout << k;
    return 0;
}
