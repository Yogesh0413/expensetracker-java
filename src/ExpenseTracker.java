import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Expense Tracker Menu ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. Search Expenses by Category");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addExpense(); break;
                case 2: viewExpenses(); break;
                case 3: viewTotal(); break;
                case 4: searchByCategory(); break;
                case 5: System.out.println("Goodbye!"); System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void addExpense() {
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // consume newline
        System.out.print("Enter category (Food, Travel, Shopping, etc.): ");
        String category = sc.nextLine();
        System.out.print("Enter description: ");
        String description = sc.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        expenses.add(new Expense(amount, category, description, date));
        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (Expense e : expenses) {
                System.out.println(e);
            }
        }
    }

    private static void viewTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        System.out.println("Total Expenses: $" + total);
    }

    private static void searchByCategory() {
        System.out.print("Enter category to search(Food, Travel, Shopping, etc.): ");
        String searchCategory = sc.nextLine();

        expenses.stream()
                .filter(e -> e.getCategory().equalsIgnoreCase(searchCategory))
                .forEach(System.out::println);
    }

}
