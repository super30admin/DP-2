class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        vector<int> row(costs[0].size(),INT_MAX);
        vector<vector<int>> vs(costs.size(),row);
        vs[0]=costs[0];
        int houses = vs.size();
        int colors = 3;
        for(int i=1;i<houses;i++)
        {
            for(int j=0;j<colors;j++)
            {
                int tmp = find_abv(i-1,j,vs);
                vs[i][j] = min(vs[i][j],costs[i][j]+tmp);
            }
        }
        //disp(vs);
        return *min_element(vs[houses-1].begin(),vs[houses-1].end());
    }
    void disp(vector<vector<int>> vs)
    {
        for(int i=0;i<vs.size();i++)
        {
            for(int j=0;j<vs[i].size();j++)
            {
                cout<<vs[i][j]<<", ";
            }
            cout<<endl;
        }
    }
    int find_abv(int house, int color, vector<vector<int>> vs)
    {
        int min_val = INT_MAX;
        for(int i=0;i<3;i++)
        {
            if(color!=i)
            min_val = min(min_val,vs[house][i]);
        }
        return min_val;
    }
};