public class MyMinHeap<T extends Comparable<T>> implements MyList<T> {
    private final MyArrayList<T> list = new MyArrayList<>();

    @Override
    public void add(T item) {
        list.add(item);
        heapifyUp(list.size() - 1);
    }
  //Here if we will wwant to add new element, we must save struc
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && list.get(index).compareTo(list.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }
    //Here we just swap elemenrs
    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
  
    //This metohd substitide element by index depending on case
    @Override
    public void set(int index, T item) {
        T oldItem = list.get(index);
        list.set(index, item);
        if (item.compareTo(oldItem) < 0) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }
    }

    //This method adding element and keeping min heap structure
    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;
        if (leftChildIndex < list.size() && list.get(leftChildIndex).compareTo(list.get(smallest)) < 0) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < list.size() && list.get(rightChildIndex).compareTo(list.get(smallest)) < 0) {
            smallest = rightChildIndex;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }
    //Just adding
    @Override
    public void add(int index, T item) {
        add(item);
    }
    //getting element by index
    @Override
    public T get(int index) {
        return list.get(index);
    }

    //getting first element
    @Override
    public T getFirst() {
        return list.get(0);
    }

    //getting second element
    @Override
    public T getLast() {
        return list.get(list.size() - 1);
    }
    //removing with keeping structure
    @Override
    public void remove(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        T lastItem = list.get(list.size() - 1);
        list.set(index, lastItem);
        list.remove(list.size() - 1);
        heapifyDown(index);
    }

    //removing first element
    @Override
    public void removeFirst() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        remove(0);
    }

    @Override
    public void removeLast() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        list.remove(list.size() - 1);
    }

    //To get index of element
    @Override
    public int indexOf(Object object) {
        return list.indexOf(object);
    }

    @Override
    public int lastIndexOf(Object object) {
        return list.lastIndexOf(object);
    }

    //for checking if exist element
    @Override
    public boolean exists(Object object) {
        return list.exists(object);
    }

    //Clearing array
    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
