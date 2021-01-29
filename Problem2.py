# There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each
# house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

# The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
# For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1
# with color green, and so on... Find the minimum cost to paint all houses.

# Example 1:
#
# Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
# Output: 10
# Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
# Minimum cost: 2 + 5 + 3 = 10.
# Example 2:
#
# Input: costs = []
# Output: 0
# Example 3:
#
# Input: costs = [[7,6,2]]
# Output: 2


def main():
    costs = [[17, 2, 17], [16, 16, 5], [14, 3, 19]]
    ans = minCost(costs)
    print(ans)
def minCost(costs):
    # Here the idea was to start from 2nd row and update from top and go down
    # We choose three variables and update these variables and finally take min of these three.
    red = 0
    green = 0
    blue = 0

    # Iterate over each row and add the above values plus the current cost and update them accordingly

    for cost in costs:
        # Before updating red we make a temp variable for Red
        tempRed = red

        # So the first column is the current value + the min of green and blue of above row.
        red = cost[0] + min(green, blue)

        # Before updating green we make a temp variable for green
        tempGreen = green

        # So the second column is the current value + the min of red and blue of above row.
        # Here the red is temp Red because we updated the value of red
        green = cost[1] + min(tempRed, blue)

        # No temp is required for blue because we dont use blue to update any other value.
        # So the third column is the current value + the min of tempRed and tempGreen of above row.
        blue = cost[2] + min(tempRed, tempGreen)

    # Finally these three are the min of costs till last rows. Then return the min of last row in the end.
    return min(red, green, blue)

if __name__ == '__main__':
    main()