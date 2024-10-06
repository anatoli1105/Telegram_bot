package pro.sky.telegrambot.configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import pro.sky.telegrambot.listener.TelegramBotUpdatesListener;
import pro.sky.telegrambot.servise.NotificationServise;

@Configuration
public class ScheduledMethod {
    @Autowired
    private NotificationServise notitfcationServise;


    @Scheduled(cron = "0 0/1  * * * *")
    public void scheduleFixedRateTask() {


        notitfcationServise.SendNotification();


    }
}
