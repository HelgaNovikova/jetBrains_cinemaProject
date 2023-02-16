package cinema.domainmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Seat {

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    @JsonProperty("row")
    private int rowNumber;

    @JsonProperty("column")
    private int columnNumber;

    public Seat(int rowNumber, int columnNumber) {
        this.columnNumber = columnNumber;
        this.rowNumber = rowNumber;
    }
}
