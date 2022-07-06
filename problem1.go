// Time Complexity : o(m*n)---> O(N)
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Approach 1
func minCost(costs [][]int) int {
    if len(costs) == 0 {
        return 0
    }  
    
    n:= len(costs)
    
    for i:= n-2;i>=0;i--{
        costs[i][0] += min(costs[i+1][1],costs[i+1][2])
        costs[i][1] += min(costs[i+1][0],costs[i+1][2])
        costs[i][2] += min(costs[i+1][0],costs[i+1][1])
    }
    
    
    return min(costs[0][0],min(costs[0][1],costs[0][2]))
}

//Approach 2 Time limit Exceed
func minCost(costs [][]int) int {
    if len(costs) == 0 {
        return 0
    }  
 
    red := helper(costs,0,0,0)
    green := helper(costs,0,1,0)
    blue:= helper(costs,0,2,0)
 
    return min(red,min(green,blue))
}



func helper(costs [][]int,row int,color int,cost int) int{
 
    if row == len(costs){
        return cost
    }
 
 
    if color == 0{
        return min(helper(costs,row+1,1,cost+costs[row][0]),helper(costs,row+1,2,cost+costs[row][0]))
    }
                
    if color ==1{
        return min(helper(costs,row+1,0,cost+costs[row][1]),helper(costs,row+1,2,cost+costs[row][1]))                   
    }
                
    if color == 2{
        return min(helper(costs,row+1,0,cost+costs[row][2]),helper(costs,row+1,1,cost+costs[row][2])) 
    }
 
    return 5454 //Any number
}


func min(a,b int) int{
    if a < b{
        return a
    }
    
    return b
}
