package servis;

import model.NofiticationTask;
import org.springframework.stereotype.Service;
import repository.NofiticationRepository;
@Service
public class NofiticationServis {
    private final NofiticationRepository nofiticationRepository;

    public NofiticationServis(NofiticationRepository nofiticationRepository) {
        this.nofiticationRepository = nofiticationRepository;
    }
    public NofiticationTask add(NofiticationTask nofiticationTask){
        return nofiticationRepository.save(nofiticationTask);
    }
}
