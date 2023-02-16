package cinema.domainmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Seats {

    @JsonProperty("total_rows")
    private final int numOfRows;

    @JsonProperty("total_columns")
    private final int numOfColumns;

    @JsonProperty("available_seats")
    private List<Seat> seats;

    public Seats(int numOfRows, int numOfColumns, List<Seat> seats) {
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        this.seats = seats;
    }

    public List<Seat> getSeats() {
        return seats;
    }


}
