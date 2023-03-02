package cinema.presentation;

import java.util.UUID;

public class TicketDto {

    private UUID token;

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public void setTicket(SeatDto ticket) {
        this.ticket = ticket;
    }

    public SeatDto getTicket() {
        return ticket;
    }

    private SeatDto ticket;

}
