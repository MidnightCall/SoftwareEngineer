import java.io.*;
import java.util.*;
import java.text.*;

/**
 * This class implements a gourmet coffee system.
 *
 * @author author name
 * @version 1.1.0
 * @see Product
 * @see Coffee
 * @see Toothbrush
 * @see Catalog
 * @see OrderItem
 * @see Order
 */
public class POSSystem {

	private static BufferedReader  stdIn =
		new  BufferedReader(new  InputStreamReader(System.in));

	private static final NumberFormat CURRENCY =
		NumberFormat.getCurrencyInstance();
	private DataLoader loader;

	private UI ui;

	private Catalog catalog;
	private Order currentOrder;
	private Sales sales;

	public static void main(String[]  args) throws IOException  {

		POSSystem application = new POSSystem();
		application.run();

	}

	private POSSystem() {
		loader = new DataLoader();
		ui = new UI();
		catalog = loader.loadCatalog();
		sales = loader.loadSales(catalog);
		currentOrder = new Order();
	}



	private void run() throws IOException  {

		int  choice = ui.getChoice();

		while(choice != 0) {
			switch (choice) {
				case 1:
					displayCatalog();
					break;
				case 2:
					displayProductInfo();
					break;
				case 3:
					displayOrder();
					break;
				case 4:
					addModifyProduct();
					break;
				case 5:
					removeProduct();
					break;
				case 6:
					saleOrder();
					break;
				case 7:
					displayOrdersSold();
					break;
				case 8:
					displayNumberOfOrders(readProduct());
					break;
				case 9:
					displayTotalQuantityOfProducts();
					break;
			}
			System.out.println("press [Enter] to continue...");
			new BufferedReader(new InputStreamReader(System.in)).readLine();
			for(int i = 0; i < 50; i++){
				System.out.println();
			}
			choice = ui.getChoice();
		}

		System.out.println("Thanks for using");
	}



	public void displayCatalog() {

		int size = catalog.getNumberOfProducts();

		if (size == 0) {
			System.out.println("The catalog is empty");
		} else {
			for (Iterator i = catalog.getProductsIterator(); i.hasNext();) {

				Product product = (Product) i.next();

				System.out.println(product.getCode() + " " +
					product.getDescription());
			}
		}
	}

	public void displayProductInfo() throws IOException  {

		Product product = readProduct();

		System.out.println("  Description: " + product.getDescription());
		System.out.println("  Price: " + product.getPrice());
		if (product instanceof Coffee) {

			Coffee coffee = (Coffee) product;

			System.out.println("  Origin: " + coffee.getOrigin());
			System.out.println("  Roast: " + coffee.getRoast());
			System.out.println("  Flavor: " + coffee.getFlavor());
			System.out.println("  Aroma: " + coffee.getAroma());
			System.out.println("  Acidity: " + coffee.getAcidity());
			System.out.println("  Body: " + coffee.getBody());
		} else if (product instanceof Toothbrush) {

			Toothbrush brewer = (Toothbrush) product;

			System.out.println("  Brand: " + brewer.getBrand());
			System.out.println("  Hardness: " + brewer.getHardness());
			System.out.println("  Shape: " + brewer.getShape());
		}
	}

	public void displayOrder() {

		int size = currentOrder.getNumberOfItems();

		if (size == 0) {
			System.out.println("The current order is empty");
		} else {
			for (Iterator i = currentOrder.getItemsIterator(); i.hasNext();) {
				System.out.println(((OrderItem) i.next()).toString());
			}
			System.out.println("Total: " +
				CURRENCY.format(currentOrder.getTotalCost()));
		}
	}

	public void addModifyProduct()  throws IOException  {

		Product product = readProduct();
		int quantity = readQuantity();
		OrderItem orderItem =
			currentOrder.getItem(product);

		if (orderItem == null) {
			currentOrder.addItem(
				new OrderItem(product, quantity));
			System.out.println("The product " + product.getCode()
			 + " has been added");
		} else {
			orderItem.setQuantity(quantity);
			System.out.println("The quantity of the product " +
				product.getCode() + " has been modified");
		}
	}

	public void removeProduct()  throws IOException  {

		Product product = readProduct();
		OrderItem orderItem = currentOrder.getItem(product);

		if (orderItem != null) {
			currentOrder.removeItem(orderItem);
			System.out.println("The product " + product.getCode()
				 + " has been removed from the current order");
		} else {
			System.out.println(
				"There are no products in the current order with that code");
		}
	}

	public void saleOrder()  {

		if (currentOrder.getNumberOfItems() > 0) {
			sales.addOrder(currentOrder);
			currentOrder = new Order();
			System.out.println("The sale of the order has been registered");
		} else {
			System.out.println("The current order is empty");
		}
	}

	public void displayOrdersSold() {

		int numOrders = sales.getNumberOfOrders();

		if (numOrders != 0) {
			int orderNumber = 1;
			for (Iterator i = sales.getOrdersIterator(); i.hasNext(); ) {

				Order order = (Order) i.next();

				System.out.println("Order " + orderNumber++);

				for (Iterator j = order.getItemsIterator(); j.hasNext();) {
					System.out.println("   " +
					((OrderItem) j.next()).toString());
				}
				System.out.println("   Total: " +
					CURRENCY.format(order.getTotalCost()));
			}
		} else {
			System.out.println("There are no sales");
		}
	}

	public void displayNumberOfOrders(Product product) throws IOException {
		int cnt = 0;

		for(Iterator iter1 = sales.getOrdersIterator(); iter1.hasNext();){
			Order o = (Order) iter1.next();
            for(Iterator iter2 = o.getItemsIterator(); iter2.hasNext();){
				OrderItem oi = (OrderItem) iter2.next();
				Product p = oi.getProduct();
				if(p.equals(product))
					cnt++;
			}
		}

		System.out.println("Number of orders that contains the product " +
				product.getCode() + ": " + cnt);
	}

	public void displayTotalQuantityOfProducts() {
		for(Iterator iter1 = catalog.getProductsIterator(); iter1.hasNext();) {
			Product p = (Product) iter1.next();
			int num = 0;
			for (Iterator iter2 = sales.getOrdersIterator(); iter2.hasNext(); ) {
				Order o = (Order) iter2.next();
				for (Iterator iter3 = o.getItemsIterator(); iter3.hasNext(); ) {
					OrderItem oi = (OrderItem) iter3.next();
					if (oi.getProduct().equals(p))
						num += oi.getQuantity();
				}
			}
			System.out.print(p.getCode() + " " + num + "\n");
		}
	}

	private Product readProduct() throws IOException  {

		do  {
			System.out.print("Product code> ");
			System.out.flush();
			
			Product product = catalog.getProduct(stdIn.readLine());
			
			if (product != null) {

				return product;
			
			} else {
				System.out.println("There are no products with that code");
			}
		}  while (true);
	}

	private int readQuantity() throws IOException  {

		int quantity;

		do  {
			try  {

				System.out.print("Quantity> ");
				System.out.flush();
				quantity = Integer.parseInt(stdIn.readLine());
				if (quantity > 0) {

					return quantity;

				} else  {
					System.out.println(
						"Invalid input. Please enter a positive integer");
				}
			} catch (NumberFormatException  nfe)  {
				System.out.println(nfe);
			}
		}  while (true);
	}
}