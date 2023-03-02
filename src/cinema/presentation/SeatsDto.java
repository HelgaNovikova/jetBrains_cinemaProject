package cinema.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SeatsDto {

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<SeatDto> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<SeatDto> availableSeats) {
        this.availableSeats = availableSeats;
    }

    @JsonProperty("total_rows")
    private int totalRows;

    @JsonProperty("total_columns")
    private int totalColumns;

    @JsonProperty("available_seats")
    private List<SeatDto> availableSeats;

}
