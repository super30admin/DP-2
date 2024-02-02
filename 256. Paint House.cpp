/*
  Time complexity: O(N)
  Space complexity: O(1)  (modifying the input array)
*/

int minCost(vector<vector<int>>& costs) {
  int n = costs.size();

  for(int i=n-2;i>=0;i--){
    costs[i][0] = costs[i][0] + min(costs[i+1][1],costs[i+1][2]);
    costs[i][1] = costs[i][1] + min(costs[i+1][0],costs[i+1][2]);
    costs[i][2] = costs[i][2] + min(costs[i+1][0],costs[i+1][1]);
  }

  return min({costs[0][0], costs[0][1], costs[0][2]});
}


