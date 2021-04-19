import java.rmi.*;
import java.rmi.registry.*;

public class MyServer{

    public static void main(String args[]){

        try{
            Calculator stub= new CalculatorRemote();
            String port = args[0];
            Naming.rebind("rmi://localhost:"+port+"/calculator",stub);
        }catch(Exception e){
            System.out.println("Server exception: " + e);
        }

    }    //main
}  //MyServer
