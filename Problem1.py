#Paint House
#Time Complexity : O(n)
#Space Complexity : O(1)
def minCost(cost):
    #Used Top-Down approach
    # Initialised Red,Green,Blue to first row of the cost matrix
    Red=cost[0][0]
    Green=cost[0][1]
    Blue=cost[0][2]

    for i in range(1,len(cost)):
        #Temp variable to store intial value before manipulation
        TempR = Red
        #Cost of new red will be element at i,0 plus minimum of Green and Blue from previous index
        Red=cost[i][0] + min(Green, Blue)
        TempG = Green
        Green=cost[i][1] + min(TempR, Blue)
        Blue=cost[i][2] + min(TempR, TempG)

    return min(Red,Blue,Green)