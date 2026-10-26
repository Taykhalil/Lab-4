import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      System.out.println("\n\nBubble sort results ----------------------------------------------");
      long bubbleStart = System.nanoTime();
      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
      long bubbleEnd = System.nanoTime();
      Lab4.outputList(bubbleSortedList);
      System.out.printf("%n%nBubble sort time: %.3f ms%n", (bubbleEnd - bubbleStart) / 1_000_000.0);

      System.out.println("\n\nInsertion sort results -------------------------------------------");
      long insertionStart = System.nanoTime();
      ArrayList<Integer> insertionSortedList = Lab4.insertionSort(integerList);
      long insertionEnd = System.nanoTime();
      Lab4.outputList(insertionSortedList);
      System.out.printf("%n%nInsertion sort time: %.3f ms%n", (insertionEnd - insertionStart) / 1_000_000.0);
    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    ArrayList<Integer> sorted = new ArrayList<>(integerList);
    for (int i = 1; i < sorted.size(); i++) {
      int key = sorted.get(i);
      int j = i - 1;
      while (j >= 0 && sorted.get(j) > key) {
        sorted.set(j + 1, sorted.get(j));
        j--;
      }
      sorted.set(j + 1, key);
    }
    return sorted;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    ArrayList<Integer> sorted = new ArrayList<>(integerList);
    int n = sorted.size();
    for (int i = 0; i < n - 1; i++) {
      boolean swapped = false;
      for (int j = 0; j < n - 1 - i; j++) {
        if (sorted.get(j) > sorted.get(j + 1)) {
          int temp = sorted.get(j);
          sorted.set(j, sorted.get(j + 1));
          sorted.set(j + 1, temp);
          swapped = true;
        }
      }
      if (!swapped) {
        break;
      }
    }
    return sorted;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}

