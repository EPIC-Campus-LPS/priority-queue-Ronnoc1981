import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents a Priority Queue (heap) based on the ordering
 * defined by the compareTo method for the element. "Lower" value will
 * mean "higher" priority.
 *
 * @param <E> the type of elements in the queue
 * @author
 */
public class PriorityQueue<E extends Comparable<E>> {

    private ArrayList<E> myHeap; //array representation of the heap
    private int mySize;
    /**
     * Creates an empty Priority Queue
     */
    public PriorityQueue() {
        myHeap = new ArrayList<E>();
    }

    /**
     * Adds the element to the priority queue
     *
     * @param element the element to be added
     */
    public void add(E element) {
        mySize++;
        myHeap.add(element);
        shiftUp(myHeap.size() - 1);
    }

    /**
     * Swaps two elements in the queue.
     * Pre-condition: 0 <= posOne, posTwo < size of queue
     *
     * @param posOne the first element's position in the queue
     * @param posTwo the second element's position in the queue
     */
    private void swap(int posOne, int posTwo) {
        if (posOne >= 0 && posTwo < myHeap.size()) {
            E temp = myHeap.get(posOne);
            myHeap.set(posOne, myHeap.get(posTwo));
            myHeap.set(posTwo, temp);
        }
    }

    /**
     * Returns whether or not the element is in the heap
     *
     * @param element the element to be searched for
     * @return true if the element is in the queue, false otherwise
     */
    public boolean contains(E element) {
        return myHeap.contains(element);
    }

    /**
     * Returns the element of highest priority, null if queue is empty.
     * Post-condition: the queue is not changed
     *
     * @return the element of highest priority queue
     */
    public E peek() {
        if(mySize == 0){
            return null;
        }
        return myHeap.get(0);
    }

    /**
     * Removes and returns the element of highest priority,
     * returns null if queue is empty.
     *
     * @return the element of highest priority
     */
    public E poll() {
        if(mySize == 0){
            return null;
        }
        E removed = myHeap.remove(0);
        mySize--;
        shiftDown(0);
        return removed;
    }

    /**
     * Will "sift down" the element at the given position
     * down to restore the heap property
     *
     * @param pos the starting position for heapify
     */
    private void shiftUp(int pos) {
        int parent = (pos - 1) / 2;
        while(pos > 0 && myHeap.get(parent).compareTo(myHeap.get(pos)) > 0){
            swap(parent, pos);
            pos = parent;
            parent = (pos - 1) / 2;
        }
    }

    private void shiftDown(int pos) {
        int lowest = pos;
        int r = 2 * pos + 1;
        int l =  2 * pos + 2;

        if(l < mySize && myHeap.get(l).compareTo(myHeap.get(pos)) < 0){
            lowest = l;
        }

        if(r < mySize && myHeap.get(r).compareTo(myHeap.get(lowest)) < 0){
            lowest = r;
        }

        if(lowest != pos){
            swap(pos, lowest);
            shiftDown(lowest);
        }


    }

    /**
     * Finds and removes the given element from the queue.
     * Returns true if an element was deleted from the queue,
     * false otherwise.
     *
     * @param element the element to be removed from the queue
     * @return true if an element was removed from the queue, false otherwise
     */
    public boolean remove(E element) {
        if(myHeap.contains(element)){
            int index = myHeap.indexOf(element);
            myHeap.remove(element);
            mySize--;
            shiftDown(index);
            return true;
        }
        return false;
    }

    /**
     * Returns the number of elements in the queue
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return mySize;
    }

    /**
     * Returns the String representation of the heap
     * (by the order of list, each element separated
     * with a single space)
     *
     * @return the String representation of the heap
     */
    public String toString() {
        String end = "";
        for(int i = 0; i < mySize; i++){
            end += myHeap.get(i).toString() + " ";
        }
        return end;
    }


    /**
     * Main method - contains console program used
     * for testing of the PriorityQueue class.
     *
     * @param args
     */
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Choose an option");
            System.out.println("1. Add an element");
            System.out.println("2. Remove an element");
            System.out.println("3. Remove 1st element");
            System.out.println("4. Display all elements");
            System.out.println("5. Check current top element");
            System.out.println("6. exit");
            int choice = sc.nextInt();

            if(choice == 1){
                pq.add(sc.nextInt());
            }
            else if(choice == 2){
                System.out.println("Which element would you like to remove?");
                pq.remove(sc.nextInt());
            }
            else if(choice == 3){
                System.out.println(pq.poll());
            }
            else if(choice == 4){
                System.out.println(pq.toString());
            }
            else if(choice == 5){
                System.out.println(pq.peek());
            }
            else if(choice == 6){
                break;
            }

        }
        sc.close();

    }

}