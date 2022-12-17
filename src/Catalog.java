import java.util.Iterator;
import java.util.Vector;

public class Catalog {
    private Vector products;

    public Catalog(){
        products = new Vector();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public Iterator getProductsIterator(){
        return products.iterator();
    }

    public Product getProduct(String code){
        for(Object o : products){
            Product p = (Product) o;
            if(p.getCode().equals(code))
                return p;
        }
        return null;
    }

    public int getNumberOfProducts(){
        return products.size();
    }

}
