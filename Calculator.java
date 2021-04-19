import java.rmi.*;
public interface Calculator extends Remote {
    public boolean isNumeric(String str) throws RemoteException;
    public String checkOperand(String x, String  y) throws RemoteException;
    public String calculate(char op, int x, int y) throws RemoteException;
    public String checkResult(String result) throws RemoteException;
}
