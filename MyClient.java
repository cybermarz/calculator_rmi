import java.rmi.*;
import java.util.InputMismatchException;
import java.util.Scanner;   //for taking input from the user

public class MyClient {
    public static void main(String args[]){

        try{
            Calculator stub=(Calculator)Naming.lookup("rmi://localhost:5001/calculator");

            System.out.println("\nSimple Calculator!");
            System.out.println("===========================");

            Scanner reader = new Scanner(System.in);
            char cont;

            do{
                    System.out.print("\n\nEnter two numbers: ");
                try {
                    //reads int from the keyboard
                    int a1 = reader.nextInt();
                    int a2 = reader.nextInt();
                    String response = stub.checkOperand(a1, a2);

                    if(response.equals("ok")) {
                        System.out.print("Enter an operator (+, -, *, /): ");
                        char op = reader.next().charAt(0);

                        String result = stub.calculate(op, a1, a2);
                        System.out.println(stub.checkResult(result));
                    }
                    else{
                        System.out.println(response);
                    }

                        System.out.print("Enter Y/y to continue and anything else to exit: ");
                        cont = reader.next().charAt(0);

                }catch (InputMismatchException e){
                    System.out.println("Wrong input!");
                    reader.next();
                    cont = 'y';
                }
            } while(cont == 'Y'|| cont == 'y');

        }catch(Exception e){
            System.out.println("Client exception: " + e);
        }
    }
}

