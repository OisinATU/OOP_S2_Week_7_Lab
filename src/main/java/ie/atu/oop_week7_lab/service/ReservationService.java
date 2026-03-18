package ie.atu.oop_week7_lab.service;


import ie.atu.oop_week7_lab.exception.ReservationConflictException;
import ie.atu.oop_week7_lab.exception.ReservationNotFoundException;
import ie.atu.oop_week7_lab.model.Reservation;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {


    final List<Reservation> reservations =  new ArrayList<>();
    private long nextId = 1;

    public Reservation addReservation(Reservation reservation) {
        reservation.setReservationId(nextId++);


        for (Reservation existing : reservations) {
            if(existing.getEquipmentTag().equals(reservation.getEquipmentTag()) && existing.getReservationDate().equals(reservation.getReservationDate())) {

                int existingStart = existing.getStartHour();
                int existingEnd = existingStart+existing.getDurationHours();

                int newStart = reservation.getStartHour();
                int newEnd = newStart+reservation.getDurationHours();

                if(existingStart < newEnd && existingEnd > newStart) {
                    reservation.setReservationId(nextId--);
                    throw new ReservationConflictException("Reservation already exists");
                }

            }
        }

        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public Reservation getReservationById(Long id) {
        for(Reservation reservation : reservations) {
            if(reservation.getReservationId().equals(id)) {
                return reservation;
            }
        }
        throw new ReservationNotFoundException("Reservation not found");
    }
}
