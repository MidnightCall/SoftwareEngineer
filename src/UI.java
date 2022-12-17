import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName UI
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2022/12/5 12:18
 * @Version
 */

public class UI {
    private static BufferedReader stdIn =
            new  BufferedReader(new InputStreamReader(System.in));
    public int getChoice() throws IOException {

        int  input;

        do  {
            try  {
                System.out.println();
                System.out.print(
                        "[0] Quit\n"
                                + "[1] Display catalog\n"
                                + "[2] Display product\n"
                                + "[3] Display current order\n"
                                + "[4] Add|modify product to|in current order\n"
                                + "[5] Remove product from current order\n"
                                + "[6] Register sale of current order\n"
                                + "[7] Display sales\n"
                                + "[8] Display number of orders with a specific product\n"
                                + "[9] Display the total quantity sold for each product\n"
                                + "choice> ");

                input = Integer.parseInt(stdIn.readLine());

                System.out.println();

                if (0 <= input && 9 >= input)  {
                    break;
                } else {
                    System.out.println("Invalid choice:  " + input);
                }
            } catch (NumberFormatException  nfe)  {
                System.out.println(nfe);
            }
        }  while (true);

        return  input;
    }
}
