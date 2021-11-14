"""
 Time Complexity :
 Space Complexity :
 Did this code successfully run on Leetcode :
 Any problem you faced while coding this :


 Your code here along with comments explaining your approach """
def CoinChange2(amount, coins)-> int:
    return helper(amount, coins, 0)

def helper(amount, coins, combinations) -> int:
    # base
    if amount == 0:
        return 1
    if amount < 0 or len(coins)<=0:
        return 0


    #logic
    #Choose Case
    case1 = helper(amount - coins[0], coins, combinations + 1)

    #Not Choose Case
    case2 = helper(amount, coins[1:], combinations)

    return case1 + case2

output = CoinChange2(5, [1,2,5])
print(output)

output = CoinChange2(5, [2])
print(output)

output = CoinChange2(500, [200,40,100,5,1,600])
print(output)
