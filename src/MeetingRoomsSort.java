import java.util.*;

public class MeetingRoomsSort {
    public static boolean canAttendAllMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of intervals: ");
        int n = scanner.nextInt();

        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter start time for interval " + (i + 1) + ": ");
            intervals[i][0] = scanner.nextInt();

            System.out.print("Enter end time for interval " + (i + 1) + ": ");
            intervals[i][1] = scanner.nextInt();
        }

        boolean result = canAttendAllMeetings(intervals);

        System.out.println(result);
    }
}
