package pro.sky.telegrambot.repository;

import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.model.NofiticationTask;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NofiticationRepository extends JpaRepository<NofiticationTask,Integer> {

}
