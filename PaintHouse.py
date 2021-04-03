# Top Down Memoization Approach. We have two choices for every color for each house, pick a color or not pick a color.
# Time Complexity is O(N) and Space complexity is O(N) as we are using a Hashmap to store the values of computations
# and using the recursive stack, where N being the number of houses
class Solution(object):
    def __init__(self):
        self.mem = {}
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        return self.pickMinCost(costs,'',0)
    
    def pickMinCost(self,costs,prevColor,index):
        if(len(costs) == index):
            return 0
        if((prevColor,index) in self.mem):
            return self.mem[(prevColor,index)]
        # We have 3 options to pick for each house
        case1 = sys.maxint
        case2 = sys.maxint
        case3 = sys.maxint
        if('0' not in prevColor):
            # Pick Red
            case1 = costs[index][0] + self.pickMinCost(costs,'0',index+1)
        if('1' not in prevColor):
            # Pick green
            case2 = costs[index][1] + self.pickMinCost(costs,'1',index+1)
        if('2' not in prevColor):
            # Pick Blue
            case3 = costs[index][2] + self.pickMinCost(costs,'2',index+1)
        self.mem[(prevColor,index)] = min(case1,case2,case3)
        return min(case1,case2,case3)