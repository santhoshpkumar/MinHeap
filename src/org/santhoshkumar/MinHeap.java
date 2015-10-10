package org.santhoshkumar;
        import java.util.*;

public class MinHeap {
    ArrayList<Integer> heap;

    MinHeap(){
        heap = new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        h.insert(5);
        h.insert(4);
        h.insert(10);
        h.insert(12);
        h.insert(3);
        h.insert(1);
        h.insert(9);

        System.out.println(h.getMin());
        System.out.println(h.getMin());
        System.out.println(h.getMin());
        System.out.println(h.getMin());
        System.out.println(h.getMin());
        System.out.println(h.getMin());
        System.out.println(h.getMin());
        System.out.println(h.getMin());
    }

    public void insert(int data){
        heap.add(data);
        bubbleUp(heap.size() - 1);
    }

    public int getMin(){
        int result = -1;
        if(heap.size() >0 ) {
            result = heap.get(0);
            int lastIndex = heap.size() - 1;
            heap.set(0, heap.get(lastIndex));
            heap.remove(lastIndex);
            sinkDown(0);
        }
        return result;
    }

    // Check max heap for recursive version
    private void sinkDown(int index){
        int smallest = index;
        while(true) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;

            if (left < heap.size() && heap.get(index) > heap.get(left)) {
                smallest = left;
            }
            if (right < heap.size() && heap.get(smallest) > heap.get(right)) {
                smallest = right;
            }
            if (smallest != index) {
                int swap = heap.get(index);
                heap.set(index, heap.get(smallest));
                heap.set(smallest, swap);
                index = smallest;
            }else{
                break;
            }
        }
    }

    // Check max heap for recursive version
    private void bubbleUp(int index){
        int parent = (int)index/2;
        while(heap.get(parent) > heap.get(index)) {
            int swap = heap.get(parent);
            heap.set(parent, heap.get(index));
            heap.set(index, swap);
            index = parent;
            parent = (int)index/2;
        }
    }
}
