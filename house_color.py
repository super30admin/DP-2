'''
Time complexity: O(n) because it traverses through consecutive houses
Space complexity: O(1) because it works on two single array of 3 values.
'''
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        temp = costs[-1]

        for i in range(len(costs)-2,-1,-1):
            # print(temp)
            
            temp_new = costs[i]
            temp_new = [temp_new[0]+min(temp[1],temp[2]),
                        temp_new[1]+min(temp[0],temp[2]),
                        temp_new[2]+min(temp[0],temp[1])]
            temp = temp_new
        
        return min(temp)