package task13_14_15.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PassportDto {
    private String series;
    private String number;
    private LocalDate localDate;
}
