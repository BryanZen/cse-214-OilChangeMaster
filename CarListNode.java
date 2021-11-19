/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-09-21
 */

/**
 * Write a fully-documented class named CarListNode that wraps a Car object to
 * allow it to be inserted into a doubly linked-list data structure. The Car
 * object reference should be contained in a field called data and there should
 * be two CarListNode references serving as ‘links’ to the previous and next
 * CarListNodes in the list. You should provide getter and setter methods for
 * all member variables in this class as well.
 */
public class CarListNode {
    public static int CAPACITY;
    private Car data;
    private CarListNode next;
    private CarListNode prev;

    /**
     * Initializes new Car objects as a node of CarList
     * @param initData Input as a Car Object
     */
    public CarListNode(Car initData){
        try{
            if (initData == null){
                throw new IllegalArgumentException();
            } else{
                prev = null;
                next = null;
                data = initData;
            }
        } catch (IllegalArgumentException e){
            System.out.println("There is no data in this Car List");
        }
    }

    /**
     *
     * @return returns next Car object linked
     */
    public CarListNode getNext(){
        return next;
    }

    /**
     *
     * @return returns previous Car object linked
     */
    public CarListNode getPrev(){
        return prev;
    }

    /**
     *
     * @return Returns data of Node as Car object
     */
    public Car getData(){
        return data;
    }

    /**
     *
     * @param newNext sets next link to new node
     */
    public void setNext(CarListNode newNext){
        next = newNext;
    }

    /**
     *
     * @param newPrev sets previous link to new node
     */
    public void setPrev(CarListNode newPrev){
        prev = newPrev;
    }

    /**
     *
     * @param newData Sets data of node as Car object
     */
    public void setData(Car newData){
        data = newData;
    }
}
