def painthouse(costs):
    if len(costs) == 0:
        return 0
    for i in reversed(range(0, len(costs)-1)):
        costs[i][0] += min(costs[i+1][1], costs[i+1][2])
        costs[i][1] += min(costs[i+1][0], costs[i+1][2])
        costs[i][2] += min(costs[i+1][0], costs[i+1][1])
        print(costs)
    return min(costs[0][0], costs[0][1], costs[0][2])