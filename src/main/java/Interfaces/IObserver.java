package Interfaces;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

public interface IObserver<T> {
    void update(T value);
    UUID getId();
    ISubstance currentSubstanceStatus();
    HashMap<LocalDateTime, String> getHistoryLog();
}
