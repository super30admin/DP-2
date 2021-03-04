class Solution:

    def findMinCost(self,nums):
        
        n = len(nums)

        if (not nums):
            return 0
        
        if (n == 1):
            return max(nums[0])

        '''
       
        # Method 1 - Hard Code
        
        for i in range(1,n):

            # Red
            nums[i][0] = nums[i][0] +  min (nums[i-1][1],nums[i-1][2])

            #Blue
            nums[i][1] = nums[i][1] + min (nums[i-1][0],nums[i-1][2])

            #Green
            nums[i][2] = nums[i][2] + min (nums[i-1][1],nums[i-1][0])


        
        return min(nums[n-1][0], nums[n-1][1], nums[n-1][2])

        # TC : O(n) (n = no.of houses)
        # SC : O(1) ( As we are not taking anthing other than the N X 3 Matrix )


        '''
        #Method 2 - Generalized Code

        m = len(nums[0]) # No. of Columns
        

        for i in range(1,n): # Looping over rows
            for j in range(m): #Looping over Cloumns
                MIN = float('inf') #Declaring inf to compare with min 
                for k in range(m):
                    
                    if (k != j):
                        MIN =   min (nums[i-1][k], MIN) #Comparing for min with all the values except the value
                        #in the same columns
                        
                
               
                nums[i][j] = nums[i][j] + MIN


        # Returning min from last column
        MIN = float('inf')
        for x in range(m):
            MIN = min (nums[n-1][x],MIN)

        return MIN


        # TC : O(n x m) # n - rows and m - columns ( not O(n x m^2) as the third loop will be repeated constant time)
        # SC : O(n x m)
        



                
