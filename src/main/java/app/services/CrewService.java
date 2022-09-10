package app.services;

import app.models.Crew;
import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrewService {

    private SpaceShipRepo spaceShipRepo;

    public CrewService(SpaceShipRepo spaceShipRepo) {
        this.spaceShipRepo = spaceShipRepo;
    }

    public List<Crew> listCrewBySpaceShipRegistrationCode(String registrationCode) {
           Optional<SpaceShip> spaceship = spaceShipRepo.findByRegistrationCode(Long.parseLong(registrationCode));

           if (spaceship.isPresent()) {
               System.out.println(spaceship.get().getCrews());
               return spaceship.get().getCrews();
           }

           return new ArrayList<>();
    }
}
