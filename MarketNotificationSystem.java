import java.util.Arrays;

public class MarketNotificationSystem {
    public static void main(String[] args) {
        
        MarketAsset appleStock = new MarketAsset("Apple (AAPL)");
        MarketAsset btc = new MarketAsset("Bitcoin");

     
        User investor1 = new User("Иван", UserType.PRIVATE_INVESTOR, Arrays.asList("SMS", "PUSH"));
        User investor2 = new User("Фонд Сороса", UserType.INSTITUTIONAL_INVESTOR, Arrays.asList("EMAIL"));

       
        appleStock.attach(investor1);
        appleStock.attach(investor2);
        btc.attach(investor1);

       
        System.out.println("--- Изменение цены Apple ---");
        appleStock.notifyObservers(new PriceChangeEvent("AAPL", 185.50));

        System.out.println("\n--- Достижение порога по Bitcoin ---");
        btc.notifyObservers(new ThresholdEvent("BTC", "SELL (Продажа)"));

        System.out.println("\n--- Общий рыночный алерт ---");
       
        appleStock.notifyObservers(new MarketAlertEvent("Падение индекса S&P 500 на 6%"));

        
        System.out.println("\n--- Иван отписывается от Apple ---");
        appleStock.detach(investor1);
        
        appleStock.notifyObservers(new DividendEvent("AAPL", 0.24));
    }
}