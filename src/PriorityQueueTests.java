import java.util.PriorityQueue;

public class PriorityQueueTests {
    public PriorityQueue<Integer> queue;

    public PriorityQueueTests() {
        this.queue = new PriorityQueue<>();
    }

    public void add(int num) {
        queue.add(num);
    }

    public void initiateTests(int[] testCasesAdd, int[] testCasesCheckAvailable, int[] testCasesRemove) {
        // checking time to add a given element
        long addTime = testAdd(testCasesAdd);
        System.out.println("PriorityQueue add time: " + addTime);

        // checking time to check if an element is available
        long checkAvailableTime = testCheckAvailable(testCasesCheckAvailable);
        System.out.println("PriorityQueue check available time: " + checkAvailableTime);

        // checking time to remove a given element
        long removeTime = testRemove(testCasesRemove);
        System.err.println("PriorityQueue remove time: " + removeTime);

        // checking time to clear the queue
        long clearTime = testClear();
        System.out.println("PriorityQueue clear time: " + clearTime);
    }

    private long testAdd(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            PriorityQueue<Integer> copyQueue = new PriorityQueue<>(queue);
            long start = System.nanoTime();
            copyQueue.add(num);
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / testCases.length;
    }

    private long testCheckAvailable(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            long start = System.nanoTime();
            queue.contains(num);
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / testCases.length;
    }

    private long testRemove(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            PriorityQueue<Integer> copyQueue = new PriorityQueue<>(queue);
            long start = System.nanoTime();
            copyQueue.remove(num);
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / testCases.length;
    }

    private long testClear() {
        long elapsedTime = 0;
        for (int i = 0; i < 100; i++) {
            PriorityQueue<Integer> copyQueue = new PriorityQueue<>(queue);
            long start = System.nanoTime();
            copyQueue.clear();
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / 100;
    }
}
