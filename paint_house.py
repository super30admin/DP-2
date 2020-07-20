#time complexity: Number of houses * no.of colours
#Space complexity : Number of houses * no.of colours


def PaintHouse(costs):
    if len(costs) == 0:
        return 0
    for i in range(1,len(costs)):
            costs[i][0] += min(costs[i-1][1],costs[i-1][2])

            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])

            costs[i][2] += min(costs[i - 1][0], costs[i - 1][1])

    return min(costs[2][0],costs[2][1],costs[2][2])

print(PaintHouse([[17,2,17],[16,16,5],[14,3,19]]))
