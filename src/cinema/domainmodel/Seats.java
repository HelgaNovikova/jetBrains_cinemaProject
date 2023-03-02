package cinema.domainmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Seats {

    private final int totalRows;

    private final int totalColumns;

    private List<Seat> availableSeats;

    public Seats(int numOfRows, int numOfColumns, List<Seat> seats) {
        this.totalRows = numOfRows;
        this.totalColumns = numOfColumns;
        this.availableSeats = seats;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public Seat getSeat(int row, int column) {
        for (Seat item : availableSeats) {
            if (item.getColumn() == column && item.getRow() == row) {
                return item;
            }
        }
        return null;
    }

    public Seat findSeatByToken(UUID token) {
        for (Seat item : availableSeats) {
            if (item.getToken() != null && item.getToken().equals(token)) {
                return item;
            }
        }
        return null;
    }

}
