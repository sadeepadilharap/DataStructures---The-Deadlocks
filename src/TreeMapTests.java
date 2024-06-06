import java.util.TreeMap;

public class TreeMapTests {
    public TreeMap<Integer, Integer> map;

    public TreeMapTests() {
        this.map = new TreeMap<>();
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public void initiateTests(int[] testCasesAdd, int[] testCasesCheckAvailable, int[] testCasesRemove) {
        // checking time to add a given element
        long addTime = testPut(testCasesAdd);
        System.out.println("TreeMap put time: " + addTime);

        // checking time to check if a key is available
        long checkAvailableTime = testContainsKey(testCasesCheckAvailable);
        System.out.println("TreeMap check available value time: " + checkAvailableTime);

        // checking time to remove a given key
        long removeTime = testRemove(testCasesRemove);
        System.err.println("TreeMap remove time: " + removeTime);

        // checking time to clear the map
        long clearTime = testClear();
        System.out.println("TreeMap clear time: " + clearTime);
    }

    private long testPut(int[] testCases) {
        long elapsedTime = 0;
        int key = 0;
        for (int num : testCases) {
            TreeMap<Integer, Integer> copyMap = new TreeMap<>(map);
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
            TreeMap<Integer, Integer> copyMap = new TreeMap<>(map);
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
            TreeMap<Integer, Integer> copyMap = new TreeMap<>(map);
            long start = System.nanoTime();
            copyMap.clear();
            long end = System.nanoTime();
            elapsedTime += end - start;
        }
        return elapsedTime / 100;
    }
}
