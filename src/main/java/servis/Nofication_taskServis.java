package servis;

import model.Nofitication_task;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.listener.TelegramBotUpdatesListener;
import repository.NofiticationRepository;
@Service

public class Nofication_taskServis {
    private final NofiticationRepository nofiticationRepository;
    private final TelegramBotUpdatesListener telegramBotUpdatesListener;

    public Nofication_taskServis(NofiticationRepository nofiticationRepository, TelegramBotUpdatesListener telegramBotUpdatesListener) {
        this.nofiticationRepository = nofiticationRepository;

        this.telegramBotUpdatesListener = telegramBotUpdatesListener;
    }
public Nofitication_task add(Nofitication_task nofiticationTask){
        return nofiticationRepository.save(nofiticationTask);
}
}
