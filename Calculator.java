import java.rmi.*;
public interface Calculator extends Remote {
    public String checkOperand(int x, int y) throws RemoteException;
    public String calculate(char op, int x, int y) throws RemoteException;
    public String checkResult(String result) throws RemoteException;
}
