package dev.euchigere.eventsmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ServiceResponse<T> {
    private boolean status;
    private String message;
    private T data;
}
