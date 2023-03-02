package cinema.presentation;

import cinema.businesslayer.CinemaService;
import cinema.domainmodel.Seat;
import cinema.domainmodel.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;

@RestController
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    @GetMapping("/seats")
    public SeatsDto getSeats() {
        return cinemaService.getSeats();
    }

    @PostMapping("/purchase")
    public TicketDto purchaseTicket(@RequestBody Seat seat) {
        if (!cinemaService.isRowColumnValid(seat.getRow(), seat.getColumn())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The number of a row or a column is out of bounds!");
        }
        if (cinemaService.isTicketPurchased(seat.getRow(), seat.getColumn())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The ticket has been already purchased!");
        }
        return cinemaService.purchaseSeat(seat.getRow(), seat.getColumn());
    }

    @PostMapping("/return")
    public ReturnedTicketDto returnTicket(@RequestBody Token token) {
        if (!cinemaService.checkToken(token.getToken())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong token!");
        }
        return cinemaService.returnTicket(token.getToken());
    }

    @PostMapping("/stats")
    public StatisticDto getStatistic(@RequestParam("password") Optional<String> password) {
        if (!password.equals(Optional.of("super_secret")) || password.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "The password is wrong!");
        }
        return cinemaService.getStatistic();
    }

    @ExceptionHandler(ResponseStatusException.class)
    protected ResponseEntity<Object> handleConflict(ResponseStatusException ex) {
        return new ResponseEntity<>(Map.of("error", ex.getReason()), ex.getStatus());
    }
}
