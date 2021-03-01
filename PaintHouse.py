# Time Complexity - O(N)
# Space Complexity - O(1)

# Algorithm - We are calculating minimum price for all red, blue and gree paths. Then we are finding minimum
#             of all the three costs i.e. costR, costB and costG

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        costsR=costs[0][0]
        costsB=costs[0][1]
        costsG=costs[0][2]
        minB=0
        minR=0
        minG=0
        for i in range(1,len(costs)):
            minB=min(costsR,costsG)+costs[i][1]
            minR=min(costsB,costsG)+costs[i][0]
            minG=min(costsR,costsB)+costs[i][2]
            costsR=minR
            costsB=minB
            costsG=minG
        return min(costsR,costsB,costsG)