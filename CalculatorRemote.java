import java.rmi.*;
import java.rmi.server.*;

public class CalculatorRemote extends
    UnicastRemoteObject implements Calculator {

    CalculatorRemote() throws RemoteException {
        super(); 
    }

    public String checkOperand(String x, String y) {
        try {
            Double.parseDouble(x);
            Double.parseDouble(y);
            return "";
        } catch(NumberFormatException e) {
            return "Invalid input!";
        }
    }

    public String calculate(char op, int x, int y){
        switch (op) {
            case '+':
                return String.valueOf(x + y);
            case '-':
                return String.valueOf(x - y);
            case '*':
                return String.valueOf(x * y);
            case '/':
                if(y == 0){
                    return "Division by zero!";
                } else if(x % y != 0) {
                    return "Fractional result!";
                } else {
                    return String.valueOf(x / y);
                }
            default:
                return "0";
        }
    }


    public String checkResult(String result){
        if (result.equals("Fractional result!") || result.equals("Division by zero!")){
            return result;
        } else if(result.length() > 8){
            return "Large number!";
        } else if (Integer.parseInt(result) < 0) {
            return "Negative result";
        } else {
            return "";
        }
    }
}

