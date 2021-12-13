package sol;






public class PaintHouse {
public int minCost(int[][] costs) {
    
       
        
        for(int i=1;i<costs.length;i++){
            for( int j=0;j<costs[0].length;j++){
                
                if(j==0){
                    
                    costs[i][j]=costs[i][j]+Math.min(costs[i-1][2],costs[i-1][1]);
                    
                }else if( j==1){
                     costs[i][j]=costs[i][j]+Math.min(costs[i-1][0],costs[i-1][2]);
                    
                }else{
                    
                    costs[i][j]=costs[i][j]+Math.min(costs[i-1][0],costs[i-1][1]);
                }
                
            }
        }
        
        return Math.min(costs[costs.length-1][0],Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
        
        
    }
    
}
