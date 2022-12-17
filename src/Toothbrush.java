/**
 * @ClassName CoffeeBrewer
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2022/12/5 9:52
 * @Version
 */

public class Toothbrush extends Product {
    private String brand;
    private String hardness;
    private String shape;

    public Toothbrush(String code, String description, double price) {
        super(code, description, price);
    }

    public Toothbrush(String code, String description, double price,
                      String brand, String hardness, String shape) {
        super(code, description, price);
        this.brand = brand;
        this.hardness = hardness;
        this.shape = shape;
    }

    public String getBrand() {
        return brand;
    }

    public String getHardness() {
        return hardness;
    }

    public String getShape() {
        return shape;
    }

    @Override
    public String toString() {
        return super.toString() + "_" + this.getBrand() + "_" + this.getHardness() + "_" + this.getShape();
    }
}