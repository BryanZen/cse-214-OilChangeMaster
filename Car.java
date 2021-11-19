/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-09-21
 */

/**
 * Write a fully-documented class named Car which contains the make of the car,
 * and the owner's name . You should provide getter and setter methods for all
 * member variables. In addition, you should provide a constructor as detailed
 * below, though you may create a custom constructor which takes any arguments
 * you see fit. Lastly, you should provide a toString() method that returns a
 * printable representation of the Car and its data members (make and order).
 */
public class Car {
    private Make make;
    private String owner;

    /**
     * used for initializing new Car object
     */
    public Car(){
    }

    /**
     * used for creating new car object with data
     * @param make specifies the make of the car as n enum
     * @param owner specifies owner of car as a String
     */
    public Car(Make make, String owner){
        this.make = make;
        this.owner = owner;
    }

    /**
     *
     * @return returns make of Car object
     */
    public Make getMake(){
        return make;
    }

    /**
     *
     * @return returns owner of Car object
     */
    public String getOwner(){
        return owner;
    }

    /**
     *
     * @param make Sets make of Car object
     */
    public void setMake(Make make){
        this.make = make;
    }

    /**
     *
     * @param owner Sets owner of Car object
     */
    public void setOwner(String owner){
        this.owner = owner;
    }

    /**
     *
     * @return Returns Car object parameters as  string
     */
    public String toString(){
        return "Car: " + make + "Owner name: " + owner;
    }
}
