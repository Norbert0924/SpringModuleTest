package app.services;

import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceShipService {

    private SpaceShipRepo spaceShipRepo;

    public SpaceShipService(SpaceShipRepo spaceShipRepo) {
        this.spaceShipRepo = spaceShipRepo;
    }

    public List<SpaceShip> listAll() {
           List<SpaceShip> spaceships = spaceShipRepo.findAll();

           return spaceships;
    }

    public List<SpaceShip> listAllActive() {
        return spaceShipRepo.findAllByIsActiveTrue();
    }
}
