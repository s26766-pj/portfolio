package pl.pjatk.kamkon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomeWork {

    SideClass sideClass;

    public HomeWork(SideClass sideClass, @Value("${staging.profile}") Boolean isStagingProfile) {
        if (isStagingProfile) {
            this.sideClass = sideClass;
        }
    }

    public void printMessage() {
        System.out.println(sideClass.welcomeMessage());
    }
}
