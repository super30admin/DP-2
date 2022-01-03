# sc O(3)
# tc O(n)
def minCosts(costs):
    if len(costs) ==0:
        return 0
    min_costs = [x for x in costs[-1]]
    print(min_costs)
    for i in range(len(costs)-2, -1,-1):
        temp = [x for x in costs[i]]
        temp[0] = temp[0] + min(min_costs[1], min_costs[2])
        temp[1] = temp[1] + min(min_costs[0], min_costs[2])
        temp[2] = temp[2] + min(min_costs[0], min_costs[1])

        min_costs = [x for x in temp]
        print(min_costs)

    return min(min_costs)



if __name__ == '__main__':
    costs = [[14, 2, 11],
             [11, 14, 5],
             [14, 3, 10]]
    N = len(costs)
    print(minCosts(costs))

