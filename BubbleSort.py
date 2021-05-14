def bubbleSort(arr):
    n = len(arr)
  
    # Traverse through all array elements
    for i in range(n-1):

        for j in range(0, n-i-1):
  
            # traverse the array from 0 to n-i-1
            # Swap if the element found is greater
            # then the next element
            if arr[j] > arr[j+1] :
                arr[j], arr[j+1] = arr[j+1], arr[j]
  
# Driver & Array
arr = [34, 56, 4, 10, 77, 51, 93, 30, 5, 52]
print ("Unorted array is:")
for i in range(len(arr)):
    print(arr[i], sep=' ', end=' ', flush=True)
    # print ("%d" %arr[i]), 
  
bubbleSort(arr)
  
print("\n")
print ("Sorted array is:")
for i in range(len(arr)):
    print(arr[i], sep=' ', end=' ', flush=True)
    # print ("%d" %arr[i]), 