/**
 * @ClassName OrderItem
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2022/12/5 9:52
 * @Version
 */

public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int var1) {
        this.quantity = var1;
    }

    public double getValue() {
        return this.getProduct().getPrice() * (double)this.getQuantity();
    }

    public String toString() {
        return this.getQuantity() + " " + this.getProduct().getCode() + " " + this.getProduct().getPrice();
    }
}

