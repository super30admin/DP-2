class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        cost_step = costs[0]
        print(costs)
        #0 Red, 1 Blue, 2 Green
        #for each step see the optimal cost till that point
        #for final step, the optmal decision traces back to min path
        for i in range(1,len(costs)):
            cost_current =costs[i]
            temp =  [0,0,0]
            temp[0] =  min(cost_step[1], cost_step[2]) + cost_current[0]
            temp[1] =  min(cost_step[0], cost_step[2]) + cost_current[1]
            temp[2] =  min(cost_step[0], cost_step[1]) + cost_current[2]
            cost_step = temp
            print(i,cost_step)
            
        return min(cost_step)


#time complexity O(n)  n is number of houses to be painted
#space complexity O(m) m is 3 hard coded, can be modified to generalize on number of paints 4,5,6
        