package task17_21.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import task17_21.service.PersonService;

@Component
@RequiredArgsConstructor
@Slf4j
public class PersonScheduler {

    private  final PersonService personService;

  //  @Scheduled(initialDelay = 1000L, fixedDelay = 10000L)
    public void nullByPatronymic() {
        log.info(personService.getPersonByNullPatronymic());
    }

}
