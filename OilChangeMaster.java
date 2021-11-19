/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-09-21
 */
import java.util.Scanner;
/**
 * Write a fully-documented class named OilChangeManager which creates three
 * instances of the CarList class and provides an interface for a user to
 * manipulate the list by adding, and removing Cars.
 */
public class OilChangeMaster {
    /**
     * The main method runs a menu driven application which first creates an
     * empty CarList and then prompts the user for a menu command selecting
     * the operation. The required information is then requested from the user
     * based on the selected operation. You can find the list of menu options
     * in the UI required functions section.
     * @param args
     * @throws EndOfListException Extends exception class
     * @throws IllegalArgumentException Extends exception class
     */
    public static void main(String[] args) throws EndOfListException,
            IllegalArgumentException{
        CarList joeList = new CarList();
        CarList donnyList = new CarList();
        CarList finishedList = new CarList();
        CarList thisList = joeList;
        Make carMake;
        Car newCar;
        Car cutCar = new Car();
        Car finishedCar = new Car();

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tony's Discount Oil Change Computer " +
                "Management System! It's way better than a rolodex, " +
                "cork board, post-its, and pre-chewed bubblegum!");
        System.out.println("Menu:\n" +
                "\n" +
                "     L) Edit Job Lists for Joe and Donny\n" +
                "\n" +
                "     M) Merge Job Lists\n" +
                "\n" +
                "     P) Print Job Lists\n" +
                "\n" +
                "     F) Paste car to end of finished car list\n" +
                //"\n" +
                //"     S) Sort Job Lists\n" +
                "\n" +
                "     Q) Quit.");
        boolean x = true;
        while (x){
            System.out.println("\n" + "Please select an option: ");
            char choice = sc.next().charAt(0);
            switch (Character.toUpperCase(choice)) {
                case 'L' -> {
                    System.out.println("Please select a list - " +
                            "Joe (J) or Donny (D):");
                    char choiceJD = sc.next().charAt(0);
                    String listName = "";
                    switch (Character.toUpperCase(choiceJD)) {
                        case 'J' -> {
                            thisList = joeList;
                            listName = "Joe";
                        }
                        case 'D' -> {
                            thisList = donnyList;
                            listName = "Donny";
                        }
                    }
                    System.out.println("Options:\n" +
                            "\n" +
                            "     A) Add a car to the end of the list\n" +
                            "\n" +
                            "     F) Cursor Forward\n" +
                            "\n" +
                            "     H) Cursor to Head\n" +
                            "\n" +
                            "     T) Cursor to Tail\n" +
                            "\n" +
                            "     B) Cursor Backward\n" +
                            "\n" +
                            "     I) Insert car before cursor\n" +
                            "\n" +
                            "     X) Cut car at cursor\n" +
                            "\n" +
                            "     V) Paste before cursor\n" +
                            "\n" +
                            "     R) Remove cursor");
                    System.out.println("Please select an option: ");
                    char choiceL = sc.next().charAt(0);
                    switch (Character.toUpperCase(choiceL)) {
                        case 'A' -> {
                            System.out.println("Please enter vehicle make " +
                                    "(Ford, GMC, Chevy, Jeep, Dodge, " +
                                    "Chrysler, and Lincoln): ");
                            sc.nextLine();
                            String makeLA = sc.nextLine();
                            makeLA = makeLA.toUpperCase();
                            try{
                                carMake = Make.valueOf(makeLA);
                            } catch (Exception e){
                                System.out.printf("We don't service %s!",
                                        makeLA);
                                break;
                            }
                            System.out.println("Please enter owner's name: ");
                            String nameLA = sc.nextLine();
                            newCar = new Car(carMake, nameLA);
                            thisList.appendToTail(newCar);
                            System.out.printf("%s's %s has been " +
                                            "scheduled for an oil change " +
                                            "with %s and has been" +
                                            " added to his list.", nameLA,
                                    carMake, listName);
                        }
                        case 'F' -> {
                            String nameF = "";
                            if (thisList == joeList)
                                nameF = "Joe";
                            if (thisList == donnyList)
                                nameF = "Donny";
                            thisList.cursorForward();
                            System.out.printf("Cursor Moved Forward " +
                                    "in %s's List.", nameF);
                        }
                        case 'H' -> {
                            String nameH = "";
                            if (thisList == joeList)
                                nameH = "Joe";
                            if (thisList == donnyList)
                                nameH = "Donny";
                            thisList.resetCursorToHead();
                            System.out.printf("Cursor Moved To Head " +
                                    "in %s's List.", nameH);
                        }
                        case 'T' -> {
                            String nameT = "";
                            if (thisList == joeList)
                                nameT = "Joe";
                            if (thisList == donnyList)
                                nameT = "Donny";
                            thisList.resetCursorToTail();
                            System.out.printf("Cursor Moved To Tail " +
                                    "in %s's List.", nameT);
                        }
                        case 'B' -> {
                            String nameB = "";
                            if (thisList == joeList)
                                nameB = "Joe";
                            if (thisList == donnyList)
                                nameB = "Donny";
                            thisList.cursorBackward();
                            System.out.printf("Cursor Moved Backward " +
                                    "in %s's List.", nameB);
                        }
                        case 'I' -> {
                            String nameLI = "";
                            if (thisList == joeList)
                                nameLI = "Joe";
                            if (thisList == donnyList)
                                nameLI = "Donny";
                            System.out.println("Please enter vehicle make " +
                                    "(Ford, GMC, Chevy, Jeep, Dodge, " +
                                    "Chrysler, and Lincoln): ");
                            sc.nextLine();
                            String makeI = sc.nextLine();
                            makeI = makeI.toUpperCase();
                            try{
                                carMake = Make.valueOf(makeI);
                            } catch (Exception e){
                                System.out.printf("We don't service %s!",
                                        makeI);
                                break;
                            }
                            System.out.println("Please enter owner's name: ");
                            String nameI = sc.nextLine();
                            newCar = new Car(carMake, nameI);
                            thisList.insertBeforeCursor(newCar);
                            System.out.printf("%s's %s has been scheduled" +
                                    " for an oil change with %s and " +
                                    "has been added to his list before the " +
                                    "cursor.", nameI, carMake, nameLI);
                        }
                        case 'X' -> {
                            String nameX = "";
                            if (thisList == joeList)
                                nameX = "Joe";
                            if (thisList == donnyList)
                                nameX = "Donny";
                            finishedCar = thisList.removeCursor();
                            System.out.printf("Cursor cut in %s's List", nameX);
                        }
                        case 'V' -> {
                            String nameV = "";
                            if (thisList == joeList)
                                nameV = "Joe";
                            if (thisList == donnyList)
                                nameV = "Donny";
                            thisList.insertBeforeCursor(cutCar);
                            System.out.printf("Cursor pasted in %s's List",
                                    nameV);
                        }
                        case 'R' -> {
                            String nameR = "";
                            if (thisList == joeList)
                                nameR = "Joe";
                            if (thisList == donnyList)
                                nameR = "Donny";
                            thisList.removeCursor();
                            System.out.printf("Cursor cut in %s's List", nameR);
                        }
                    }
                }
                case 'M' -> {
                    System.out.println("Please select a destination list - " +
                            "Joe (J) or Donny (D): ");
                    char choiceM = sc.next().charAt(0);
                    String listNameMD = "";
                    String listNameMM = "";
                    CarListNode nodePtr;
                    CarList mergingList = new CarList();
                    CarList destinationList = new CarList();
                    switch (Character.toUpperCase(choiceM)) {
                        case 'J' -> {
                            mergingList = donnyList;
                            destinationList = joeList;
                            listNameMD = "Joe";
                            listNameMM = "Donny";
                            nodePtr = joeList.getCursor();
                        }
                        case 'D' -> {
                            mergingList = joeList;
                            destinationList = donnyList;
                            listNameMD = "Donny";
                            listNameMM = "Joe";
                            nodePtr = donnyList.getCursor();
                        }
                        default -> throw new IllegalStateException
                                ("Unexpected value: " +
                                        Character.toUpperCase(choiceM));
                    }
                    destinationList.resetCursorToHead();
                    mergingList.resetCursorToHead();
                    if (destinationList.numCars() == 1 ||
                            destinationList.numCars() == 0) {
                        while (mergingList.getCursor().getNext() != null) {
                            destinationList.appendToTail
                                    (mergingList.getCursor().getData());
                            mergingList.removeCursor();
                        }
                        destinationList.appendToTail
                                (mergingList.getTail().getData());
                        mergingList.resetCursorToTail();
                        mergingList.removeCursor();
                    } else if (destinationList.numCars() ==
                            mergingList.numCars()) {
                        while (destinationList.getCursor().getNext() != null &&
                                mergingList.getCursor().getNext() != null) {
                            destinationList.cursorForward();
                            destinationList.insertBeforeCursor
                                    (mergingList.getCursorCar());
                            mergingList.removeCursor();
                        }
                        destinationList.appendToTail
                                (mergingList.getTail().getData());
                        mergingList.resetCursorToTail();
                        mergingList.removeCursor();
                    } else if (destinationList.numCars() >
                            mergingList.numCars()) {
                        while (destinationList.getCursor().getNext() != null &&
                                mergingList.getCursor().getNext() != null) {
                            destinationList.cursorForward();
                            destinationList.insertBeforeCursor
                                    (mergingList.getCursorCar());
                            mergingList.removeCursor();
                        }
                        destinationList.cursorForward();
                        destinationList.insertBeforeCursor
                                (mergingList.getTail().getData());
                        mergingList.resetCursorToTail();
                        mergingList.removeCursor();
                    } else if (destinationList.numCars() <
                            mergingList.numCars()) {
                        while (destinationList.getCursor().getNext() != null &&
                                mergingList.getCursor().getNext() != null) {
                            destinationList.cursorForward();
                            destinationList.insertBeforeCursor
                                    (mergingList.getCursorCar());
                            mergingList.removeCursor();
                        }
                        while (mergingList.getCursor().getNext() != null) {
                            destinationList.appendToTail
                                    (mergingList.getCursor().getData());
                            mergingList.removeCursor();
                        }
                        destinationList.appendToTail
                                (mergingList.getTail().getData());
                        mergingList.resetCursorToTail();
                        mergingList.removeCursor();
                    }
                    destinationList.setCursor(nodePtr);
                    System.out.printf("%s's list merged into %s's.",
                            listNameMM, listNameMD);
                }
                case 'P' -> {
                    System.out.print("Joe's List: ");
                    joeList.toString();
                    System.out.print("Donny's List: ");
                    donnyList.toString();
                    System.out.print("Finished List: ");
                    finishedList.toString();
                }
                case 'F' -> {
                    finishedList.appendToTail(finishedCar);
                    System.out.println("Car pasted in finished list");
                }
                case 'Q' -> {
                    System.out.println("Enjoy your retirement!");
                    x = false;
                }
            }
        }
    }
}
