package com.filmrentalstore.dto;
 
import java.time.LocalDateTime;
 
public class RentalDTO {
    private long rentalId;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
 
    public RentalDTO() {}
 
    public RentalDTO(long rentalId, LocalDateTime rentalDate, LocalDateTime returnDate) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }
 
    public long getRentalId() {
        return rentalId;
    }
 
    public void setRentalId(long rentalId) {
        this.rentalId = rentalId;
    }
 
    public LocalDateTime getRentalDate() {
        return rentalDate;
    }
 
    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }
 
    public LocalDateTime getReturnDate() {
        return returnDate;
    }
 
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
 