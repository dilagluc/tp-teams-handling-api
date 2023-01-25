package fr.sorbonne.paris.nord.university.api.controller;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/team")
    public List<TeamDTO> getAllTeam()
    {
        return teamService.allTeam();
    }
    @GetMapping("/team/{id}")
    public TeamDTO getById( @PathVariable String id)
    {
        return teamService.getTeamById(Long.valueOf(id));
    }

    @PostMapping("/team")
    public void addTeam(@RequestBody TeamDTO teamdto)
    {
        teamService.addTeam(teamdto);
    }

    @PutMapping("/team")
    public void updateTeam(@RequestBody TeamDTO teamdto)
    {
        teamService.updateTeam(teamdto);
    }

    @DeleteMapping("/team/{id}")
    public void deleteTeamById ( @PathVariable String id)
    {
        teamService.deleteTeamById(Long.valueOf(id));
    }

    /*@GetMapping("/all")
    public List<TeamDTO> getAllTeam()
    {
        return teamService.allTeam();
    }
    @GetMapping("/team")

    public TeamDTO getById(@RequestParam("id") Long id)
    {
        return teamService.getTeamById(id);
    }

    @PostMapping("/add")
    public void addTeam(@RequestBody TeamDTO teamdto)
    {
        teamService.addTeam(teamdto);
    }

    @PutMapping("/update")
    public void updateTeam(@RequestBody TeamDTO teamdto)
    {
        teamService.updateTeam(teamdto);
    }

    @DeleteMapping("/team")
    public void deleteTeamById (@RequestParam("id") Long id)
    {
        teamService.deleteTeamById(id);
    }*/

}
