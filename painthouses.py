
def painthouse(matrix):
    lredhouse=matrix[0][0]
    lgreenhouse=matrix[0][1]
    lbluehouse=matrix[0][2]
    for i in range(1,len(matrix)):
        currentred=min(lgreenhouse,lbluehouse)+matrix[i][0]
        currentgreen=min(lbluehouse,lredhouse)+matrix[i][1]
        currentblue=min(lgreenhouse,lredhouse)+matrix[i][2]
        lredhouse=currentred
        lbluehouse=currentblue
        lgreenhouse=currentgreen
    return min(min(lgreenhouse,lbluehouse),lredhouse)


if __name__ == '__main__':
    matrix=[[17,2,17],[16,16,5],[14,3,19]]
    val=painthouse(matrix)
    print(val)
