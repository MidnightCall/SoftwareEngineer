import java.util.Iterator;
import java.util.Vector;

public class Sales {
    private Vector orders;

    public Sales(){
        orders = new Vector();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public Iterator getOrdersIterator(){
        return orders.iterator();
    }

    public int getNumberOfOrders(){
        return orders.size();
    }
}
