class Solution
  def minCost(costs):
    if costs==None or len(costs)==0:
      return 0
    n=len(costs)-1
    for i in range(len(costs)):
      costs[i][0]+=min(costs[i-1][1],costs[i-1][2])
      costs[i][1]+=min(costs[i-1][0],costs[i-1][2])
      costs[i][2]+=min(costs[i-1][1],costs[i-1][0])
    return min(costs[n][0],min(costs[n][1],costs[n][2]))
    
