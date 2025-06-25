package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class sadapaygui extends JFrame {
    private ArrayList<SadaPayee> accounts = new ArrayList<>();
    private JComboBox<String> accountList;
    private JTextArea detailsArea;

    public sadapaygui() {
        setTitle("SadaPay Simple App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Top panel for account selection and creation
        JPanel topPanel = new JPanel();
        accountList = new JComboBox<>();
        JButton createBtn = new JButton("Create Account");
        topPanel.add(new JLabel("Accounts:"));
        topPanel.add(accountList);
        topPanel.add(createBtn);

        // Center area for details
        detailsArea = new JTextArea(10, 40);
        detailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(detailsArea);

        // Bottom panel for actions
        JPanel bottomPanel = new JPanel();
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton transferBtn = new JButton("Transfer");
        JButton showBtn = new JButton("Show Details");
        bottomPanel.add(depositBtn);
        bottomPanel.add(withdrawBtn);
        bottomPanel.add(transferBtn);
        bottomPanel.add(showBtn);

        // Add panels to frame
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Button actions
        createBtn.addActionListener(e -> createAccount());
        depositBtn.addActionListener(e -> deposit());
        withdrawBtn.addActionListener(e -> withdraw());
        transferBtn.addActionListener(e -> transfer());
        showBtn.addActionListener(e -> showDetails());

        setVisible(true);
    }

    private void createAccount() {
        JTextField name = new JTextField();
        JTextField phone = new JTextField();
        JTextField address = new JTextField();
        JTextField email = new JTextField();
        JTextField dob = new JTextField();
        JTextField balance = new JTextField();
        JTextField accNum = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Name:")); panel.add(name);
        panel.add(new JLabel("Phone (11 digits):")); panel.add(phone);
        panel.add(new JLabel("Address:")); panel.add(address);
        panel.add(new JLabel("Email:")); panel.add(email);
        panel.add(new JLabel("DOB (MM/DD/YYYY):")); panel.add(dob);
        panel.add(new JLabel("Initial Balance:")); panel.add(balance);
        panel.add(new JLabel("Account Number:")); panel.add(accNum);

        int result = JOptionPane.showConfirmDialog(this, panel, "Create Account", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Validation
            if (!phone.getText().matches("\\d{11}")) {
                JOptionPane.showMessageDialog(this, "Phone must be 11 digits.");
                return;
            }
            if (!email.getText().contains("@")) {
                JOptionPane.showMessageDialog(this, "Invalid email.");
                return;
            }
            if (!dob.getText().matches("^(0[1-9]|1[0-2])/([0-2][0-9]|3[01])/\\d{4}$")) {
                JOptionPane.showMessageDialog(this, "DOB must be MM/DD/YYYY.");
                return;
            }
            int bal, acc;
            try {
                bal = Integer.parseInt(balance.getText());
                acc = Integer.parseInt(accNum.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Balance and Account Number must be numbers.");
                return;
            }
            SadaPayee accObj = new SadaPayee(bal, name.getText(), acc, address.getText(), email.getText(), phone.getText(), dob.getText());
            accounts.add(accObj);
            accountList.addItem(name.getText());
            accountList.setSelectedIndex(accounts.size() - 1);
            showDetails();
        }
    }

    private SadaPayee getCurrentAccount() {
        int idx = accountList.getSelectedIndex();
        if (idx >= 0 && idx < accounts.size()) return accounts.get(idx);
        return null;
    }

    private void deposit() {
        SadaPayee acc = getCurrentAccount();
        if (acc == null) return;
        String input = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
        try {
            int amt = Integer.parseInt(input);
            acc.depositMoney(amt);
            showDetails();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount.");
        }
    }

    private void withdraw() {
        SadaPayee acc = getCurrentAccount();
        if (acc == null) return;
        String input = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
        try {
            int amt = Integer.parseInt(input);
            if (!acc.withdraw(amt)) {
                JOptionPane.showMessageDialog(this, "You don't have enough money for that withdrawal request.");
            } else {
                showDetails();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount.");
        }
    }

    private void transfer() {
        SadaPayee acc = getCurrentAccount();
        if (acc == null) return;
        if (accounts.size() < 2) {
            JOptionPane.showMessageDialog(this, "No other accounts available to transfer to.");
            return;
        }
        JOptionPane.showMessageDialog(this, "Select recipient account:");
        StringBuilder options = new StringBuilder();
        for (int i = 0; i < accounts.size(); i++) {
            if (i != accountList.getSelectedIndex()) {
                options.append(i + 1).append(". ").append(accounts.get(i).getAccountName()).append("\n");
            }
        }
        String recipientStr = JOptionPane.showInputDialog(this, options.toString());
        int recipientIdx;
        try {
            recipientIdx = Integer.parseInt(recipientStr) - 1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
            return;
        }
        if (recipientIdx == accountList.getSelectedIndex() || recipientIdx < 0 || recipientIdx >= accounts.size()) {
            JOptionPane.showMessageDialog(this, "Invalid selection.");
            return;
        }
        SadaPayee recipient = accounts.get(recipientIdx);
        String transferAmountStr = JOptionPane.showInputDialog(this, "Enter amount to transfer:");
        int transferAmount;
        try {
            transferAmount = Integer.parseInt(transferAmountStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount.");
            return;
        }
        if (transferAmount > acc.getBalance()) {
            JOptionPane.showMessageDialog(this, "You don't have enough money for that transfer request.");
        } else {
            acc.withdraw(transferAmount);
            recipient.depositMoney(transferAmount);
            showDetails();
        }
    }

    private void showDetails() {
        SadaPayee acc = getCurrentAccount();
        if (acc == null) {
            detailsArea.setText("No account selected.");
            return;
        }
        detailsArea.setText(acc.details());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(sadapaygui   ::new);
    }
}

// Minimal SadaPay class for GUI
class SadaPayee {           
    private int balance;
    private String accountName, address, email, phoneNumber, birth;
    private int accountNumber;

    public SadaPayee(int balance, String accountName, int accountNumber, String address, String email, String phoneNumber, String birth) {
        this.balance = balance;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
    }

    public void depositMoney(int amt) { balance += amt; }
    public boolean withdraw(int amount) {
        if (amount > balance) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
    public void transfer(String phone, int amt) { if (amt <= balance) balance -= amt; }

    public String details() {
        return "Name: " + accountName +
                "\nAccount #: " + accountNumber +
                "\nBalance: " + balance +
                "\nPhone: " + phoneNumber +
                "\nEmail: " + email +
                "\nAddress: " + address +
                "\nDOB: " + birth;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountName() {
        return accountName;
    }
}