package cinema.domainmodel;

public class Statistic {

    private int currentIncome = 0;

    private int numberOfAvailableSeats;

    private int numberOfPurchasedTickets = 0;

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

    public Statistic(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }
}
