package fr.sorbonne.paris.nord.university.api.Controller;

import fr.sorbonne.paris.nord.university.api.entity.Team;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeamController {
    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/all")
    public List<Team> getallTeam()
    {
        return teamService.allTeam();
    }
    @GetMapping("/team")
    public Team getById(@RequestParam("id") Long id)
    {
        return teamService.getTeamById(id);
    }

    @PostMapping("/add")
    public void addTeam(@RequestBody Team team)
    {
        Team t = new Team();
        t.setName(team.getName());
        t.setSlogan(team.getSlogan());
        teamService.addTeam(t);
    }

    @PutMapping("/update")
    public void updateTeam(@RequestBody Team team)
    {
        Team t = new Team();
        t.setId(team.getId());
        t.setName(team.getName());
        t.setSlogan(team.getSlogan());
        teamService.updateTeam(t);
    }

    @DeleteMapping("/team")
    public void deleteTeamById (@RequestParam("id") Long id)
    {
        teamService.deleteTeamById(id);
    }

}
