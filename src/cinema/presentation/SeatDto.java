package cinema.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeatDto {

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @JsonProperty("row")
    private int row;

    @JsonProperty("column")
    private int column;

    @JsonProperty("price")
    private int price;

}
