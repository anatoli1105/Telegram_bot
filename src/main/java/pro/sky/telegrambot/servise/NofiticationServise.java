package pro.sky.telegrambot.servise;

import pro.sky.telegrambot.model.NofiticationTask;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.repository.NofiticationRepository;

@Service
public class NofiticationServise {
    private final NofiticationRepository nofiticationRepository;

    public NofiticationServise(NofiticationRepository nofiticationRepository) {
        this.nofiticationRepository = nofiticationRepository;
    }
    public NofiticationTask add(NofiticationTask nofiticationTask){
        return nofiticationRepository.save(nofiticationTask);
    }
}
