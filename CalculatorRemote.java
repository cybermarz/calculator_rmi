import java.rmi.*;
import java.rmi.server.*;

public class CalculatorRemote extends
UnicastRemoteObject implements Calculator {
    CalculatorRemote() throws RemoteException{
    super(); }

    public String checkOperand(int x, int y){
        if(x >= 0 && y >= 0){
            return "ok";
        }
        else{
            return "Negative operanddddd!";
        }
    }

    public String calculate(char op, int x, int y){
        String str;
        if((str = checkOperand(x,y)) != "ok"){
            return str;
        }
        else {
            switch (op) {
                case '+':
                    return String.valueOf(x + y);
                case '-':
                    return String.valueOf(x - y);
                case '*':
                    return String.valueOf(x * y);
                case '/':
                    return String.valueOf(x / y);
                default:
                    return "0";
            }
        }
    }


    public String checkResult(String result){
        if(result.contains("-")){
            return "Negative result!";
        }
        else if(result.contains(".")){
            return "Fractional result!";
        }
        else{
            return result;
        }
    }
}

