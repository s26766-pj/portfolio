package pl.pjatk.kamkon;

import org.springframework.stereotype.Component;

@Component
public class RunHomeWork {
    public RunHomeWork(HomeWork homeWork) {
        homeWork.printMessage();

    }
}
