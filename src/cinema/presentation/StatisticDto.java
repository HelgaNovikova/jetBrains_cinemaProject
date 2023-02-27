package cinema.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticDto {

    @JsonProperty("current_income")
    private int currentIncome;

    @JsonProperty("number_of_available_seats")
    private int numberOfAvailableSeats;

    @JsonProperty("number_of_purchased_tickets")
    private int numberOfPurchasedTickets;

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

}
