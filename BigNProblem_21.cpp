int calcpainthouses(int p[][4])
{
    int m=p[0][0];
    int min_cost=0;
    int r = sizeof(p[0])/sizeof(p[0][0]);
    for(int i=0;i<r;i++)
    {      
                m=min(min(p[i][0],p[i][1]),p[i][2]);
                 min_cost+=m;
    }
    return min_cost;
}


int main() 
{
    int p[][4]={{5,3,2},{4,10,7},{6,2,1},{9,4,1}};
    int cost=0;
    cost=calcpainthouses(p);
    cout<<cost;
}
