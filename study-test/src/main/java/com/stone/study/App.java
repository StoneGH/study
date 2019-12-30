package com.stone.study;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class Customer {
    private int arrivalTime, departureTime;

    public Customer(int arrives) {
        departureTime = 0;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int totalTime() {
        return departureTime - arrivalTime;
    }
}

class TicketCounter {
    final static int PROCESS = 120;
    final static int MAX_CASHIERS = 10;
    final static int NUM_CUSTOMERS = 100;

    public static void main(String[] args) {
        Customer customer;
        Queue<Customer> customerQueue = new LinkedList<Customer>();
        int[] cashierTime = new int[MAX_CASHIERS];
        int totalTime = 0, averageTime = 0, departs = 0, start = 0;
        for (int cashiers = 0; cashiers < MAX_CASHIERS; cashiers++) {
            for (int count = 0; count < cashiers; count++) {
                cashierTime[count] = 0;
            }
            for (int count = 0; count < NUM_CUSTOMERS; count++) {
                customerQueue.add(new Customer(count * 15));
            }
            totalTime = 0;

            while (!customerQueue.isEmpty()) {
                for (int count = 0; count <= cashiers; count++) {
                    if (!customerQueue.isEmpty()) {
                        customer = customerQueue.remove();
                        if (customer.getArrivalTime() > cashierTime[count]) {
                            start = customer.getArrivalTime();
                        } else {
                            start = cashierTime[count];
                        }
                        departs = start + PROCESS;
                        customer.setDepartureTime(departs);
                        cashierTime[count] = departs;
                        totalTime += customer.totalTime();
                    }
                }
            }
            averageTime = totalTime / NUM_CUSTOMERS;
            System.out.println(cashiers + 1);
            System.out.println(averageTime);
        }
    }
}