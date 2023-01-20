package task17_21.service.converter;

import org.springframework.stereotype.Component;
import task17_21.model.Passport;
import task17_21.service.dto.PassportDto;


@Component
public class  PassportConverter {

    public PassportDto convertPassportToPassportDTO(Passport passport) {
        return new PassportDto(passport.getNumber(), passport.getSeries(), passport.getDateOfIssue());
    }


}
