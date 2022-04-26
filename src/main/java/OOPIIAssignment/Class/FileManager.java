package OOPIIAssignment.Class;

import java.io.*;
import java.util.ArrayList;

public class FileManager  {
    public void SaveOrderToFile(Order O) throws IOException {
        FileOutputStream FOutput = new FileOutputStream("Order.ser");
        ObjectOutputStream ObjOutput = new ObjectOutputStream(FOutput);
        ObjOutput.writeObject(O);
    }

    public void SaveArrayListOrderToFile(ArrayList<Order> Orders) throws IOException {
        FileOutputStream FOutput = new FileOutputStream("Order.ser");
        ObjectOutputStream ObjOutput = new ObjectOutputStream(FOutput);
        ObjOutput.writeObject(Orders);
    }

    public Order ReadOrderFromFile() throws IOException, ClassNotFoundException {
        Order O = null;
        FileInputStream FInput = new FileInputStream("Order.ser");
        ObjectInputStream ObjInput = new ObjectInputStream(FInput);
        O = (Order) ObjInput.readObject();
        ObjInput.close();
        return O;
    }

    public ArrayList<Order> ReadArrayListOrderFromFile() throws  IOException, ClassNotFoundException{
        FileInputStream FInput = new FileInputStream("Order.ser");
        ObjectInputStream ObjInput = new ObjectInputStream(FInput);
        ArrayList<Order> Orders = (ArrayList<Order>) ObjInput.readObject();
        return Orders;
    }
}
