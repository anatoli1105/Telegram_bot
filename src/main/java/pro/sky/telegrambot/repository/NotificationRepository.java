package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.Query;
import pro.sky.telegrambot.model.NotificationTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface NotificationRepository extends JpaRepository<NotificationTask, Long> {

    @Query(value = "SELECT * FROM notification_task WHERE date_time = date_trunc('minute', CURRENT_TIMESTAMP(0))", nativeQuery = true)
    Collection<NotificationTask> findCurrent();

}
