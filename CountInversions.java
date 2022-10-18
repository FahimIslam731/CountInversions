import java.util.*;
class CountInversions {
  public static void main(String[] args) {
    CountInversions m = new CountInversions();
    m.run();
  }

  public void run(){
    Scanner input = new Scanner(System.in);
    boolean isNotDigit = true;
    int[] arr;
    int count = 0;
    int size = 0;
    
    while(isNotDigit){
      System.out.print("Please enter the size of the array: ");
      String s = input.next();
      System.out.println();
      try{
        size = Integer.parseInt(s);
        isNotDigit = false;
      } catch(NumberFormatException nfe){
        System.out.println("Please enter a valid integer.");
      }
    }
    
    arr = new int[size];

    
    while(count < size){
      System.out.print("Please enter the element at index " + count + ": ");
      String s = input.next();
      System.out.println();
      try{
        arr[count] = Integer.parseInt(s);
        count++;
      } catch(NumberFormatException nfe){
        System.out.println("Please enter a valid integer.");
      }
    }

    
    System.out.println("Before:");
    printArr(arr);
    int inversions = countInversions(arr);
    System.out.println("After:");
    printArr(arr);
    System.out.println("Inversions: " + inversions);
  }

  public int countInversions(int[] arr) {
    return mergeSort(arr, 0, arr.length - 1);
  }

  public int mergeSort(int[] arr, int start, int end){ 
    int mid = (start + end)/2;
    if(start < end){
      return mergeSort(arr, start, mid) + mergeSort(arr, mid + 1, end) + merge(arr, start, mid, end);
    }
    return 0;
  }

  private int merge(int[] arr, int start, int mid, int end){
    int[] store = new int[(end - start) + 1];
    int i = start, j = mid + 1, k = 0, count = 0;
    
    while(i <= mid && j <= end){
      if(arr[i] > arr[j]){
        store[k] = arr[j];
        j++;
        count+=((mid-i) + 1);
      } else {
        store[k] = arr[i];
        i++;
      }
      k++;
    }

    while(i <= mid){
      store[k] = arr[i];
      i++;
      k++;
    }
    while(j <= end){
      store[k] = arr[j];
      j++;
      k++;
    }

    for(int index = 0; index < store.length; index++){
      arr[index+start] = store[index];
    }

    return count;
  }

  private void printArr(int[] arr){
    String str = "[";
    
    for(int i = 0; i < arr.length; i++){
      str += arr[i] + ", ";
    }
    
    if(str.length() > 1){
      str = str.substring(0, str.length()-2);
    }
    str += "]";
    
    System.out.println(str + "\n");
  }
}