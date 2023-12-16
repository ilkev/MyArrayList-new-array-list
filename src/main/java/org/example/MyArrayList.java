package org.example;

import java.util.Arrays;

public class MyArrayList<T> {
    private final T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    //новый ArrayList с выбранным размером
    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер меньше, либо равен нулю!");
        } else {
            list = (T[]) new Object[capacity];
        }
    }

    //новый ArrayList стандартного размера
    public MyArrayList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    //добавить элемент в конец
    public void add(T item) {
        list[size++] = item;
    }

    //добавить элемент по индексу(в нужное место)
    public void add(int index, T item) {
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    //заменить элемент по индексу
    public void set(int index, T item) {
        list[index] = item;
    }

    //удалить элемент
    public void remove(T item) {
        int pos = index(item);
        if (pos < 0) {
            return;
        }
        remove(pos);
    }

    //удалить элемент по индексу
    public void remove(int index) {
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }

    //Проверка на существование элемента
    public boolean contains(T item) {
        for (T t : list) {
            if (t == item) {
                return true;
            }
        }
        return false;
    }

    //индекс элемента
    public int index(T item) {
        if (item == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    //индекс элемента с конца
    public int lastIndex(T item) {
        if (item == null) {
            return -1;
        }
        for (int i = size; i > 0; i--) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    //достать элемент по индексу
    public T get(int index) {
        return list[index];
    }

    //количество элементов в ArrayList
    public int size() {
        int count = 0;
        for (T t : list) {
            if (t != null) {
                count++;
            }
        }
        return count;
    }

    //очистить ArrayList
    public void clear() {
        Arrays.fill(list, null);
        size = 0;
    }

    public boolean isEmpty() {
        for (T t : list) {
            if (t != null) {
                return false;
            }
        }
        return true;
    }

    //Сравнение двух списков
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArrayList<T> that = (MyArrayList<T>) o;

        if (size != that.size) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(list);
        result = 31 * result + size;
        return result;
    }

    //отобразить ArrayList
    public void display() {
        for (T item : list) {
            System.out.println(item + " ");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }
}