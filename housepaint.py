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
















                                                                                                                                                            
