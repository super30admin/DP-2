from typing import List

#

# using the DP approach
class Solution:

    def paintHouse(self, costs: List[int]) -> int:

        if costs is None or len(costs)==0: return -1

        for housecolor in range(len(costs)-2,-1,-1):

            costs[housecolor][0]= costs[housecolor][0]+min(costs[housecolor+1][1],costs[housecolor+1][2])
            costs[housecolor][1] =costs[housecolor][1] + min(costs[housecolor + 1][0], costs[housecolor + 1][2])
            costs[housecolor][2] =costs[housecolor][2] + min(costs[housecolor +1][1], costs[housecolor + 1][0])
        return   min(costs[0][0],min(costs[0][1],costs[0][2]))






if __name__ == '__main__':

    print(Solution().paintHouse(costs = [[17,2,17],[16,16,5],[14,3,19]]))

