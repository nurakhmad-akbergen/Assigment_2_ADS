public class MyStack {
    public class Stack<T extends Comparable<T>> {
        private final MyList<T> list;

        public Stack() {
            this.list = new MyArrayList<>();
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public int getSize() {
            return list.size();
        }

        public T getLast() {
            return list.getLast();
        }

        public void add(T element) {
            list.addLast(element);
        }

        public T receiveItem() {
            T topElement = list.getLast();
            list.removeLast();
            return topElement;
        }
    }
}
