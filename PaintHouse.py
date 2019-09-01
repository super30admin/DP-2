"""
The approach here is to intialize the first row elements as the lastR lastG and lastB
now iterate through the array and from the second row onwards everytime check for min
of last of other two colors in the previous row. after first iteration set last to cur
for all colors and repeat the process until the last row. at the last row return the
min element.

Time complexity = 2^N
Leetcode running

"""

def paint(nums):
    lastR = nums[0][0]
    lastG = nums[0][1]
    lastB = nums[0][2]
    for i in range(1,len(nums)):
        curR = min(lastG,lastB) + nums[i][0]
        curG = min(lastR,lastB) + nums[i][1]
        curB = min(lastR,lastG) + nums[i][2]
        lastR = curR
        lastG = curG
        lastB = curB
    return min(lastR, lastG, lastB)

print(paint([[2,11,7],[17,12,17],[3,4,5]]))