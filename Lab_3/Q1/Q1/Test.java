package Q1;

/**
 * Created by KanzakiMirai on 1/12/16.
 */

/**
 * A test class for Q1
 *
 * @author Diqi Zeng
 */
public class Test {
    static DlinkDeque<Integer> dlinkDeque = new DlinkDeque<>();

    public static void main(String[] args) {
        Test1();
    }

    static void Test1() {
        System.out.println("  Operation   | Output  |  Deque");
        addFirst(3);//1
        addFirst(5);//2
        removeFirst();//3
        addFirst(1);//4
        addFirst(2);//5
        addFirst(7);//6
        addFirst(9);//7
        removeFirst();//8
        getFirst();//9
        getLast();//10
        addLast(6);//11
        addLast(4);//12
        addLast(8);//13
        getLast();//14
        removeFirst();//15
        removeLast();//16
        addLast(0);//17
        removeFirst();//18
        isEmpty();//19
        size();//20
    }

    public static int size() {
        int returnVal = dlinkDeque.size();
        System.out.println(String.format("size()        |    %s    |%s", returnVal, dlinkDeque));
        return returnVal;
    }

    public static boolean isEmpty() {
        boolean returnVal = dlinkDeque.isEmpty();
        System.out.println(String.format("isEmpty()     |  %s  |%s", returnVal, dlinkDeque));
        return returnVal;
    }

    public static Integer getFirst() throws EmptyDequeException {
        Integer returnVal = dlinkDeque.getFirst();
        System.out.println(String.format("getFirst()    |    %s    |%s", returnVal, dlinkDeque));
        return returnVal;
    }

    public static Integer getLast() throws EmptyDequeException {
        Integer returnVal = dlinkDeque.getLast();
        System.out.println(String.format("getLast()     |    %s    |%s", returnVal, dlinkDeque));
        return returnVal;
    }

    public static void addFirst(Integer element) {
        dlinkDeque.addFirst(element);
        System.out.println(String.format("addFirst(%s)   |    -    |%s", element, dlinkDeque));
    }

    public static void addLast(Integer element) {
        dlinkDeque.addLast(element);
        System.out.println(String.format("addLast(%s)    |    -    |%s", element, dlinkDeque));
    }

    public static Integer removeFirst() throws EmptyDequeException {
        Integer returnVal = dlinkDeque.removeFirst();
        System.out.println(String.format("removeFirst() |    %s    |%s", returnVal, dlinkDeque));
        return returnVal;
    }

    public static Integer removeLast() throws EmptyDequeException {
        Integer returnVal = dlinkDeque.removeLast();
        System.out.println(String.format("removeLast()  |    %s    |%s", returnVal, dlinkDeque));
        return returnVal;
    }
}
