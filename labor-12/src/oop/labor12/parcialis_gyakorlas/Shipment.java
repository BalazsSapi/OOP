package oop.labor12.parcialis_gyakorlas;

public class Shipment {
    private int orderId;
    private String productId;
    private int amount;

    public Shipment(int orderId, String productId, int amount) {
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "orderId=" + orderId +
                ", productId='" + productId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
