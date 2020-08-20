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
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth Date: ");
        String birthDate = sc.nextLine(); // add Date  parse aqui

        System.out.println("Enter order data");
        System.out.print("Status: ");
        String status = sc.nextLine(); //ler na forma de OrderStatus usar valueOff

        Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, sdf.parse(birthDate)));

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        for(int i = 1; i<= n; i++) {
            System.out.println("Enter #" + i + " data:");
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product Price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, price, new Product(productName, price));
            order.addItem(orderItem);
        }

        System.out.println(order);

        sc.close();
    }
}
