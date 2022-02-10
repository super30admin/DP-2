
def houseColoring():
    arr = [[17,2,11],[16,5,20],[14,13,19]]
    for i in reversed(range(len(arr)-1)):
        print(i)
        arr[i][0] = arr[i][0] + min(arr[i+1][1],arr[i+1][2])
        arr[i][1] = arr[i][1] + min(arr[i+1][0],arr[i+1][2])
        arr[i][2] = arr[i][0] + min(arr[i+1][1],arr[i+1][0])


    print(min(arr[0][1],min(arr[0][0],arr[0][2])))    
    print(arr)


houseColoring()