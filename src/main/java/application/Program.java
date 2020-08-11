package application;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Birth Date: ");
        String birthDate = sc.nextLine();

        System.out.println("Enter order data");
        System.out.println("Status: ");
        String status = sc.nextLine();
        Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, sdf.parse(birthDate)));

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        for(int i = 1; i<= n; i++) {
            System.out.println("Enter #" + i + " data:");
            System.out.println("Product name: ");
            String productName = sc.nextLine();
            System.out.println("Product Price: ");
            Double price = sc.nextDouble();
            System.out.println("Quantity: ");
            int quantity = sc.nextInt();
            OrderItem orderItem = new OrderItem(quantity, price, new Product(productName, price));
        }

        System.out.println("ORDER SUMMARY:");
        System.out.println("Order moment: " + order.getMoment());
        System.out.println("Order Status: " + order.getOrder());
        System.out.println("Client: " + order.getClient().getName() + " - " + order.getClient().getEmail());


        sc.close();
    }

}
