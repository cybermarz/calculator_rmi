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
            return "Negative operand!";
        }
    }

    public String calculate(char op, int x, int y){
        switch(op)
        {
            case '+':
                return addition(x,y);
            case '-':
                return subtraction(x,y);
            case '*':
                return multiplication(x,y);
            case '/':
                return division(x,y);
            default:
                return "Wrong operator!";
        }
    }

    public String addition(int x, int y){
        String result;
        result = String.valueOf(x+y);
        return result;
    }

    public String subtraction(int x, int y){
        String result;
        result = String.valueOf(x-y);
        return result;
    }

    public String multiplication(int x, int y){
        String result;
        result = String.valueOf(x*y);
        return result;
    }

    public String division(int x, int y){
        String result;
        if(y == 0){
            result = "Math Error! Division by zero";
        }
        else{
            result = String.valueOf(x/y);
        }
        return result;
    }

    public String checkResult(String result){
        if(result.contains("-")){
            return "Negative result";
        }
        else if(result.contains(".")){
            return "Fractional result!";
        }
        else{
            return result;
        }
    }

}

