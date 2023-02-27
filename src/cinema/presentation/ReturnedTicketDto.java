package cinema.presentation;

import cinema.domainmodel.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnedTicketDto {

    @JsonProperty("returned_ticket")
    private SeatDto ticket;

    public void setTicket(SeatDto ticket) {
        this.ticket = ticket;
    }

    public SeatDto getTicket() {
        return ticket;
    }
}
