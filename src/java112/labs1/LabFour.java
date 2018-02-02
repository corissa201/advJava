package java112.labs1;


import java.io.*;


/**
 * @author Corissa Engel
 * class LabFour
 */

public class LabFour {

    /**
     * Run the lab
     */
    public void run(String filePath) {

        BufferedReader input = null;
        try {

            input = new BufferedReader(new FileReader(filePath));

            while (input.ready()) {
                System.out.println(input.readLine());
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
            if (arguments.length != 1) {
                System.out.println("Please enter one argument on the command line");
                return;
            }
        LabFour demo = new LabFour();
        demo.run(arguments[0]);
    }
}