package ie.atu.oop_week7_lab.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {


private Long reservationId;

@NotBlank(message = "equipmentTag is required")
private String equipmentTag;

@NotBlank(message = "studentEmail is required")
@Email(message = "studentEmail must be a valid email address")
private String studentEmail;

@NotBlank(message = "reservationDate is required")
private LocalDate reservationDate;

@NotBlank(message = "startHour is required")
@Max(value =23, message = "startHour must be between 0 and 23")
@Min(value =0, message = "startHour must be between 0 and 23")
private int startHour;

@NotBlank(message = "durationHours is required")
@Max(value =24, message = "durationHours must be between 1 and 24")
@Min(value =1, message = "durationHours must be between 1 and 24")
private int durationHours;




}
