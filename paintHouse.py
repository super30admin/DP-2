# Time complexity: O(N) We loop over the input Nx3 array.
# Space Complexity: O(1), we reuse the old array.
def minCost(costs):
    '''minCost Function definition. '''
    if not costs or len(costs) == 0:
        return 0
    for i in range(len(costs)-2, -1, -1):
        costs[i][0] += min(costs[i+1][1],costs[i+1][2])
        costs[i][1] += min(costs[i+1][0],costs[i+1][2])
        costs[i][2] += min(costs[i+1][0],costs[i+1][1])
    return min(costs[0][0], costs[0][1], costs[0][2])