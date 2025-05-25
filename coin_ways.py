# time complexity O(n)
#space complexity O(n)
def number_of_ways(coins, amount)->int:
    m = len(coins)+1 # rows
    n = amount+1     # columns

    dp = [[0 for _ in range(n)] for _ in range(m)]
    dp[1][0] = 1
    dp[1][1] = 1
    dp[1][2] = 1
    dp[1][3] = 1
    dp[1][4] = 1
    dp[1][5] = 1

    for i in range(2, m):
        for j in range(0, n):
            if j < coins[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

    print(dp)

if __name__ == "__main__":
    coins = [1,2,5]
    amount = 5
    number_of_ways(coins, amount)