package pl.pjatk.kamkon;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.OffsetDateTime;


public class Shift {

    String id;
    Integer Amount;
    OffsetDateTime startTimestamp;
    OffsetDateTime endTimestamp;
    Duration duration;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public OffsetDateTime getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(OffsetDateTime startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public OffsetDateTime getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(OffsetDateTime endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public void setDuration() {
        this.duration = Duration.between(startTimestamp, endTimestamp);
    }

    public Duration getDuration() {
        return duration;
    }
}
