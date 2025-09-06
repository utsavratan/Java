# 💳 Banking Application for Account Management  

A simple **Banking Application in Java** that allows users to manage their bank accounts.  
This project demonstrates **Object-Oriented Programming (OOP)** concepts, control structures, arrays, and string handling in Java.  

---

## 🚀 Features
- Create new bank accounts  
- Deposit money  
- Withdraw money  
- View account details  
- Update email & phone number  
- Menu-driven console interface  

---

## 🏗️ Project Structure
- **Account Class** → Defines account details and operations (deposit, withdraw, update, display).  
- **UserInterface Class** → Provides menu-driven interaction and manages multiple accounts using arrays.  

---

## ⚙️ Technologies Used
- **Java (Core Java)**  
- **OOP Principles** (Encapsulation, Classes & Objects)  
- **Arrays & Strings**  
- **Control Structures** (if-else, switch, loops)  
- **Scanner Class** for input  

---

## 📊 UML Class Diagram

```mermaid
classDiagram
    class Account {
        - int accountNumber
        - String accountHolderName
        - double balance
        - String email
        - String phoneNumber
        + Account(int, String, double, String, String)
        + deposit(double)
        + withdraw(double)
        + displayAccountDetails()
        + updateContactDetails(String, String)
        + getAccountNumber() int
    }

    class UserInterface {
        - Account[] accounts
        - int accountCount
        - Scanner scanner
        + UserInterface()
        + createAccount()
        + performDeposit()
        + performWithdrawal()
        + showAccountDetails()
        + updateContact()
        + mainMenu()
        + main(String[]) static
    }

    UserInterface "1" --> "*" Account
