import java.util.Arrays;
import java.util.List;

public class PriceCheck {

    public void run() {
        List<String> products = Arrays.asList("chocolate", "cheese", "tomato");
        List<Float> productPrices = Arrays.asList(15.0, 300.90, 23.44);
        List<String> productSold = Arrays.asList("cheese", "tomato", "chocolate");
        List<Float> soldPrice = Arrays.asList(300.90, 23.44, 10);
    }
    public static void main(String[] args) {
        new PriceCheck().run();
    }
}
