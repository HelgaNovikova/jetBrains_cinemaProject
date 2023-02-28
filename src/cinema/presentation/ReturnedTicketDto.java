package cinema.presentation;

import cinema.domainmodel.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnedTicketDto {

    @JsonProperty("returned_ticket")
    private SeatDto returnedTicket;

    public void setTicket(SeatDto ticket) {
        this.returnedTicket = ticket;
    }

    public SeatDto getTicket() {
        return returnedTicket;
    }
}
