package oop.labor12.parcialis_gyakorlas;

public class Order {
    private int orderId;
    private int clientId;
    private String productId;
    private int amount;

    public Order(int orderId, int clientId, String productId, int amount) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.productId = productId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", clientId=" + clientId +
                ", productId='" + productId + '\'' +
                ", amount=" + amount +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public String getProductId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }

    public void shipAmount(int amount){
        this.amount-=amount;
    }
}
