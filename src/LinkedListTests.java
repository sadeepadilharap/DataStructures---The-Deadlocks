import java.util.LinkedList;

public class LinkedListTests {
    public LinkedList<Integer> list;

    public LinkedListTests() {
        this.list = new LinkedList<>();
    }

    public void add(int num) {
        list.add(num);
    }

    public void initiateTests(int[] testCasesAdd, int[] testCasesCheckAvailable, int[] testCasesRemove) {
        // checking time to add a given element
        long addTime = testAdd(testCasesAdd);
        System.out.println("LinkedList add time: " + addTime);

        // checking time to check if an element is available
        long checkAvailableTime = testCheckAvailable(testCasesCheckAvailable);
        System.out.println("LinkedList check available time: " + checkAvailableTime);

        // checking time to remove a given element
        long removeTime = testRemove(testCasesRemove);
        System.err.println("LinkedList remove time: " + removeTime);

        // checking time to clear the list
        long clearTime = testClear();
        System.out.println("LinkedList clear time: " + clearTime);
    }

    private long testAdd(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            LinkedList<Integer> copyList = new LinkedList<>(list);
            long start = System.nanoTime();
            copyList.add(num);
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return (elapsedTime / testCases.length);
    }

    private long testCheckAvailable(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            long start = System.nanoTime();
            list.contains(num);
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return (elapsedTime / testCases.length);
    }

    private long testRemove(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            LinkedList<Integer> copyList = new LinkedList<>(list);
            long start = System.nanoTime();
            copyList.remove(Integer.valueOf(num));
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return (elapsedTime / testCases.length);
    }

    private long testClear() {
        long elapsedTime = 0;
        for (int i = 0; i < 100; i++) {
            LinkedList<Integer> copyList = new LinkedList<>(list);
            long start = System.nanoTime();
            copyList.clear();
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return (elapsedTime / 100);
    }
}
