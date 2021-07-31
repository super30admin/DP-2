#house paint
#leet code soultion accepted
#time complexitiy O(n) where n is the given array of houses, it is techinically M*n but since color is constant we can disregard it
#space complexity: O(1)
class Solution(object):
    def minCost(self, costs):
        red, blue, green = 0, 0, 0  #red,green and blue are running cost of the houses
        for cr, cb, cg in costs:#cr= current cost of painintg the house red, cb = current for blue and cg= current for green
            #we know that colors cant be repeated so it will be current cost plus previous min 
            red, blue, green = min(blue, green) + cr, min(red, green) + cb, min(red, blue) + cg
        #return the least accumlated sum   
        return min(red, blue, green)