import java.rmi.*;
import java.rmi.registry.*;

public class MyServer{

    public static void main(String args[]){

        try{

            //Checking if port is default or specified by user:

            String port;
            if(args.length == 0){
                port = "1099";
            } else {
                port = args[0];
            }

            // Creating the stub:

            Calculator stub= new CalculatorRemote();

            // Binding the remote object

            Naming.rebind("rmi://localhost:"+port+"/calculator",stub);

        }catch(Exception e){
            System.out.println("Server exception: " + e);
        }

    }
}
