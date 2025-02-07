import java.util.LinkedList;
import java.util.Queue;

public class Sort_Queue {
  private static void sortQueue(Queue<Integer> queue) {
    int n = queue.size();
    for (int i = 0; i < n; i++) { // First loop 
      int minIndex = -1;
      int minValue = Integer.MAX_VALUE;

      for (int j = 0; j < n; j++) { // Finding min value 1 2 3 ....
        int currValue = queue.poll();
        if (currValue < minValue && j < (n - i)) {
          minValue = currValue;
          minIndex = j;
        }
        queue.add(currValue);
      }

      // Remove min value from queue
      for (int j = 0; j < n; j++) { // Adding min value 1 2 3 ... at the end 
        int currValue = queue.poll();
        if (j != minIndex) {
          queue.add(currValue);
        }
      }
      // Add min value to the end of the queue
      queue.add(minValue);
    }
    // Print the sorted queue
    for (int i : queue) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Queue<Integer> q1 = new LinkedList<>();
    q1.add(5);
    q1.add(4);
    q1.add(3);
    q1.add(2);
    q1.add(1);
    sortQueue(q1);
  }
}


