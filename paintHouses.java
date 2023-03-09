
public class paintHouses {
    public int paintHouses(int costs[][]){
    if(costs==null) return 0;
    int n = costs.length;
    int redCost= costs[n-1][0];
    int blueCost=costs[n-1][1];
    int greenCost = costs[n-1][2];
    for(int i =n-2;i>=0; i--){
        int tempR= redCost; 
        redCost=costs[i][0]+Math.min(blueCost,greenCost);
        int tempB = blueCost;
        blueCost=costs[i][1]+Math.min(redCost,greenCost);
        greenCost=costs[i][2]+Math.min(redCost,blueCost);

        
    }
    return Math.min(redCost,Math.min(blueCost,greenCost));
    }
}
