# Time Complexity : O(3**n)
# Space Complexity : O(logn)
# Did this code successfully run on Leetcode : No   
# Any problem you faced while coding this : Couldn't solve with DP


def minAmount(arr):
    return helper(arr, 0, N)


def helper(arr, ind, prevColour,amount):
    if ind > arr.length:
        return amount
    else:
        if ind  == 0:
            return min(helper(arr,1,0,amount + arr[ind][0]),helper(arr,1,1,arr[ind][1]),helper(arr,1,2,arr[ind][2]))
        return min(helper(arr,1,0,amount + arr[ind][0]),helper(arr,1,1,arr[ind][1])) if prevColour == 2 else min(helper(arr,1,0,amount + arr[ind][0]),helper(arr,1,2,arr[ind][2])) if prevColour == 1 else min(helper(arr,1,1,amount + arr[ind][1]),helper(arr,1,2,arr[ind][2]))