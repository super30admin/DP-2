#time complexity: o(n2)
#it ran on leetcode
# no doubt

#code explaination:
#this is similar like pathsum.
#we take the first row as red, green and blue
#we traverse downward, apart from that coloumn and find the minimum among the other two elements  at the top and add
# the minimum to the cuurent element
def painthouse(matrix):
    lredhouse=matrix[0][0]
    lgreenhouse=matrix[0][1]        #taking the first row as red blue and green
    lbluehouse=matrix[0][2]
    for i in range(1,len(matrix)): #we are traversing down
        currentred=min(lgreenhouse,lbluehouse)+matrix[i][0]  #finding the minimum of other two coloumns and adding
        currentgreen=min(lbluehouse,lredhouse)+matrix[i][1]
        currentblue=min(lgreenhouse,lredhouse)+matrix[i][2]
        lredhouse=currentred #making the current to the assigned value
        lbluehouse=currentblue
        lgreenhouse=currentgreen
    return min(min(lgreenhouse,lbluehouse),lredhouse) #finding the minimum of the last row


if __name__ == '__main__':
    matrix=[[17,2,17],[16,16,5],[14,3,19]]
    val=painthouse(matrix)
    print(val)
