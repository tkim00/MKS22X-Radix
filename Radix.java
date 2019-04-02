import java.lang.*;

public class Radix {
  @SuppressWarnings("unchecked")
  public static void radixsort(int[]data){
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    int max = 0;
    for (int i = 0; i < data.length; i++) {
      if (Math.abs(data[i]) > max) max = Math.abs(data[i]);
    }
    int maxDigit = 0;
    while (max != 0) {
      max = max/10;
      maxDigit++;
    }
    for (int i = 0; i < maxDigit; i++) {

    }
  }
}
