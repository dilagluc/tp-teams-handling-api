package fr.sorbonne.paris.nord.university.api;

import fr.sorbonne.paris.nord.university.api.entity.Team;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HelloController {
    @Autowired
    private TeamService teamService;
    @GetMapping("/hello")
    public List<Team> hello()
    {
        Team t = new Team();
        t.setId(Long.valueOf(1));
        t.setName("dd");
        t.setSlogan("ghg");
        teamService.deleteTeamById(Long.valueOf(5));
        return teamService.allTeam();
    }

}
