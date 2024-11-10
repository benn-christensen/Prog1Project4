package gui;

import application.models.SeatType;
import application.models.controller.Controller;
import javafx.application.Application;
import storage.Storage;

import java.time.LocalDate;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        initializeStorage();
        testPrint();
        Application.launch(MainWindow.class);
    }

    private static void testPrint() {
        Storage.getShows().forEach(show -> System.out.println(show));
        Storage.getCustomers().forEach(customer -> System.out.println(customer));
        Storage.getSeats().forEach(seat -> System.out.println(seat));
    }

    private static void initializeStorage() {
        Controller.createShow("Evita", LocalDate.of(2024, 11, 23), LocalDate.of(2024, 12, 10));
        Controller.createShow("West Side Story", LocalDate.of(2025, 2, 23), LocalDate.of(2025, 3, 4));
        Controller.createShow("Chess", LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 7));

        Controller.createCustomer("Anders Hansen", "12345678");
        Controller.createCustomer("Peter Jensen", "87654321");
        Controller.createCustomer("Niels Madsen", "23456789");

        createSeats(1, 5, 3, 18, 500, SeatType.STANDARD);
        createSeats(1, 5, 1, 2, 450, SeatType.STANDARD);
        createSeats(1, 5, 19, 20, 450, SeatType.STANDARD);
        createSeats(6, 9, 3, 18, 450, SeatType.STANDARD);
        createSeats(10, 10, 3, 7, 450, SeatType.STANDARD);
        createSeats(10, 10, 8, 12, 450, SeatType.WHEELCHAIR);
        createSeats(10, 10, 13, 18, 450, SeatType.STANDARD);
        createSeats(6, 10, 1, 2, 400, SeatType.STANDARD);
        createSeats(6, 10, 19, 20, 400, SeatType.STANDARD);
        createSeats(11, 15, 1, 7, 400, SeatType.STANDARD);
        createSeats(11, 11, 8, 12, 400, SeatType.EXTRALEGROOM);
        createSeats(11, 15, 13, 20, 400, SeatType.STANDARD);
        createSeats(12, 15, 8, 12, 400, SeatType.STANDARD);

        Storage.sortSeats();
    }

    private static void createSeats(int fromRow, int toRow, int fromSeat, int toSeat, int price, SeatType type) {
        for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
            for (int seatIndex = fromSeat; seatIndex <= toSeat; seatIndex++) {
                Controller.createSeat(rowIndex, seatIndex, price, type);
            }
        }
    }
}
