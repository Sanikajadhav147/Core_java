import java.util.Scanner;

class Order {
    int id;
    String customer;
    String product;
    int quantity;
    String status;
}

public class OrderTracker {
    Order orders[] = new Order[100];
    int count = 0;

    public void placeOrder(Scanner sc) {
        Order o = new Order();

        System.out.print("Enter Order ID: ");
        o.id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        o.customer = sc.nextLine();

        System.out.print("Enter Product Name: ");
        o.product = sc.nextLine();

        System.out.print("Enter Quantity: ");
        o.quantity = sc.nextInt();
        sc.nextLine();

        o.status = "Pending"; 
        orders[count] = o;
        count++;
        System.out.println("Order Placed Successfully! (Status: Pending)\n");
    }

    public void viewOrders() {
        if (count == 0) {
            System.out.println("No orders placed yet.\n");
            return;
        }

        System.out.println("\n--- Order List ---");
        for (int i = 0; i < count; i++) {
            System.out.println("Order ID: " + orders[i].id +"\n" +
                               "Customer: " + orders[i].customer +"\n" +
                               "Product: " + orders[i].product +"\n" +
                               "Quantity: " + orders[i].quantity +"\n" +
                               "Status: " + orders[i].status);
        }
        System.out.println();
    }

    public void updateStatus(Scanner sc) {
        System.out.print("Enter Order ID to Update Status: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (orders[i].id == id) {
                System.out.print("Enter New Product: ");
                orders[i].product = sc.nextLine();
                System.out.println("Order Status Updated!\n");
                return;
            }
        }
        System.out.println("Order ID not found.\n");
    }

    public void cancelOrder(Scanner sc) {
        System.out.print("Enter Order ID to Cancel: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (orders[i].id == id) {
                for (int j = i; j < count - 1; j++) {
                    orders[j] = orders[j + 1];
                }
                count--;
                System.out.println("Order Cancelled!\n");
                return;
            }
        }
        System.out.println("Order ID not found.\n");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== Online Order Tracker =====");
            System.out.println("1. Place Order");
            System.out.println("2. View Orders");
            System.out.println("3. Update Order Status");
            System.out.println("4. Cancel Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: placeOrder(sc); break;
                case 2: viewOrders(); break;
                case 3: updateStatus(sc); break;
                case 4: cancelOrder(sc); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid Choice\n");
            }
        } while (choice != 5);

        sc.close();
    }

    public static void main(String[] args) {
        OrderTracker ot = new OrderTracker();
        ot.run();
    }
}
