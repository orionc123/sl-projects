import java.util.*;

public class Driver {
    // generates an array of random 32-bit integers of size length
    public static int[] generateList(int length) {
        int[] list = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            list[i] = random.nextInt();
            System.out.println(list[i]);
        }
        return list;
    }

    public static List<Integer> getLongestISequence(int[] arr) {
        // declarations
        List<Integer> lis = new ArrayList<>();
        int[] tab = new int[arr.length];
        int[] trails = new int[arr.length];
        int maxIndex = 1;
        // populate the tab and trails array
        for (int i = 0; i < arr.length; i++) {
            tab[i] = 1;
            trails[i] = -1;
        }
        // bottom up, dynamically store lengths of subsequences in the tab array
        // trails array is used for retrieving values of the longest subsequence
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && tab[i] < tab[j] + 1) {
                    tab[i] = tab[j] + 1;
                    trails[i] = j;
                }
            }
        }
        // find index of final element of the longest subsequence
        for (int j = 0; j < tab.length; j++) {
            if (tab[j] > tab[maxIndex]) {
                maxIndex = j;
            }
        }
        // use trails array to retrieve values of longest subsequence and add to lis
        int trailIndex = maxIndex;
        while (trails[trailIndex] != -1) {
            lis.add(arr[trailIndex]);
            trailIndex = trails[trailIndex];
        }
        // add first element of longest subsequence
        lis.add(arr[trailIndex]);
        return lis;
    }

    public static void main(String[] args) {
        int[] initial = generateList(100);
        List<Integer> result = getLongestISequence(initial);
        Collections.sort(result);
        System.out.println(result);
    }
}