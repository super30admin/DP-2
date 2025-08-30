def change(self, amount: int, coins: List[int]) -> int: #Tc:O(m*n) SC: O(n)
        d=[0]*(amount+1)
        d[0]=1
        for c in coins:
            for a in range(c,amount+1):
                if a-c>=0:
                    d[a]=d[a]+d[a-c]
        return -1 if d[amount]==9999 else d[amount] 