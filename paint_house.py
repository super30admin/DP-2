#  Memoization
# Time Complexity: O(n*3*3) = O(n)
# Space Complexity: O(n*3) = O(n)

def minCost(costs):
    num_houses = len(costs)
    num_colors = 3
    memo = {}

    def min_cost_helper(current_house, last_color):
        if (current_house, last_color) in memo:
            return memo[(current_house, last_color)]

        if current_house == 0:
            min_cost = float('inf')
            for color in range(num_colors):
                if color != last_color:
                    min_cost = min(min_cost, costs[0][color])
            memo[(current_house, last_color)] = min_cost
            return min_cost

        min_cost = float('inf')
        for color in range(num_colors):
            if color != last_color:
                min_cost = min(min_cost, costs[current_house][color] + min_cost_helper(current_house - 1, color))
        memo[(current_house, last_color)] = min_cost
        return min_cost

    min_cost = float('inf')
    for color in range(num_colors):
        min_cost = min(min_cost, min_cost_helper(num_houses - 1, color))
    return min_cost


#  DP
# Time Complexity: O(n)
# Space Complexity: O(n)

def minCost(costs):
    num_houses = len(costs)
    if num_houses == 0:
        return 0

    dp = [[0]*3 for _ in range(num_houses)]
    dp[0] = costs[0]

    for i in range(1, num_houses):
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + costs[i][0]
        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + costs[i][1]
        dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + costs[i][2]

    return min(dp[-1])


# Time Complexity: O(n)
# Space Complexity: O(1)
def minCost(costs):
    num_houses = len(costs)
    if num_houses == 0:
        return 0

    prev_row = costs[0]
    for i in range(1, num_houses):
        curr_row = [0]*3
        curr_row[0] = min(prev_row[1], prev_row[2]) + costs[i][0]
        curr_row[1] = min(prev_row[0], prev_row[2]) + costs[i][1]
        curr_row[2] = min(prev_row[0], prev_row[1]) + costs[i][2]
        prev_row = curr_row

    return min(prev_row)



