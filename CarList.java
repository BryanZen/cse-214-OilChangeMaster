/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-09-21
 */

/**
 * The CarList should maintain a list of Cars by chaining a series of
 * CarListNodes between a head and a tail reference. In addition, a cursor
 * should be provided to allow a user to traverse the list, selecting individual
 * CarListNodes to allow for insertion, deletion, and manipulation of the Cars
 * they contain. Lastly, the class should provide methods to query information
 * about the list, such as its size and the total price of all the Cars in the
 * list.
 */
public class CarList {
    private CarListNode head;
    private CarListNode tail;
    private CarListNode cursor;
    private int carCount = 0;

    /**
     *Default constructor which initializes this object to an empty list of Cars.
     * Postconditions:
     * This CarList has been initialized with head, tail, and cursor all set to null.
     */
    public CarList(){
        head = null;
        tail = null;
        cursor = null;
    }

    /**
     * Sets current node to head
     * @param head the new head node
     */
    public void setHead(CarListNode head){
        this.head = head;
    }

    /**
     * Sets current node to tail
     * @param tail the new tail node
     */
    public void setTail(CarListNode tail){
        this.tail = tail;
    }

    /**
     * Sets current node to cursor
     * @param cursor The new cursor node
     */
    public void setCursor(CarListNode cursor){
        this.cursor = cursor;
    }

    /**
     * Sets current car count
     * @param carCount new car count
     */
    public void setCarCount(int carCount){
        this.carCount = carCount;
    }

    /**
     * Gets the head of list as a node
     * @return head as a node
     */
    public CarListNode getHead(){
        return head;
    }

    /**
     * Gets tail of list as a node
     * @return tail as a node
     */
    public CarListNode getTail(){
        return tail;
    }

    /**
     * Gets cursor of list as a node
     * @return cursor as a node
     */
    public CarListNode getCursor(){
        return cursor;
    }

    /**
     * Returns the total number of Cars in the list.
     * This method should run in O(1) time.
     * @return carCount as an integer
     */
    public int numCars(){
        return carCount;
    }

    /**
     *Gets the reference to the Car wrapped by the CarListNode currently
     * referenced by cursor.
     * Returns the reference by the Car wrapped by the CarListNode currently
     * referenced by cursor. If the cursor is null, then this method should
     * return null as well (i.e. the cursor does not reference a Car).
     * @return cursorData as a Car object
     */
    public Car getCursorCar(){
        Car cursorData = cursor.getData();
        if (cursorData == null){
            return null;
        } else
            return cursorData;
    }

    /**
     *Returns the cursor to the start of the list.
     * Postconditions:
     * If head is not null, the cursor now references the first CarListNode
     * in this list.
     * If head is null, the cursor is set to null as well (there are no Cars
     * in this list).
     */
    public void resetCursorToHead(){
        if (cursor != null){
            cursor = head;
        } else
            cursor = null;
    }

    /**
     *Returns the cursor to the end of the list
     */
    public void resetCursorToTail(){
        if (cursor != null){
            cursor = tail;
        } else
            cursor = null;
    }

    /**
     *Moves the cursor to select the next CarListNode in the list. If the
     * cursor is at the tail of the list, this method throws an exception
     * (this includes the case where cursor and tail are both null).
     * @throws EndOfListException if cursor is at the tail of the list.
     */
    public void cursorForward() throws EndOfListException {
        if (cursor.getNext() != null){
            cursor = cursor.getNext();
        } else
            throw new EndOfListException("Cursor is at the tail.");
    }

    /**
     *Moves the cursor to select the previous CarListNode in the list. If the
     *  cursor is at the head of the list, this method throws an exception
     *  (this includes the case where cursor and head are both null).
     * @throws EndOfListException if cursor is at the head of the list.
     */
    public void cursorBackward() throws EndOfListException{
        if (cursor.getPrev() != null){
            cursor = cursor.getPrev();
        } else
            throw new EndOfListException("Cursor is at the head.");
    }

    /**
     *Inserts the indicated Car before the cursor.
     * Preconditions:
     * newCar is not null.
     * Postconditions:
     * newCar has been wrapped in a new CarListNode object.
     * If cursor was previously not null, the newly created CarListNode has
     * been inserted into the list before the cursor.
     * If cursor was previously null, the newly created CarListNode has been
     * set as the new head of the list (as well as the tail and cursor).
     * The cursor remains unchanged.
     * @param newCar Input newCar as Car object
     * @throws IllegalArgumentException if newCar is null.
     */
    public void insertBeforeCursor(Car newCar) throws IllegalArgumentException{
        if (newCar == null){
            throw new IllegalArgumentException("This car has no data.");
        }
        CarListNode newCarNode = new CarListNode(newCar);
        if (cursor == null){
            head = newCarNode;
            tail = newCarNode;
            cursor = newCarNode;
        } else{
            if (cursor != head) {
                cursor.getPrev().setNext(newCarNode);
                newCarNode.setNext(cursor);
                cursor.setPrev(newCarNode);
            } else{
                newCarNode.setNext(head);
                head.setPrev(newCarNode);
                head = newCarNode;
            }
        }
        carCount++;
    }

    /**
     *Inserts the indicated Car after the tail of the list.
     * Preconditions:
     * newCar is not null.
     * Postconditions:
     * newCar has been wrapped in a new CarListNode object.
     * If tail was previously not null, the newly created CarListNode has been
     * inserted into the list after the tail.
     * If tail was previously null, the newly created CarListNode has been set
     * as the new head of the list (as well as the tail and the cursor).
     * The tail now references the newly created CarListNode.
     * @param newCar Input newCar as Car object
     * @throws IllegalArgumentException if newCar is null.
     */
    public void appendToTail(Car newCar) throws IllegalArgumentException{
        if (newCar == null){
            throw new IllegalArgumentException("This car has no data.");
        }
        CarListNode newCarNode = new CarListNode(newCar);
        if (tail == null){
            head = newCarNode;
            tail = newCarNode;
            cursor = newCarNode;
        } else{
            tail.setNext(newCarNode);
            newCarNode.setPrev(tail);
            tail = newCarNode;
        }
        carCount++;
    }

    /**
     *Removes the CarListNode referenced by cursor and returns the Car inside.
     * Preconditions:
     * cursor is not null.
     * Postconditions:
     * The CarListNode referencedby cursor has been removed from the list.
     * All other CarListNodes in the list exist in the same Car as before.
     * The cursor now references the previous CarListNode (or the head, if the
     * cursor previously referenced the head of the list).
     * @return Returns the removed Car object
     * @throws EndOfListException if cursor is null.
     */
    public Car removeCursor() throws EndOfListException {
        if (cursor == null){
            throw new EndOfListException("There is no data in this car list.");
        }
        Car removedCar = cursor.getData();
        if (carCount == 1){
            head = null;
            tail = null;
            cursor = null;
            carCount--;
            return removedCar;
        }
        if (cursor != head && cursor != tail){
            cursor.getPrev().setNext(cursor.getNext());
            cursor.getNext().setPrev(cursor.getPrev());
            cursor = cursor.getPrev();
        } else if (cursor == head){
            head = cursor.getNext();
            head.setPrev(null);
            cursor = head;
        } else if (cursor == tail){
            tail = cursor.getPrev();
            tail.setNext(null);
            cursor = tail;
        }
        carCount--;
        return removedCar;
    }

    /**
     * Nicely prints the make and owner of each car object in a List
     * @return Easch car object and it's data as a string
     */
    public String toString(){
        CarListNode nodePtr;
        nodePtr = head;
        System.out.println();
        System.out.println("Make        Owner");
        System.out.println("----------------------");
        if (nodePtr == null) {
            System.out.println("[empty]");
        }
        while (nodePtr != null){
            if (nodePtr == cursor) {
                System.out.print("- >");
                System.out.printf("%-8s %s%n", nodePtr.getData().getMake(),
                        nodePtr.getData().getOwner());
            } else {
                System.out.printf("%-11s %s%n", nodePtr.getData().getMake(),
                        nodePtr.getData().getOwner());
            }
            nodePtr = nodePtr.getNext();
        }
        return "";
    }
}
