package cinema.businesslayer;

import cinema.domainmodel.Seat;
import cinema.domainmodel.Seats;
import cinema.domainmodel.Statistic;
import cinema.presentation.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CinemaService implements CommandLineRunner {

    private final int numOfRows = 9;
    private final int numOfColumns = 9;
    private Seats seats;
    private Statistic statistic;

    private void generateSeats() {
        List<Seat> seatsArr = new ArrayList<>();
        for (int i = 1; i <= numOfRows; i++) {
            for (int j = 1; j <= numOfColumns; j++) {
                seatsArr.add(new Seat(i, j));
            }
        }
        seats = new Seats(numOfRows, numOfColumns, seatsArr);
        statistic = new Statistic();
    }

    @Override
    public void run(String... args) throws Exception {
        generateSeats();
    }

    public SeatsDto getSeats() {
        SeatsDto dto = new SeatsDto();
        dto.setAvailableSeats(seats.getAvailableSeats().stream()
                .map(s -> getSeatDto(s))
                .collect(Collectors.toList()));
        dto.setTotalColumns(seats.getTotalColumns());
        dto.setTotalRows(seats.getTotalRows());
        return dto;
    }

    private SeatDto getSeatDto(Seat s) {
        SeatDto seatDto = new SeatDto();
        seatDto.setColumn(s.getColumn());
        seatDto.setPrice(s.getPrice());
        seatDto.setRow(s.getRow());
        return seatDto;
    }

    public boolean checkIfRowColumnValid(int rowNum, int columnNum) {
        return rowNum < 10 && rowNum >= 1 && columnNum < 10 && columnNum >= 1;
    }

    public boolean checkIfTicketPurchased(int rowNum, int columnNum) {
        return seats.getSeat(rowNum, columnNum).getToken() != null;
    }

    public TicketDto purchaseSeat(int rowNum, int columnNum) {
        TicketDto dto = new TicketDto();
        Seat seat = seats.getSeat(rowNum, columnNum);
        UUID token = UUID.randomUUID();
        seat.setToken(token);
        dto.setTicket(getSeatDto(seat));
        dto.setToken(token);
        statistic.setCurrentIncome(statistic.getCurrentIncome() + seat.getPrice());
        statistic.setNumberOfAvailableSeats(statistic.getNumberOfAvailableSeats() - 1);
        statistic.setNumberOfPurchasedTickets(statistic.getNumberOfPurchasedTickets() + 1);
        return dto;
    }

    public boolean checkToken(UUID token) {
        boolean s = seats.findSeatByToken(token) != null;
        return seats.findSeatByToken(token) != null;
    }

    public ReturnedTicketDto returnTicket(UUID token) {
        ReturnedTicketDto dto = new ReturnedTicketDto();
        Seat seat = seats.findSeatByToken(token);
        seat.setToken(null);
        dto.setTicket(getSeatDto(seat));
        statistic.setCurrentIncome(statistic.getCurrentIncome() - seat.getPrice());
        statistic.setNumberOfAvailableSeats(statistic.getNumberOfAvailableSeats() + 1);
        statistic.setNumberOfPurchasedTickets(statistic.getNumberOfPurchasedTickets() - 1);
        return dto;
    }

    public StatisticDto getStatistic(){
        StatisticDto dto = new StatisticDto();
        dto.setCurrentIncome(statistic.getCurrentIncome());
        dto.setNumberOfAvailableSeats(statistic.getNumberOfAvailableSeats());
        dto.setNumberOfPurchasedTickets(statistic.getNumberOfPurchasedTickets());
        return dto;
    }
}
