package pl.pjatk.kamkon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

// zad1

@RestController
@RequestMapping("/info")
public class PathRouter {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }

    // zad2

    @GetMapping("/shift")
    public ResponseEntity<Shift> showShift() {
        Shift shift = new Shift();
        shift.setId("BCA3211");
        shift.setAmount(1);
        shift.setStartTimestamp(OffsetDateTime.now());
        shift.setEndTimestamp(OffsetDateTime.now().plusHours(8));
        shift.setDuration();

        return ResponseEntity.ok(shift);
    }

    // zad3

    @GetMapping("/hello/{someValue}")
    public ResponseEntity<String> showString(@PathVariable String someValue) {
        return ResponseEntity.ok(someValue);
    }

    // zad4

    @GetMapping("/helloNew")
    public ResponseEntity<String> showStringWithParam(@RequestParam String reqParam) {
        return ResponseEntity.ok(reqParam);
    }

    // zad5

    @PostMapping("/create")
    public ResponseEntity<Shift> crateShift(@RequestBody Shift shift) {
        return ResponseEntity.ok(shift);
    }



}
