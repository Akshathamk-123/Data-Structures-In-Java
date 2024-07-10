package Binary_Search_Arrays;

public class binary_search {
    public static int[] sorting(int[] arr)
    { // Linear Sort
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]<arr[i])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    public static int binarysearch(int[] arr,int target)
    {

        int low = 0;
        int upper = arr.length -1;
        int mid=-1;
        boolean flag = false;
        while(low<=upper)
        {
            mid = low + ((upper-low)/2);
            if(arr[mid] == target)
            {
                flag = true;
                return mid;
            }
            if(arr[mid]<target)
            {
                low = mid+1;
            }
            if(arr[mid]>target)
            {
                upper = mid -1;
            }
        }
        if(flag == true){
        return mid;}
        else{return -1;}
    }
    public static void main(String args[])
    {
        int arr[] = {2,4,0,1,8,9,7,5};
        int target = 6;
        int sorted[] = sorting(arr); 
        int result = binarysearch(sorted,target);
        for(int elem:sorted)
        {
            System.out.print(elem+"\t");
        }

        if(result!=-1)
        {
            System.out.println("The position of the element is "+result);
        }
        else
        {
            
            System.out.println("The element doesn't exist in the array");
        }
    }
}
