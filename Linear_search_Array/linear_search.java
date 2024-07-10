package Linear_search_Array;

public class linear_search {
    //Best case: O(1)
    //Worst Case: O(n)
    //Average Case: O(n) 
    public static int linearsearch(int[] arr,int target)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==target)
            {
                return i;
            }
        }
        return -1;
        
    }
    public static void main(String args[])
    {
        int arr[] = {2,4,0,1,8,9,7,5};
        int target = 6;
        int result = linearsearch(arr,target);
        if(result!=-1)
        {
            System.out.println("The position in which the particular element is in is "+result);
        }
        else
        {
            System.out.println("The element is not found in the array");
        }
    }
}

