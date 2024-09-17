package model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Configuration
public class Nofitication_task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private Long chatID;
    private String dateTime;
    private String message;

    public Nofitication_task(Long id, String dateTime, String message, Long chatID) {
        this.id = id;
        this.dateTime = dateTime;
        this.message = message;
        this.chatID = chatID;
    }

    public Nofitication_task() {

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
