package ru.skypro;

import java.util.Objects;

public class IntegerListImpl implements IntegerList {

    private static final int initialLength = 15;

    private int capacity;

    private final Integer[] arr;

    public IntegerListImpl() {
        arr = new Integer[initialLength];
        capacity = 0;
    }

    public IntegerListImpl(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The list's size has to be positive!");
        }
        arr = new Integer[length];
        capacity = 0;
    }

    @Override
    public Integer add(Integer item) {
        if (capacity >= arr.length) {
            throw new IllegalArgumentException("The list is full!");
        }
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not add 'Null' into the list!");
        }
        return arr[capacity++] = item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (capacity >= arr.length) {
            throw new IllegalArgumentException("The list is full!");
        }
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not add 'Null' into the list!");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index has to be positive!");
        }
        if (index > capacity) {
            throw new IllegalArgumentException("Index: " + index + ", Size: " + capacity);
        }
        for (int i = capacity; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        capacity++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not have 'Null' in the list!");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index has to be positive!");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Index: " + index + ", Size: " + capacity);
        }
        return arr[index] = item;
    }

    @Override
    public Integer remove(Integer item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not have 'Null' in the list!");
        }
        int removable = -1;
        for (int i = 0; i < capacity; i++) {
            if (arr[i].equals(item)) {
                removable = i;
                break;
            }
        }
        if (removable == -1) {
            throw new IllegalArgumentException("Element not found!");
        }
        return remove(removable);
    }

    @Override
    public Integer remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index has to be positive!");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Index: " + index + ", Size: " + capacity);
        }
        Integer removedItem = arr[index];
        for (int i = index; i < capacity - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--capacity] = null;
        return removedItem;
    }

    @Override
    public boolean contains(Integer item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not have 'Null' in the list!");
        }
        sort();
        int min = 0;
        int max = capacity - 1;
        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(arr[mid])) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not have 'Null' in the list!");
        }
        int index = -1;
        for (int i = 0; i < capacity; i++) {
            if (arr[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Integer item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("You can not have 'Null' in the list!");
        }
        int index = -1;
        for (int i = capacity - 1; i >= 0; i--) {
            if (arr[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Integer get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index has to be positive!");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Index: " + index + ", Size: " + capacity);
        }
        return arr[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!arr[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        capacity = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private void sort() {
        for (int i = 1; i < capacity; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

}
