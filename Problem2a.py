class Solution(object):
    def change(self, amount, coins):
        """
        Time complexity: O (2^(m+n))
        Space complexity: O(m+n)
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # Check if the coins array is empty
        if coins is None:
            return 0

        def helper(coins, idx, amount):
            # Base case: If amount becomes zero, return 1 the as we found a valid path
            if amount == 0:
                return 1
            # Base case: If amount becomes negative or we have exhausted all coins, return -1, dint find valid path
            if amount < 0 or idx == len(coins):
                return 0

            # Recursive calls
            # Don't choose the current coin and move to the next coin
            case0 = helper(coins, idx + 1, amount)
            # Choose the current coin and subtract its value from the amount
            case1 = helper(coins, idx, amount - coins[idx])
            # Total number of valid combinations from both cases
            return (case0 + case1)

        # Call the helper
        return helper(coins, 0, amount)
