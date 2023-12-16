import org.example.MyArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MyArrayListTest {
    MyArrayList<Integer> arrayList = new MyArrayList<>();

    @Test
    void add() {
        arrayList.add(1);
        Assertions.assertEquals(1, arrayList.get(0));
    }

    @Test
    void addByIndex() {
        arrayList.add(0, 1);
        Assertions.assertEquals(1, arrayList.get(0));
    }

    @Test
    void set() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.set(1, 3);
        Assertions.assertEquals(3, arrayList.get(1));
    }

    @Test
    void remove() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.remove((Integer) 1);
        MyArrayList<Integer> arrayList1 = new MyArrayList<>();
        arrayList1.add(2);
        arrayList1.add(3);
        Assertions.assertEquals(arrayList1.get(0), arrayList.get(0));
        Assertions.assertEquals(arrayList1.get(1), arrayList.get(1));
        Assertions.assertEquals(arrayList1.size(), arrayList.size());
    }

    @Test
    void removeByIndex() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.remove(0);
        MyArrayList<Integer> arrayList1 = new MyArrayList<>();
        arrayList1.add(2);
        arrayList1.add(3);
        Assertions.assertEquals(arrayList1.get(0), arrayList.get(0));
        Assertions.assertEquals(arrayList1.get(1), arrayList.get(1));
        Assertions.assertEquals(arrayList1.size(), arrayList.size());
    }

    @Test
    void contains() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        boolean actual = arrayList.contains(4);
        Assertions.assertFalse(actual);
    }

    @Test
    void index() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Integer actual = arrayList.index(2);
        Assertions.assertEquals(1, actual);
    }

    @Test
    void lastIndex() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Integer actual = arrayList.lastIndex(2);
        Assertions.assertEquals(1, actual);
    }

    @Test
    void get() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Integer actual = arrayList.get(1);
        Assertions.assertEquals(2, actual);
    }

    @Test
    void isEquals(){
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        MyArrayList<Integer> arrayList1 = new MyArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        Assertions.assertEquals(arrayList1, arrayList);
    }

    @Test
    void size(){
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        int actual = arrayList.size();
        Assertions.assertEquals(3, actual);
    }

    @Test
    void isEmpty(){
        boolean actual = arrayList.isEmpty();
        Assertions.assertTrue(actual);
    }

    @Test
    void clear(){
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.clear();
        MyArrayList<Integer> arrayList1 = new MyArrayList<>();
        Assertions.assertEquals(arrayList1, arrayList);
    }
}