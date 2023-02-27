package cinema.domainmodel;

import java.util.UUID;

public class Seat {
    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = row < 5 ? 10 : 8;
    }

    public Seat(){};

    private int row;

    private int column;

    private int price;

    private UUID token;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
