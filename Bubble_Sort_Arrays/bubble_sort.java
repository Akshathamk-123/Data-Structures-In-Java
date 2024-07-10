package Bubble_Sort_Arrays;

public class bubble_sort {
    public static int[] bubblesort(int[] arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=0;j<arr.length-1-i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
    public static void main(String args[])
    {
        int arr[] = {2,4,0,1,8,9,7,5};
        int sorted_array[] = bubblesort(arr);
        for(int element: sorted_array)
        {
            System.out.print(element + "\t" );
        }
    }
}
