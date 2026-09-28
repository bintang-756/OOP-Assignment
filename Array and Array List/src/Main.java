import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        // data awal
        bank.addCustomer("Ahmad", "Rozan");
        bank.addCustomer("Bintang", "Aqra");
        bank.addCustomer("Mh", "Yushran");
        bank.getCustomer(0).setAccount(new Account(500000));
        bank.getCustomer(1).setAccount(new Account(1200000));
        bank.getCustomer(2).setAccount(new Account(750000));

        int choice;
        do {
            System.out.println("*********************************");
            System.out.println("              BANK");
            System.out.println("*********************************");
            System.out.println("[1] Add Account");
            System.out.println("[2] Withdraw");
            System.out.println("[3] Deposit");
            System.out.println("[4] Customers List");
            System.out.println("[0] Exit");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice > ");
            choice = input.nextInt();
            input.nextLine();
            System.out.println();

            switch (choice) {
                case 1: // Add Account (customer baru + account)
                    System.out.print("First name : ");
                    String first = input.nextLine();
                    System.out.print("Last name : ");
                    String last = input.nextLine();
                    System.out.print("Initial balance : Rp ");
                    double init = input.nextDouble();

                    bank.addCustomer(first, last);
                    bank.getCustomer(bank.getNumOfCustomers() - 1).setAccount(new Account(init));
                    System.out.println("Account added.");
                    break;

                case 2: // Withdraw
                    for (int i = 0; i < bank.getNumOfCustomers(); i++) {
                        System.out.println("[" + (i + 1) + "] " + bank.getCustomer(i).getFirstName() + " " + bank.getCustomer(i).getLastName());
                    }
                    System.out.print("Choose customer number : ");
                    Customer cWd = bank.getCustomer(input.nextInt() - 1);

                    System.out.print("Amount to withdraw : Rp ");
                    if (cWd.getAccount().withdraw(input.nextDouble())) {
                        System.out.println("Withdraw success.");
                    } else {
                        System.out.println("Withdraw failed.");
                    }
                    System.out.println("Current balance : Rp " + cWd.getAccount().getBalance());
                    break;

                case 3: // Deposit
                    for (int i = 0; i < bank.getNumOfCustomers(); i++) {
                        System.out.println("[" + (i + 1) + "] " + bank.getCustomer(i).getFirstName()
                                + " " + bank.getCustomer(i).getLastName());
                    }
                    System.out.print("Choose customer number : ");
                    Customer cDep = bank.getCustomer(input.nextInt() - 1);

                    System.out.print("Amount to deposit : Rp ");
                    if (cDep.getAccount().deposit(input.nextDouble())) {
                        System.out.println("Deposit success.");
                    } else {
                        System.out.println("Deposit failed.");
                    }
                    System.out.println("Current balance : Rp " + cDep.getAccount().getBalance());
                    break;

                case 4: 
                    for (int i = 0; i < bank.getNumOfCustomers(); i++) {
                        Customer cust = bank.getCustomer(i);
                        System.out.println("[" + (i + 1) + "] " + cust.getFirstName() + " "
                                + cust.getLastName() + " - Rp " + cust.getAccount().getBalance());
                    }
                    break;

                case 0:
                    System.out.println("Thank you.");
                    break;
            }
            System.out.println();
        } while (choice != 0);

        input.close();
    }
}