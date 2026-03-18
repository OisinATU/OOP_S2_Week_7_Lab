package ie.atu.oop_week7_lab.exception;

public class ReservationConflictException extends RuntimeException {
    public ReservationConflictException(String reservationAlreadyExists) {

        super(reservationAlreadyExists);
    }
}
