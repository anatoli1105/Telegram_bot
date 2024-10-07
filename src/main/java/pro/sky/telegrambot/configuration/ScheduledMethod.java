package pro.sky.telegrambot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import pro.sky.telegrambot.servis.NotificationServis;

@Configuration
public class ScheduledMethod {
    @Autowired
    private NotificationServis notitfcationServise;


    @Scheduled(cron = "0 0/1  * * * *")
    public void scheduleFixedRateTask() {


        notitfcationServise.sendNotification();


    }
}
