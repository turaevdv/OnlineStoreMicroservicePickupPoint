package ru.turaev.pickuppoint.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.turaev.pickuppoint.exception.AddressNotFoundException;
import ru.turaev.pickuppoint.exception.BaseException;
import ru.turaev.pickuppoint.exception.PickupPointNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionApiHandler {
    @ExceptionHandler({PickupPointNotFoundException.class, AddressNotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(BaseException ex) {
        log.warn("An error has occurred. Error message - {}", ex.getMessage());
        HttpStatus httpStatus = ex.getStatus();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("message", ex.getMessage());
        responseMap.put("exceptionTime", ex.getLocalDateTime());
        return new ResponseEntity<>(responseMap, httpStatus);
    }
}
