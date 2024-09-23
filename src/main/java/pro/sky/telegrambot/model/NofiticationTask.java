package pro.sky.telegrambot.model;

import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
