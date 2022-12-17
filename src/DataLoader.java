/**
 * @ClassName DataLoader
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2022/12/5 12:16
 * @Version
 */

public class DataLoader {
    public Catalog loadCatalog() {

        Catalog catalog = new Catalog();

        catalog.addProduct(new Coffee(
                "C001", "Colombia, Whole, 1 lb", 17.99,
                "Colombia", "Medium", "Rich and Hearty", "Rich", "Medium", "Full"));
        catalog.addProduct(new Coffee(
                "C002", "Colombia, Ground, 1 lb", 18.75,
                "Colombia", "Medium", "Rich and Hearty", "Rich", "Medium","Full"));
        catalog.addProduct(new Coffee(
                "C003", "Italian Roasts, Whole, 1 lb", 16.80,
                "Latin American Blend", "Italian Roast", "Dark and heavy",
                "Intense", "Low", "Medium"));
        catalog.addProduct(new Coffee(
                "C004", "Italian Roasts, Ground, 1 lb", 17.55,
                "Latin American Blend", "Italian Roast", "Dark and heavy",
                "Intense", "Low", "Medium"));
        catalog.addProduct(new Coffee(
                "C005", "French Roasts, Whole, 1 lb", 16.80,
                "Latin American Blend", "French Roast", "Bittersweet, full intense",
                "Intense, full", "None", "Medium"));
        catalog.addProduct(new Toothbrush(
                "T001", "Toothbrush for child", 15.00,
                "Brush 001", "soft", "square"));
        catalog.addProduct(new Toothbrush(
                "T002", "Toothbrush for adult", 20.00,
                "Brush 002", "hard", "Diamond type"));
        catalog.addProduct(new Toothbrush(
                "T003", "Toothbrush for elder", 28.00,
                "Brush 003", "very soft", "rotundity"));
        return catalog;
    }

    public Sales loadSales(Catalog catalog) {

        Sales sales = new Sales();
        Order[] orders = new Order[6];

        orders[0] = new Order();
        orders[0].addItem(new OrderItem(catalog.getProduct("C001"), 5));
        sales.addOrder(orders[0]);

        orders[1] = new Order();
        orders[1].addItem(new OrderItem(catalog.getProduct("C002"), 2));
        orders[1].addItem(new OrderItem(catalog.getProduct("T001"), 2));
        orders[1].addItem(new OrderItem(catalog.getProduct("C003"), 2));
        sales.addOrder(orders[1]);

        orders[2] = new Order();
        orders[2].addItem(new OrderItem(catalog.getProduct("T002"), 1));
        orders[2].addItem(new OrderItem(catalog.getProduct("C003"), 3));
        sales.addOrder(orders[2]);

        orders[3] = new Order();
        orders[3].addItem(new OrderItem(catalog.getProduct("T003"), 2));
        orders[3].addItem(new OrderItem(catalog.getProduct("C001"), 3));
        orders[3].addItem(new OrderItem(catalog.getProduct("C003"), 3));
        orders[3].addItem(new OrderItem(catalog.getProduct("C005"), 3));
        orders[3].addItem(new OrderItem(catalog.getProduct("T001"), 3));
        orders[3].addItem(new OrderItem(catalog.getProduct("C004"), 2));
        sales.addOrder(orders[3]);

        orders[4] = new Order();
        orders[4].addItem(new OrderItem(catalog.getProduct("T001"), 1));
        orders[4].addItem(new OrderItem(catalog.getProduct("C002"), 2));
        orders[4].addItem(new OrderItem(catalog.getProduct("C003"), 2));
        orders[4].addItem(new OrderItem(catalog.getProduct("T001"), 2));
        orders[4].addItem(new OrderItem(catalog.getProduct("C002"), 6));
        sales.addOrder(orders[4]);

        orders[5] = new Order();
        orders[5].addItem(new OrderItem(catalog.getProduct("C001"), 1));
        orders[5].addItem(new OrderItem(catalog.getProduct("T001"), 1));
        orders[5].addItem(new OrderItem(catalog.getProduct("C005"), 5));
        orders[5].addItem(new OrderItem(catalog.getProduct("C001"), 5));
        orders[5].addItem(new OrderItem(catalog.getProduct("C004"), 4));
        sales.addOrder(orders[5]);

        return sales;
    }
}
