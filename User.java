enum UserType { PRIVATE_INVESTOR, INSTITUTIONAL_INVESTOR }

class User implements Observer {
    private String name;
    private UserType type;
    private List<String> channels; // "EMAIL", "SMS", "PUSH"

    public User(String name, UserType type, List<String> channels) {
        this.name = name;
        this.type = type;
        this.channels = channels;
    }

    @Override
    public void update(MarketEvent event) {
        
        if (type == UserType.PRIVATE_INVESTOR && event instanceof MarketAlertEvent) {
            return; 
        }

        sendNotification(event);
    }

    private void sendNotification(MarketEvent event) {
        for (String channel : channels) {
            switch (channel.toUpperCase()) {
                case "EMAIL":
                    System.out.println("[EMAIL] " + name + " получил: " + event.getInfo());
                    break;
                case "SMS":
                    System.out.println("[SMS] " + name + " получил: " + event.getInfo());
                    break;
                case "PUSH":
                    System.out.println("[PUSH] " + name + " получил: " + event.getInfo());
                    break;
            }
        }
    }
}