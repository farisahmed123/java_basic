package com.example;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class SadaPay {
    private int balance;
    private String accountName;
    private int accountNumber;
    private String phoneNumber;
    private String birth;
    private String email;
    private String address;

    public SadaPay(int balance, String accountName, int accountNumber, String address, String email, String phoneNumber, String birth) {
        this.balance = balance;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.email = email;
        this.address = address;
    }

    public void depositMoney(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        int amount = Integer.parseInt(sc.nextLine());
        balance += amount;
        System.out.println("Money deposited successfully.\n");
    }

    public void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        int amount = Integer.parseInt(sc.nextLine());
        if (amount > balance) {
            System.out.println("Cannot withdraw money. Insufficient balance.\n");
        } else {
            balance -= amount;
            System.out.println("Withdraw successful.\n");
        }
    }

    public void transfer(Scanner sc) {
        System.out.print("Enter recipient phone number: ");
        String number = sc.nextLine();
        System.out.print("Enter amount to transfer: ");
        int amount = Integer.parseInt(sc.nextLine());
        if (amount > balance) {
            System.out.println("Transfer failed. Insufficient balance.\n");
        } else {
            balance -= amount;
            System.out.println("Money transferred to number: " + number + "\n");
        }
    }

    public void updateName(Scanner sc) {
        System.out.print("Enter new account name: ");
        accountName = sc.nextLine();
        System.out.println("Name updated.\n");
    }

    public void updateBalance(Scanner sc) {
        System.out.print("Enter new balance: ");
        balance = Integer.parseInt(sc.nextLine());
        System.out.println("Balance updated.\n");
    }

    public void updateAccountNumber(Scanner sc) {
        System.out.print("Enter new account number: ");
        accountNumber = Integer.parseInt(sc.nextLine());
        System.out.println("Account number updated.\n");
    }

    public void displayBalance() {
        System.out.println("Your current balance: " + balance + "\n");
    }

    public void display() {
        System.out.println("Account Holder Name: " + accountName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: " + balance);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Birth Date: " + birth + "\n");
    }

    public void more(Scanner sc) {
        int inp;
        do {
            System.out.println("1. Rewards");
            System.out.println("2. Info");
            System.out.println("0. Exit");
            System.out.print("Enter your option: ");
            inp = Integer.parseInt(sc.nextLine());
            System.out.println();

            if (inp == 1) {
                int input;
                do {
                    System.out.println("1. Golden Ticket");
                    System.out.println("2. Invite Friends");
                    System.out.println("0. Exit");
                    System.out.print("Enter your option: ");
                    input = Integer.parseInt(sc.nextLine());
                    System.out.println();

                    if (input == 1) {
                        System.out.print("Press 1 for Golden Ticket: ");
                        int ticket = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter code HCSNSND to confirm Golden Ticket: ");
                        String code = sc.nextLine();
                        if (code.equals("HCSNSND")) {
                            System.out.println("Golden Ticket Activated\n");
                        } else {
                            System.out.println("Golden Ticket Failed\n");
                        }
                    }
                    if (input == 2) {
                        System.out.println("Advantage of Invite Friends:");
                        System.out.println("1. Speed Up Your SadaPay Account");
                        System.out.println("2. Fast Transaction");
                        System.out.println("3. No Lag Issue\n");
                        System.out.print("Press 1 to invite your friends: ");
                        int inpt = Integer.parseInt(sc.nextLine());
                        if (inpt == 1) {
                            System.out.print("Enter name of your invited friend: ");
                            String name = sc.nextLine();
                            System.out.print("Enter phone number of your friend: ");
                            String phnNo = sc.nextLine();
                            System.out.println("Invitation Done\n");
                        }
                    }
                } while (input != 0);
            }

            if (inp == 2) {
                int inputt;
                do {
                    System.out.println("1. For Information");
                    System.out.println("2. Terms And Condition");
                    System.out.println("3. Schedule Of Charges");
                    System.out.println("0. Exit");
                    System.out.print("Enter your option: ");
                    inputt = Integer.parseInt(sc.nextLine());
                    if (inputt == 1) {
                        System.out.println("\n-> Your Name, Phone number, email, address, date of Birth and other information provided when you create your Account");
                        System.out.println("-> You Can Deposit, Withdraw, Get Debit Card, Easy Shopping, Easy Transaction through SadaPay");
                        System.out.println("-> Data processors to process your information on our behalf");
                        System.out.println("-> Third party services whom you have asked us to integrate with, such as Social Network");
                        System.out.println("-> Head office of SadaPay: Ufone Tower 9th floor Blue area, Islamabad");
                        System.out.println("-> SadaPay Lahore Office: Naveena Tower 6th Floor 35C Gulberg\n");
                    }
                    if (inputt == 2) {
                        System.out.println("\nMAKING PAYMENTS");
                        System.out.println("-> Your instructions are unclear");
                        System.out.println("-> We suspect fraud or criminal activity on your account");
                        System.out.println("-> We're not allowed to make the transfer by law\n");
                        System.out.println("IF SOMETHING GOES WRONG");
                        System.out.println("-> It was taken after you froze your card");
                        System.out.println("-> Any money you lost due to our mistakes will be returned");
                        System.out.println("-> We are available 24 hours for you\n");
                    }
                    if (inputt == 3) {
                        System.out.println("\t\tCharges are not inclusive of tax (FED), unless otherwise stated\n");
                        System.out.println("GENERAL");
                        System.out.println("-> Account Opening Charges ------------------- None");
                        System.out.println("-> Monthly Charges --------------------------- None");
                        System.out.println("-> Annual Charges ---------------------------- None");
                        System.out.println("-> Mobile Banking Fees ----------------------- None");
                        System.out.println("-> SMS Fees ---------------------------------- None\n");
                        System.out.println("DEBIT CARD");
                        System.out.println("-> MasterCard Issuance ----------------------- Rs. 895 (one time)");
                        System.out.println("-> MasterCard Replacement cost --------------- Rs. 895");
                        System.out.println("-> PayPak fee -------------------------------- Rs. 1200 (annually)");
                        System.out.println("-> PayPak Replacement fee -------------------- Rs. 1200\n");
                    }
                } while (inputt != 0);
            }
        } while (inp != 0);
    }

    public String getAccountName() {
        return accountName;
    }
}

public class SadaPayApp {
    public static String promptDateOfBirth(Scanner sc) {
        String birth;
        while (true) {
            System.out.print("Enter your date of birth (MM/DD/YYYY): ");
            birth = sc.nextLine();
            if (birth.matches("^(0[1-9]|1[0-2])/([0-2][0-9]|3[01])/\\d{4}$")) {
                break;
            } else {
                System.out.println("Invalid date format. Please use MM/DD/YYYY.");
            }
        }
        return birth;
    }

    public static String promptPhoneNumber(Scanner sc) {
        String phoneNumber;
        while (true) {
            System.out.print("Enter your phone number (11 digits): ");
            phoneNumber = sc.nextLine();
            if (phoneNumber.matches("\\d{11}")) {
                break;
            } else {
                System.out.println("Invalid phone number. Please enter exactly 11 digits.");
            }
        }
        return phoneNumber;
    }

    public static String promptEmail(Scanner sc) {
        String email;
        while (true) {
            System.out.print("Enter your email: ");
            email = sc.nextLine();
            if (email.contains("@")) {
                break;
            } else {
                System.out.println("Invalid email. Email must contain '@'.");
            }
        }
        return email;
    }

    public static SadaPay createAccount(Scanner sc) {
        System.out.print("Enter your SadaPay account name: ");
        String accountName = sc.nextLine();

        String phoneNumber = promptPhoneNumber(sc);

        System.out.print("Enter your address: ");
        String address = sc.nextLine();

        String email = promptEmail(sc);

        String birth = promptDateOfBirth(sc);

        System.out.print("Enter your initial money in SadaPay: ");
        int balance = Integer.parseInt(sc.nextLine());

        System.out.print("Enter your account number: ");
        int accountNumber = Integer.parseInt(sc.nextLine());

        System.out.print("Enter your code: ");
        String code = sc.nextLine();

        String confirmCode;
        do {
            System.out.print("Re-enter your code for confirmation: ");
            confirmCode = sc.nextLine();
        } while (!code.equals(confirmCode));

        System.out.println("\n----- SadaPay Account Created -----\n");

        return new SadaPay(balance, accountName, accountNumber, address, email, phoneNumber, birth);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<SadaPay> accounts = new ArrayList<>();
        int currentAccountIndex = -1;

        System.out.println("--------- WELCOME TO SADAPAY ACCOUNT ---------\n");
        System.out.println("Create SadaPay Account\n");

        System.out.print("Enter your SadaPay account name: ");
        String accountName = sc.nextLine();

        String phoneNumber = promptPhoneNumber(sc);

        System.out.print("Enter your address: ");
        String address = sc.nextLine();

        String email = promptEmail(sc);

        String birth = promptDateOfBirth(sc);

        System.out.print("Enter your initial money in SadaPay: ");
        int balance = Integer.parseInt(sc.nextLine());

        System.out.print("Enter your account number: ");
        int accountNumber = Integer.parseInt(sc.nextLine());

        sc.nextLine(); // consume newline
        System.out.print("Enter your code: ");
        String code = sc.nextLine();

        String confirmCode;
        do {
            System.out.print("Re-enter your code for confirmation: ");
            confirmCode = sc.nextLine();
        } while (!code.equals(confirmCode));

        System.out.println("\n----- SadaPay Account Created -----\n");

        accounts.add(new SadaPay(balance, accountName, accountNumber, address, email, phoneNumber, birth));
        currentAccountIndex = accounts.size() - 1;

        while (true) {
            System.out.println("1. Create New Account");
            System.out.println("2. Switch Account");
            System.out.println("3. Account Operations");
            System.out.println("0. Exit");
            System.out.print("Enter your option: ");
            String mainOptionStr = sc.nextLine();
            int mainOption = 0;
            try {
                mainOption = Integer.parseInt(mainOptionStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.\n");
                continue;
            }

            if (mainOption == 1) {
                SadaPay newAccount = createAccount(sc);
                accounts.add(newAccount);
                currentAccountIndex = accounts.size() - 1;
            } else if (mainOption == 2) {
                if (accounts.isEmpty()) {
                    System.out.println("No accounts available. Create one first.\n");
                } else {
                    System.out.println("Available Accounts:");
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println((i + 1) + ". " + accounts.get(i).getAccountName());
                    }
                    System.out.print("Select account number: ");
                    String idxStr = sc.nextLine();
                    int idx = -1;
                    try {
                        idx = Integer.parseInt(idxStr) - 1;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.\n");
                        continue;
                    }
                    if (idx >= 0 && idx < accounts.size()) {
                        currentAccountIndex = idx;
                        System.out.println("Switched to account: " + accounts.get(currentAccountIndex).getAccountName() + "\n");
                    } else {
                        System.out.println("Invalid selection.\n");
                    }
                }
            } else if (mainOption == 3) {
                if (currentAccountIndex == -1) {
                    System.out.println("No account selected. Create or switch to an account first.\n");
                } else {
                    SadaPay account = accounts.get(currentAccountIndex);
                    int input = 0;
                    do {
                        System.out.println("1. Deposit Money");
                        System.out.println("2. Withdraw Money");
                        System.out.println("3. Detail Account");
                        System.out.println("4. Update Account Name");
                        System.out.println("5. Update Account Balance");
                        System.out.println("6. Update Account Number");
                        System.out.println("7. Check Current Balance");
                        System.out.println("8. Money Transfer");
                        System.out.println("9. More Options");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your option: ");
                        String inputStr = sc.nextLine();
                        try {
                            input = Integer.parseInt(inputStr);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input.\n");
                            continue;
                        }
                        System.out.println();
                        switch (input) {
                            case 1: account.depositMoney(sc); break;
                            case 2: account.withdraw(sc); break;
                            case 3: account.display(); break;
                            case 4: account.updateName(sc); break;
                            case 5: account.updateBalance(sc); break;
                            case 6: account.updateAccountNumber(sc); break;
                            case 7: account.displayBalance(); break;
                            case 8: account.transfer(sc); break;
                            case 9: account.more(sc); break;
                            case 0: System.out.println("Returning to main menu.\n"); break;
                            default: System.out.println("Invalid option.\n");
                        }
                    } while (input != 0);
                }
            } else if (mainOption == 0) {
                System.out.println("Allah Hafiz\n");
                break;
            } else {
                System.out.println("Invalid option.\n");
            }
        }
        sc.close();
    }
}