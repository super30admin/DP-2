def PaintHouse5(costs):

    # Using the costs array itself, performing an in place updation
    #2nd row onwards>> see if red selcted in row2,row1 possibilities blue and green>min of these both
    #thus each row computes only that and previous row's answer
    #likewise build colors cases for other options
    #final row has all computations already remembered

    if len(costs) == 1:
        return min(costs[0])
    for i in range(1, len(costs)):
        costs[i][0] += min(costs[i - 1][1], costs[i - 1][2])
        costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])
        costs[i][2] += min(costs[i - 1][0], costs[i - 1][1])
    
    return min(costs[-1])

if __name__ == '__main__':
    print(PaintHouse5([[17, 2, 1],[16,16,1],[14,3,19],[3,1,8]]))

#leetcode premium problem
#O(MN) where N is color array size
#O(1)