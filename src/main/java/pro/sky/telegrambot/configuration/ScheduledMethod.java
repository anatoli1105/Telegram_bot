package pro.sky.telegrambot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import pro.sky.telegrambot.service.NotificationService;

@Configuration
public class ScheduledMethod {
    @Autowired
    private NotificationService notitfcationServise;


    @Scheduled(cron = "0 0/1  * * * *")
    public void scheduleFixedRateTask() {


        notitfcationServise.sendNotification();


    }
}
