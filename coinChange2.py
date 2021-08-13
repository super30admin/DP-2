# Time complexity: O(Nx|coins|) We loop over the input array Nx|coins|
# Space Complexity: O(Nx|coins|), the size of the DP array
def change(amount: int, coins: list[int]) -> int:
    if not coins or coins == []:
        return 0
    dp = [[0 for _ in range(amount+1)] for _ in range(len(coins))]
    dp.insert([1 for _ in range(amount+1)], 0)
    for i in range(1, len(dp)):
        for j in range(1, len(dp[0])):
            if j < coins[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
    return dp[-1][-1]