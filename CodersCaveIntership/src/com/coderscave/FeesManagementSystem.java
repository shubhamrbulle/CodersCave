package com.coderscave;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String studentId;
    private String studentName;
    private double totalFees;
    private double feesPaid;

    public Student(String Id, String Name, double totalFees) {
        this.studentId = Id;
        this.studentName = Name;
        this.totalFees = totalFees;
        this.feesPaid = 0;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public double calculateBalance() {
        return totalFees - feesPaid;
    }

    public void makePayment(double amount) {
        if (amount > 0) {
            feesPaid += amount;
            //feesPaid =feesPaid+amount;
            System.out.println("Payment of " + amount + " received. Total fees paid: " + feesPaid);
        } 
        else {
            System.out.println("Invalid payment amount.");
        }
    }
}

public class FeesManagementSystem {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\tFees Management System\n");

        while (true) {
            System.out.println("Press 1. Add Student");
            System.out.println("Press 2. Make Payment");
            System.out.println("Press 3. Check Balance");
            System.out.println("Press 4. Exit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    makePayment(sc);
                    break;
                case 3:
                    checkBalance(sc);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();

        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter total fees: ");
        double totalFees = sc.nextDouble();
        sc.nextLine(); // Consume newline character

        Student student = new Student(studentId, studentName, totalFees);
        students.add(student);

        System.out.println("Student added successfully.");
    }

    private static void makePayment(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();

        Student foundStudent = null;

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent != null) {
            System.out.print("Enter payment amount: ");
            double paymentAmount = sc.nextDouble();
            sc.nextLine(); // Consume newline character
            foundStudent.makePayment(paymentAmount);
        } 
        else {
            System.out.println("Student not found. Please check the student ID.");
        }
    }

    private static void checkBalance(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();

        Student foundStudent = null;

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent != null) {
            double balance = foundStudent.calculateBalance();
            System.out.println("Student Name: " + foundStudent.getStudentName());
            System.out.println("Total Fees: " + foundStudent.getTotalFees());
            System.out.println("Fees Paid: " + foundStudent.getFeesPaid());
            System.out.println("Balance: " + balance);
        } 
        else {
            System.out.println("Student not found. Please check the student ID.");
        }
    }
}
