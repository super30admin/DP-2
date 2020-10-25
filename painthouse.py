class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if len(costs) == 0 or costs == None:
            return 0
        #         def helper(costs,colour,house,count):
        #             if house==len(costs):
        #                 return count
        #             #choose
        #             case1=float('inf')
        #             case2=float('inf')
        #             case3=float('inf')
        #             if colour==0:
        #                 case2=helper(costs,1,house+1,count+costs[house][1])
        #                 case3=helper(costs,2,house+1,count+costs[house][2])
        #             if colour==1:
        #                 case1=helper(costs,0,house+1,count+costs[house][0])
        #                 case3=helper(costs,2,house+1,count+costs[house][2])
        #             if colour==2:
        #                 case1=helper(costs,0,house+1,count+costs[house][0])
        #                 case2=helper(costs,1,house+1,count+costs[house][1])
        #             # print(min(case1,case2,case3))
        #             return min(case1,case2,case3)
        #         # minn=99999

        # #         for i in range(3):
        # #             # print(helper(costs,i,0,0))
        # #             if helper(costs,i,0,0)<minn:

        # #                 minnn=helper(costs,i,0,0)
        # #                 # print(minn)
        # #         print(minn)
        # #         return minn
        #         case1=helper(costs,0,0,0)
        #         case2=helper(costs,1,0,0)
        #         case3=helper(costs,2,0,0)
        #         return min(case1,min(case2,case3))
        #time-O(3*(2**n))
        # space-O(n)
        cr = costs[0][0]
        cb = costs[0][1]
        cg = costs[0][2]
        for i in range(1, len(costs)):
            #without mutating the matrix
            tempr = cr
            tempb = cb
            tempg = cg
            cr = costs[i][0] + min(cb, cg)
            cb = costs[i][1] + min(tempr, cg)
            cg = costs[i][2] + min(tempr, tempb)

        return min(cr, cb, cg)
    # time-O(n)
    # space-O(1)