# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Premium Problem so couldn't test in leetcode  
# Any problem you faced while coding this : No


# def minAmount(arr):
#     return helper(arr, 0, N)


# def helper(arr, ind, prevColour,amount):
#     if ind > arr.length:
#         return amount
#     else:
#         if ind  == 0:
#             return min(helper(arr,1,0,amount + arr[ind][0]),helper(arr,1,1,arr[ind][1]),helper(arr,1,2,arr[ind][2]))
#         return min(helper(arr,1,0,amount + arr[ind][0]),helper(arr,1,1,arr[ind][1])) if prevColour == 2 else min(helper(arr,1,0,amount + arr[ind][0]),helper(arr,1,2,arr[ind][2])) if prevColour == 1 else min(helper(arr,1,1,amount + arr[ind][1]),helper(arr,1,2,arr[ind][2]))




def minAmount(arr):
    for i in range(len(arr)-2,-1,-1):
        arr[i][0] = arr[i][0]+min(arr[i+1][1],arr[i+1][2])
        arr[i][1] = arr[i][1]+min(arr[i+1][0],arr[i+1][2])
        arr[i][2] = arr[i][2]+min(arr[i+1][1],arr[i+1][0])
    
    return min(arr[0][1],arr[0][2],arr[0][0])