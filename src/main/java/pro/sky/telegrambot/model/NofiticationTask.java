package pro.sky.telegrambot.model;

import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class NofiticationTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private Long chatID;
    private String dateTime;
    private String message;

    public NofiticationTask(Long id, String dateTime, String message, Long chatID) {
        this.id = id;
        this.dateTime = dateTime;
        this.message = message;
        this.chatID = chatID;
    }

    public NofiticationTask() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public String getDateTime() {
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
        NofiticationTask that = (NofiticationTask) o;
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
