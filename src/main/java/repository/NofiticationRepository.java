package repository;

import model.Nofitication_task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NofiticationRepository extends JpaRepository<Nofitication_task,Long> {
    void setChatID(Long id);
}
