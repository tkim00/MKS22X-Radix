import java.lang.*;

public class Radix {
  @SuppressWarnings("unchecked")
  public static void radixsort(int[]data){
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new MyLinkedList();
    }
    // try to replace this with new MyLinkedList[20] later
    MyLinkedList<Integer> temp = new MyLinkedList();
    int max = 0;
    for (int i = 0; i < data.length; i++) {
      if (Math.abs(data[i]) > max) max = Math.abs(data[i]);
    } //finds out the number with the greatest amount of digits
    int maxDigit = 0;
    while (max != 0) { //finds the maximum digits within the array
      max = max/10;
      maxDigit++;
    }
    for (int i = 0; i < data.length; i++) { //put the data into the buckets
      int digit = Math.abs(data[i]) % 10; //finds the first digit
      if (data[i] < 0) { //negative numbers get put into the first 10 buckets
        buckets[9-digit].add(data[i]); //sort the numbers in reverse since these are negative numbers
      } else { //positive numbers get put into the last 10 buckets
        buckets[10+digit].add(data[i]);
      }
    }
    for (int i = 0; i < buckets.length; i++) { //merge the elements from the buckets into the temp list
      if (buckets[i].size() > 0) {
        temp.extend(buckets[i]);
      }
    }
    for (int i = 1; i < maxDigit; i++) { //loops between buckets and temp
      while (temp.size() > 0) { //starts from the second least significan digit
        int num = temp.removeFront();
        int digit = (Math.abs(num) / (int)Math.pow(10, i)) % 10;
        if (num < 0) { //negative numbers get put into the first 10 buckets
          buckets[9-digit].add(num); //sort the numbers in reverse since these are negative numbers
        } else { //positive numbers get put into the last 10 buckets
          buckets[10+digit].add(num);
        }
      }
      for (int j = 0; j < buckets.length; j++) { //merge
        if (buckets[j].size() > 0) {
          temp.extend(buckets[j]);
        }
      }
    }
    for (int i = 0; i < data.length; i++) { //when the linked list is sorted, put them back into the data
      int num = temp.removeFront();
      data[i] = num;
    }
  }
}
