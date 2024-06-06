import java.util.ArrayList;

public class ArrayListTests {
    public ArrayList<Integer> list;

    public ArrayListTests() {
        this.list = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
    }

    public void initiateTests(int[] testCasesAdd, int[] testCasesCheckAvailable, int[] testCasesRemove) {
        // checking time to add a given element
        long addTimeAL = testAdd(testCasesAdd);
        System.out.println("ArrayList add time: " + addTimeAL);

        // checking time to check if an element is available
        long checkAvailableTimeAL = testCheckAvailable(testCasesCheckAvailable);
        System.out.println("ArrayList check available time: " + checkAvailableTimeAL);

        // checking time to remove a given element
        long removeTimeAL = testRemove(testCasesRemove);
        System.err.println("ArrayList remove time: " + removeTimeAL);

        // checking time to clear the list
        long clearTimeAL = testClear();
        System.out.println("ArrayList clear time: " + clearTimeAL);
    }

    private long testAdd(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            ArrayList<Integer> copyList = new ArrayList<Integer>(list);
            long start = System.nanoTime();
            copyList.add(num);
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / testCases.length;
    }

    private long testCheckAvailable(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            long start = System.nanoTime();
            list.contains(num);
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / testCases.length;
    }

    private long testRemove(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            ArrayList<Integer> copyList = new ArrayList<>(list);
            long start = System.nanoTime();
            copyList.remove(Integer.valueOf(num));
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / testCases.length;
    }

    private long testClear() {
        long elapsedTime = 0;
        for (int i = 0; i < 100; i++) {
            ArrayList<Integer> copyList = new ArrayList<>(list);
            long start = System.nanoTime();
            copyList.clear();
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / 100;
    }
}
