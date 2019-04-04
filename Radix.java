import java.lang.*;

public class Radix {
  @SuppressWarnings("unchecked")
  public static void radixsort(int[]data){
    MyLinkedList<Integer>[] buckets = (MyLinkedList<Integer>[])new Object[20];
    // try to replace this with new MyLinkedList[20] later
    int max = 0;
    for (int i = 0; i < data.length; i++) {
      if (Math.abs(data[i]) > max) max = Math.abs(data[i]);
    } //finds out the number with the greatest amount of digits
    int maxDigit = 0;
    while (max != 0) { //finds the maximum digits within the array
      max = max/10;
      maxDigit++;
    }
    for (int i = 0; i < maxDigit; i++) {
      for (int j = 0; j < data.length; j++) {
        int digit = (data[j] / (int)Math.pow(10, i)) % 10;
        if (data[j] < 0) {

        }
      }
    }
  }
}
