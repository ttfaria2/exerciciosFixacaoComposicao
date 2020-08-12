package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus order;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(Date moment, OrderStatus order, Client client) {
        this.moment = moment;
        this.order = order;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getOrder() {
        return order;
    }

    public void setOrder(OrderStatus order) {
        this.order = order;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        double total = 0;
        for (OrderItem i : items) {
            total += i.subTotal();
        } return total;
    }

    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append("\n");
        stb.append("ORDER SUMMARY: \n");
        stb.append("Order moment: " + getMoment() + "\n");
        stb.append("Order Status: " + getOrder() + "\n");
        stb.append("Client: " + getClient().getName()
                + " (" + client.getBirthDate() + ") "
                + " - " + getClient().getEmail() + "\n");
        stb.append("Order Items: \n");
        for(OrderItem i : items) {
            stb.append(i.getProduct().getName());
            stb.append(", $" + i.getPrice());
            stb.append(", Quantity: " + i.getQuantity());
            stb.append(", Subtotal: $" + i.subTotal() + "\n");
        } return stb.toString() + "\n" + "Total Price: $" + total();
    }
}
