class Solution:
    def change(self, n: int, denoms: List[int]) -> int:
        ways = [0 for amount in range(n+1)]
        ways[0] = 1
        for denom in denoms:
            for amount in range(denom,n+1):
                ways[amount] = ways[amount] + ways[amount - denom]
        return ways[-1]