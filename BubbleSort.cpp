// C++ program to perform a bubble sort

#include <stdio.h>
#include <iostream>
using namespace std;

//Bubble sort
void bubbleSort(int array[], int arraylength)
{
    for(int i = 0; i < arraylength-1; i++)
    {
        for(int j = i+1; j < arraylength; j++)
        { 
            if(array[i] > array[j])
            {
                //Swap the elements
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
}

//Print the array
void printarray(int array[], int size){
    for (int i = 0; i < size; i++)
        cout << array[i];
    cout <<"\n";
}

//driver
int main(){
    int array[] = {34, 56, 4, 10, 77, 51, 93, 30, 5, 52}, arraylength = (sizeof(array) / sizeof(array[0]));
    cout << "Original array: \n";
    printarray(array, arraylength);

    bubbleSort(array, arraylength);
    cout << "\nSorted array in Ascending order: \n";
    printarray(array, arraylength);

    // cout << "\nArray size:\n" << arraylength;
    
    return 0;
}