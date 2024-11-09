package application.models;

public class Seat {
    private int rowNumber;
    private int seatNumber;
    private int price;
    private SeatType type;

    public Seat(int rowNumber, int seatNumber, int price, SeatType type) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.price = price;
        this.type = type;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getPrice() {
        return price;
    }

    public SeatType getType() {
        return type;
    }
}
