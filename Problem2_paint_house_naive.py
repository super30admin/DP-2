class Solution:
    #exhaustive approach of trying out all possibilities and the time complexity 
    # is m*2^n where m is number of colors
    def minCost(self, costs):  # 0-R, 1-B, 2-G
        colorR = self.helper(costs, 0, 0, 0)
        colorB = self.helper(costs, 0, 1, 0)
        colorG = self.helper(costs, 0, 2, 0)
        #return the minimum cost out of all the 3 colors
        return min(colorR, colorB, colorG)

    def helper(self, costs, i, color, totalCost):
        #base
        # If we’ve already painted all houses (index i has reached the end of the list),
        # then there are no more recursive choices to make,
        # so we just return the accumulated total cost.
        if(i==len(costs)):
            return totalCost

        #logic 
        #if color is Red
        if(color == 0):
            #2 possibilities
            colorB = self.helper(costs, i+1, 1)
            colorG = self.helper(costs, i+1, 2)
            return costs[i][0] + min(colorB, colorG)
        
        #color is blue
        elif(color == 1):
            colorR = self.helper(costs, i+1, 0)
            colorG = self.helper(costs, i+1, 2)
            return costs[i][1] + min(colorR, colorG)
        
        #Green
        elif(color == 2):
            colorR = self.helper(costs, i+1, 0)
            colorB = self.helper(costs, i+1, 1)
            return costs[i][1] + min(colorR, colorB)
        
        return max.size()