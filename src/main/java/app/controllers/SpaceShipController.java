package app.controllers;

import app.models.SpaceShip;
import app.models.SpaceShipClass;
import app.services.SpaceShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpaceShipController {

    //@Autowired
    private SpaceShipService spaceShipService;

    public SpaceShipController(SpaceShipService spaceShipService) {
        this.spaceShipService = spaceShipService;
    }

    @GetMapping(value = {"/spaceship"})
    public String saveNewSpaceShip(Model model) {
        model.addAttribute("newShip", new SpaceShip());
        model.addAttribute("shipClasses", SpaceShipClass.values());

        return "spaceship_new";
    }

    @GetMapping("/list-spaceship")
    public String listSpaceShips(Model model, @RequestParam(required = false, name = "isActive") String filter) {

        if (filter == null || filter.equals("")) {
            model.addAttribute("spaceships", spaceShipService.listAll());
            model.addAttribute("filtered", "false");

        } else if (filter.equals("true")) {
            System.out.println(spaceShipService.listAllActive());
            model.addAttribute("spaceships", spaceShipService.listAllActive());
            model.addAttribute("filtered", "true");
        }

        return "list_spaceship";
    }

}
