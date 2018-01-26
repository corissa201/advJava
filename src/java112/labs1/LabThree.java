package java112.labs1;

/**
 * @author Corissa Engel
 * class LabThree
 */
public class LabThree {


    /**
     * TODO: comment
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        //String test = "test";

        if (arguments.length != 1) {
            System.out.println("Please enter one argument on the command line");
            return;
        }
        LabThree test = new LabThree();
        test.run(arguments[0]);
    }

    /**
     * TODO: comment
     */
    public void run(String test) {
        System.out.println("input: " + test);

    }


}

