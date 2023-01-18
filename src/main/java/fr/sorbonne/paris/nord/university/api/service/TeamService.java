package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.entity.Team;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> allTeam()
    {
        return this.teamRepository.findAll();
        //return null;
    }

    public Team getTeamById(Long id)
    {
        return this.teamRepository.findById(id).get();
    }

    public void addTeam(Team team)
    {
        this.teamRepository.save(team);
    }

    public void updateTeam(Team team)
    {
        Optional<Team> t = this.teamRepository.findById(team.getId());
        if(!t.equals(Optional.empty()))
        {
            t.get().setSlogan(team.getSlogan());
            t.get().setName(team.getName());
            this.teamRepository.save(t.get());
        }
        else
        {
            this.teamRepository.save(team);
        }


    }

    public void deleteTeamById(Long id)
    {
        this.teamRepository.deleteById(id);
    }

}
