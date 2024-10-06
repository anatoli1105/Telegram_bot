package pro.sky.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import pro.sky.telegrambot.model.NotificationTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pro.sky.telegrambot.servise.NotificationServise;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);


    @Autowired
    private TelegramBot telegramBot;
    @Autowired
    private NotificationServise notificationServise;
    //  @Autowired
    // private ScheduledMethod scheduledMethod;


    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);


    }


    @Override
    public int process(List<Update> updates) {

        updates.forEach(update -> {
            logger.info("Processing update: {}", update);


            var id = update.message().chat().id();
            if (update.message().text().equals("start")) {
                SendMessage message = new SendMessage(id, "hi");
                SendResponse response = telegramBot.execute(message);

            }
            Pattern pattern = Pattern.compile("(\\d{2}\\.\\d{2}\\.\\d{4}\\s\\d{2}:\\d{2})(\\s+)(.+)");
            Matcher matcher = pattern.matcher(update.message().text());
            if (matcher.matches()) {

                Long chatID = id;
                String dateTime = matcher.group(1);
                String textMessage = matcher.group(3);
                var date = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
                var dateOfBot = new NotificationTask(id, date, textMessage);
                notificationServise.add(dateOfBot);


                var data = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String str = data.format(formatter);


                SendMessage message = new SendMessage(id, str);
                SendResponse response = telegramBot.execute(message);

            }


        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }


}
