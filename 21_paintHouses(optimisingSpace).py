# did not execute in leetcode
# time - O(N), space O(1)
# Worked with 3 variables for 3 colors and at everystep getting the minimum of other two colors.
def minCost(costs):
    if costs is None or len(costs) == 0: return 0

    prevRed = costs[0][0] # red
    prevGreen = costs[0][1] # green
    prevBlue = costs[0][2] # blue


    for i in range(1,len(costs)):
        print("previous",prevRed, prevGreen, prevBlue)
        currRed = min(prevBlue,prevGreen) + costs[i][0]  # red
        currGreen = min(prevBlue,prevRed) + costs[i][1]  # green
        currBlue = min(prevGreen,prevRed) + costs[i][2]  # blue
        prevGreen = currGreen
        prevRed = currRed
        prevBlue = currBlue
        print(currRed,currGreen,currBlue)

    # return the minimum from last row.
    return min(currRed,currGreen,currBlue)

print(minCost([[17,2,17],[16,16,5],[14,3,19]]))
