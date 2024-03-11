import java.util.*;

public class KMostFrequent{

    public static List<Integer> kmost(int[] nums, int k) {
        Map<Integer, Integer> Map = new HashMap<>();
        for (int num : nums) {
            if (Map.containsKey(num)) {
                Map.put(num, Map.get(num) + 1);
            } else {
                Map.put(num, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                if (a.getValue().equals(b.getValue())) {
                    return Integer.compare(b.getKey(), a.getKey());
                }
                return Integer.compare(a.getValue(), b.getValue());
            }
        });

        for (Map.Entry<Integer, Integer> entry : Map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length : ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements :");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        List<Integer> result = kmost(nums, k);
        System.out.println(result);
    }
}
