#Time Complexity:O(mn)
#Space Complexity:O(mn)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
            if(amount==0):
                 return 1
            if len(coins)==0:
                return 0
            result=[]
            result.append([0 for i in range(amount+2)])
            for i in range(len(coins)):
                arr=[]
                arr.append(1)
                r=result[i]
                for j in range(1,amount+1):
                    if coins[i]>j:
                        arr.append(r[j])
                    else:
                        arr.append(r[j]+arr[j-coins[i]])
                result.append(arr)
            return arr[-1]