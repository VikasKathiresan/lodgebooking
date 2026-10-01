package lodgebooking.controller;

import lodgebooking.model.Booking;
import lodgebooking.repository.BookingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingRepository repository;

    public BookingController(BookingRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String createBooking(@RequestBody Booking booking) {
        booking.setId(null);   // let the database create the id
        Booking saved = repository.save(booking);
        return "Booking received successfully! id=" + saved.getId();
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id,
                                                 @RequestBody Booking updated) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updated.setId(id);
        return ResponseEntity.ok(repository.save(updated));
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        repository.deleteById(id);
        return "Deleted booking " + id;
    }
}