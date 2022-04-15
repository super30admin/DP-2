#Time Complexity : 0(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : The given question is premium
#leetcode. I ran code on other website.
#Any problem you faced while coding this : no


def minCost(self, costs: List[List[int]]) -> int:
        red, blue, green = 0,0,0
        for r, b, g in costs:
                red, blue, green = min(blue, green) + r, min(red, green) + b, min(red, blue) + g
            return min(red, blue, green) 