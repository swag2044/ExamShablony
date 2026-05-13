import java.util.ArrayList;
import java.util.List;

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(MarketEvent event);
}

class MarketAsset implements Subject {
    private String name;
    private List<Observer> observers = new ArrayList<>();

    public MarketAsset(String name) {
        this.name = name;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(MarketEvent event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}