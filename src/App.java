import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedListTests list1 = new LinkedListTests();
        HashSetTests set1 = new HashSetTests();
        TreeSetTests tree1 = new TreeSetTests();
        LinkedHashSetTests linkedSet1 = new LinkedHashSetTests();
        ArrayListTests arrlist1 = new ArrayListTests();
        ArrayDequeTests arrdeque1 = new ArrayDequeTests();
        PriorityQueueTests pq1 = new PriorityQueueTests();
        HashMapTests map1 = new HashMapTests();
        TreeMapTests treeMap1 = new TreeMapTests();
        LinkedHashMapTests linkedMap1 = new LinkedHashMapTests();

        for (int i = 0; i < 100000; i++) {
            int num = new Random().nextInt(100000);
            arrlist1.add(num);
            arrdeque1.add(num);
            set1.add(num);
            list1.add(num);
            tree1.add(num);
            linkedSet1.add(num);
            pq1.add(num);
            map1.put(num, i);
            treeMap1.put(i, num);
            linkedMap1.put(i, num);
        }
        // generate test case arrays
        int[] numAdd = new int[100];
        int[] numAvailable = new int[100];
        int[] numRemove = new int[100];
        for (int i = 0; i < 100; i++) {
            numAdd[i] = new Random().nextInt(100000);
            numAvailable[i] = new Random().nextInt(100000);
            numRemove[i] = new Random().nextInt(100000);
        }

        list1.initiateTests(numAdd, numAvailable, numRemove);
        set1.initiateTests(numAdd, numAvailable, numRemove);
        tree1.initiateTests(numAdd, numAvailable, numRemove);
        linkedSet1.initiateTests(numAdd, numAvailable, numRemove);
        arrlist1.initiateTests(numAdd, numAvailable, numRemove);
        arrdeque1.initiateTests(numAdd, numAvailable, numRemove);
        pq1.initiateTests(numAdd, numAvailable, numRemove);
        map1.initiateTests(numAdd, numAvailable, numRemove);
        treeMap1.initiateTests(numAdd, numAvailable, numRemove);
        linkedMap1.initiateTests(numAdd, numAvailable, numRemove);

    }
}
