package PerfectTicTacToe;
 public class ArrayTree<E> {
     private final Object[] array;
     private int count;
     int capacity;
     private final int order;

     public ArrayTree(int order, int capacity) {
         this.order = order;
         this.capacity = capacity;
         this.array = new Object[capacity];
         this.count = 0;
     }

     public int root() {
         return 0;
     }

     public int parent(int p) {
         return (p - 1) / order;
     }

     public int child(int p, int c) {
         int childPos = p * order + c + 1;
         if (childPos <= count+1) {
             return childPos;
         }
         return -1;
     }


     public int size() {
         return count;
     }

     public boolean isEmpty() {
         return count == 0;
     }

     public int addRoot(E e) {
         if (isEmpty()) {
             array[0] = e;
             count++;
             return 0;
         }
         return -1;
     }
     @SuppressWarnings("unchecked")
     public E get(int pos) {
         if (pos >= 0 && pos < count) {
             return (E) array[pos];
         }
         return null;
     }
     public void addChild(int parent, int childIndex, E e) {
         int childPos = child(parent, childIndex);
         if (childPos >= 0 && childPos < capacity) {
             array[childPos] = e;
             count++;
         }
     }

     public int getChild(int parent, int childIndex) {
         int childPos = child(parent, childIndex);
         if (childPos >= 0 && childPos < count) {
             return (int) array[childPos];
         }
         return -1;
     }

     public String toString() {
         StringBuilder result = new StringBuilder("[ArrayTree: order=" + order + ", count=" + count + ", size=" + capacity + ", array={");
         for (int i = 0; i < capacity; i++) {
             if (i > 0) {
                 result.append(" ");
             }
             result.append(array[i] != null ? array[i] : "-");
         }
         result.append(" }]");
         return result.toString();
     }

     public int getCapacity() {
         return capacity;
     }

 }