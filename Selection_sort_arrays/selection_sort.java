package Selection_sort_arrays;

public class selection_sort {
    public static int[] selectionsort(int[] arr)
    {
        
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i;j<arr.length;j++)
            {
                if(arr[i]>arr[j])
                {
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,0,1,8,9,7,5};
        int sorted_array[] = selectionsort(arr);
        for(int element: sorted_array)
        {
            System.out.print(element + "\t" );
        }
    }
}
