package task16.service.converter;

import org.springframework.stereotype.Component;
import task16.model.Passport;
import task16.service.dto.PassportDto;


@Component
public class PassportConverter {

    public PassportDto convertPassportToPassportDTO(Passport passport) {
        return new PassportDto(passport.getNumber(), passport.getSeries(), passport.getDateOfIssue());
    }


}
