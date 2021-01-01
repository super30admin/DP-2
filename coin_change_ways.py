# Approach: 
# Define the case for ways to generate 0$ and at every value throught amount's range check with each coin denom how many will be needed 
# If denom > amt -- Do nothing
# Else, apply the formula to get the ways required to generate amount at given index
# Time Complexity: O(M* N) where M is the number of coins and N is the amount
# Space Complexity: O(N) where N is the amount value we store at the array
# Successfully ran on leetcode
# Will try the 2d matrix approach discussed since we have 2 variables here


def change(self, amount: int, coins: List[int]) -> int:
    ways = [0 for amt in range(amount + 1)]
    ways[0] = 1
    # To make 0$ there is just one way which is not using any coins
    
    for denom in coins:
        for amt in range(amount + 1):
            if denom <= amt:
                ways[amt] = ways[amt] + ways[amt - denom]
                
    return ways[amount]
        