import java.util.TreeSet;

public class TreeSetTests {
    public TreeSet<Integer> set;

    public TreeSetTests() {
        this.set = new TreeSet<>();
    }

    public void add(int num) {
        set.add(num);
    }

    public void initiateTests(int[] testCasesAdd, int[] testCasesCheckAvailable, int[] testCasesRemove) {
        // checking time to add a given element
        long addTime = testAdd(testCasesAdd);
        System.out.println("TreeSet add time: " + addTime);

        // checking time to check if an element is available
        long checkAvailableTime = testCheckAvailable(testCasesCheckAvailable);
        System.out.println("TreeSet check available time: " + checkAvailableTime);

        // checking time to remove a given element
        long removeTime = testRemove(testCasesRemove);
        System.err.println("TreeSet remove time: " + removeTime);

        // checking time to clear the set
        long clearTime = testClear();
        System.out.println("TreeSet clear time: " + clearTime);
    }

    private long testAdd(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            TreeSet<Integer> copySet = new TreeSet<>(set);
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
            TreeSet<Integer> copySet = new TreeSet<>(set);
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
            TreeSet<Integer> copySet = new TreeSet<>(set);
            long start = System.nanoTime();
            copySet.clear();
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / 100;
    }
}