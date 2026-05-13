import java.util.Map;

abstract class MarketEvent {
    protected String assetName;
    protected String message;

    public MarketEvent(String assetName, String message) {
        this.assetName = assetName;
        this.message = message;
    }

    public String getInfo() {
        return "[" + this.getClass().getSimpleName() + "] " + assetName + ": " + message;
    }
}

class PriceChangeEvent extends MarketEvent {
    public PriceChangeEvent(String asset, double newPrice) {
        super(asset, "Новая цена: " + newPrice);
    }
}

class ThresholdEvent extends MarketEvent {
    public ThresholdEvent(String asset, String action) {
        super(asset, "Достигнут порог! Рекомендуемое действие: " + action);
    }
}

class MarketAlertEvent extends MarketEvent {
    public MarketAlertEvent(String description) {
        super("MARKET", "Системное оповещение: " + description);
    }
}

class DividendEvent extends MarketEvent {
    public DividendEvent(String asset, double amount) {
        super(asset, "Начислены дивиденды: " + amount);
    }
}