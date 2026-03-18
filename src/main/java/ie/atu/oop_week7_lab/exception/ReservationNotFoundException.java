package ie.atu.oop_week7_lab.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(String reservationNotFound) {
        super(reservationNotFound);
    }
}
