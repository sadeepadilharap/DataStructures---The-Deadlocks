import java.util.LinkedHashMap;

public class LinkedHashMapTests {
    public LinkedHashMap<Integer, Integer> map;

    public LinkedHashMapTests() {
        this.map = new LinkedHashMap<>();
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public void initiateTests(int[] testCasesAdd, int[] testCasesCheckAvailable, int[] testCasesRemove) {
        // checking time to add a given element
        long addTime = testPut(testCasesAdd);
        System.out.println("LinkedHashMap put time: " + addTime);

        // checking time to check if a key is available
        long checkAvailableTime = testContainsKey(testCasesCheckAvailable);
        System.out.println("LinkedHashMap check available value time: " + checkAvailableTime);

        // checking time to remove a given key
        long removeTime = testRemove(testCasesRemove);
        System.err.println("LinkedHashMap remove time: " + removeTime);

        // checking time to clear the map
        long clearTime = testClear();
        System.out.println("LinkedHashMap clear time: " + clearTime);
    }

    private long testPut(int[] testCases) {
        long elapsedTime = 0;
        int key = 0;
        for (int num : testCases) {
            LinkedHashMap<Integer, Integer> copyMap = new LinkedHashMap<>(map);
            long start = System.nanoTime();
            copyMap.put(key++, num);
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / testCases.length;
    }

    private long testContainsKey(int[] testCases) {
        long elapsedTime = 0;
        for (int num : testCases) {
            long start = System.nanoTime();
            map.containsValue(num);
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / testCases.length;
    }

    private long testRemove(int[] testCases) {
        long elapsedTime = 0;
        for (int value : testCases) {
            LinkedHashMap<Integer, Integer> copyMap = new LinkedHashMap<>(map);
            long start = System.nanoTime();
            copyMap.entrySet().removeIf(entry -> entry.getValue() == value);
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / testCases.length;
    }

    private long testClear() {
        long elapsedTime = 0;
        for (int i = 0; i < 100; i++) {
            LinkedHashMap<Integer, Integer> copyMap = new LinkedHashMap<>(map);
            long start = System.nanoTime();
            copyMap.clear();
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / 100;
    }
}
