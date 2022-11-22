package task13_14_15.service.converter;

import org.springframework.stereotype.Component;
import task13_14_15.model.Passport;
import task13_14_15.service.dto.PassportDto;

@Component
public class PassportConverter {

    public PassportDto convertPassportToPassportDTO(Passport passport) {
        return new PassportDto(passport.getNumber(), passport.getSeries(), passport.getDateOfIssue());
    }
}
