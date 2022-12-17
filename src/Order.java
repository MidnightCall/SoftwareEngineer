import java.util.Iterator;
import java.util.Vector;

public class Order {
    private Vector items;

    public Order(){
        items = new Vector();
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.removeElement(item);
    }

    public Iterator getItemsIterator(){
        return items.iterator();
    }

    public OrderItem getItem(Product product){
        for(Iterator iter = items.iterator(); iter.hasNext();){
            OrderItem oi = (OrderItem) iter.next();
            if(oi.getProduct().equals(product))
                return oi;
        }
        return null;
    }

    public int getNumberOfItems(){
        return items.size();
    }

    public double getTotalCost(){
        double sum = 0.0;
        for(Iterator iter = items.iterator(); iter.hasNext();){
            OrderItem oi = (OrderItem) iter.next();
            sum += oi.getValue();
        }
        return sum;
    }
}
