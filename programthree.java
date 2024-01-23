import java.util.Scanner;

class Account {
    private double bal;

    public Account(double bal) {
        this.bal = bal;
    }

    public double getBal() {
        return bal;
    }

    public void deposit(double amt) {
        bal += amt;
    }

    public boolean withdraw(double amt) {
        if (amt > bal) {
            System.out.println("Insufficient funds");
            return false;
        } else {
            bal -= amt;
            return true;
        }
    }
}

class Machine {
    private Account acc;

    public Machine(Account acc) {
        this.acc = acc;
    }

    public void showMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void process(int opt, Scanner sc) {
        switch (opt) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double wamt = sc.nextDouble();
                if (acc.withdraw(wamt)) {
                    System.out.println("Withdrawal successful");
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double damt = sc.nextDouble();
                acc.deposit(damt);
                System.out.println("Deposit successful");
                break;
            case 3:
                System.out.println("Current balance: " + acc.getBal());
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}

public class programthree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        double ibal = sc.nextDouble();
        Account acc = new Account(ibal);
        Machine mac = new Machine(acc);
        while (true) {
            mac.showMenu();
            System.out.print("Choose an option (1-4): ");
            int opt = sc.nextInt();
            mac.process(opt, sc);
        }
    }
}
