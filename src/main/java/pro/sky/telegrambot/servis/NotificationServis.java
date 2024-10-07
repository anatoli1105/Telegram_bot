package pro.sky.telegrambot.servis;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import pro.sky.telegrambot.model.NotificationTask;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

@Service
public class NotificationServis {
    private final NotificationRepository notificationRepository;
    private final TelegramBot telegramBot;

    public NotificationServis(NotificationRepository notificationRepository, TelegramBot telegramBot) {
        this.notificationRepository = notificationRepository;
        this.telegramBot = telegramBot;
    }

    public NotificationTask add(NotificationTask notificationTask) {
        return notificationRepository.save(notificationTask);
    }

    public Collection<NotificationTask> getAll() {

        return notificationRepository.findAll();
    }


    public void sendNotification() {
        Collection<NotificationTask> tasks = notificationRepository.findCurrent();
        for (NotificationTask task : tasks) {

            sendTuchat(task.getChatID(), task.getMessage(), stringFormat(task.getDateTime()));

        }
    }


    private void sendTuchat(Long chatID, String message, String dateTime) {
        SendMessage sendMessage = new SendMessage(chatID, message+dateTime);
        SendResponse response = telegramBot.execute(sendMessage);
    }

    public String stringFormat(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String str = localDateTime.format(formatter);
        return str;

    }


    public boolean delete(Long id) {
        return notificationRepository.findById(id).
                map(entity -> {
                    notificationRepository.delete(entity);
                    return true;
                }).orElse(false);
    }

}
