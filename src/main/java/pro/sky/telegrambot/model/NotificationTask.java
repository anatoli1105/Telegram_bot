package pro.sky.telegrambot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class NotificationTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private Long chatID;
    private LocalDateTime dateTime;
    private String message;

    public NotificationTask(Long chatID, LocalDateTime dateTime, String message) {
        this.chatID = chatID;
        this.dateTime = dateTime;
        this.message = message;

    }

    public NotificationTask() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setChatID(Long chatID) {
        this.chatID = chatID;
    }

    public Long getChatID() {
        return chatID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationTask that = (NotificationTask) o;
        return Objects.equals(id, that.id) && Objects.equals(chatID, that.chatID) && Objects.equals(dateTime, that.dateTime) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatID, dateTime, message);
    }

    @Override
    public String toString() {
        return "NofiticationTask{" +
                "chatID=" + chatID +
                ", id=" + id +
                ", dateTime='" + dateTime + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

