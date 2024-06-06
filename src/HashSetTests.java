import java.util.HashSet;

public class HashSetTests {
    public HashSet<Integer> set;

    public HashSetTests() {
        this.set = new HashSet<>();
    }

    public void add(int num) {
        set.add(num);
    }

    public void initiateTests(int[] testCasesAdd, int[] testCasesCheckAvailable, int[] testCasesRemove) {
        // checking time to add a given element
        long addTimeHS = testAdd(testCasesAdd);
        System.out.println("HashSet add time: " + addTimeHS);

        // checking time to check if an element is available
        long checkAvailableTimeHS = testCheckAvailable(testCasesCheckAvailable);
        System.out.println("HashSet check available time: " + checkAvailableTimeHS);

        // checking time to remove a given element
        long removeTimeHS = testRemove(testCasesRemove);
        System.err.println("HashSet remove time: " + removeTimeHS);

        // checking time to clear the set
        long clearTimeHS = testClear();
        System.out.println("HashSet clear time: " + clearTimeHS);
    }

    private long testAdd(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            HashSet<Integer> copySet = new HashSet<>(set);
            long start = System.nanoTime();
            copySet.add(num);
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / testCases.length;
    }

    private long testCheckAvailable(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            long start = System.nanoTime();
            set.contains(num);
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / testCases.length;
    }

    private long testRemove(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            HashSet<Integer> copySet = new HashSet<>(set);
            long start = System.nanoTime();
            copySet.remove(num);
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / testCases.length;
    }

    private long testClear() {
        long elapsedTime = 0;
        for (int i = 0; i < 100; i++) {
            HashSet<Integer> copySet = new HashSet<>(set);
            long start = System.nanoTime();
            copySet.clear();
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / 100;
    }
}
