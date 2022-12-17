/**
 * @ClassName Product
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2022/12/5 9:53
 * @Version
 */

public class Product {
    private String code;
    private String description;
    private double price;

    public Product(String code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean equals(Object var1) {
        return var1 instanceof Product && this.getCode().equals(((Product)var1).getCode());
    }

    public String toString() {
        return this.getCode() + "_" + this.getDescription() + "_" + this.getPrice();
    }
}