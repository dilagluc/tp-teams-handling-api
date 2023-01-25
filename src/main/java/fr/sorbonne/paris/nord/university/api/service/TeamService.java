package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.Team;
import fr.sorbonne.paris.nord.university.api.mappers.TeamMapper;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    public TeamMapper teamMapper = new TeamMapper();


    public List<TeamDTO> allTeam()
    {
        return this.teamRepository.findAll().stream().map( teamMapper::map ).collect(Collectors.toList());
        //return null;
    }

    public TeamDTO getTeamById(Long id)
    {
        return teamMapper.map(this.teamRepository.findById(id).get());
    }

    @Transactional
    public TeamDTO addTeam(TeamDTO teamdto)
    {
        return teamMapper.map( this.teamRepository.save(teamMapper.map(teamdto)) );
    }

    @Transactional
    public TeamDTO updateTeam(TeamDTO teamdto)
    {
        Optional<Team> t = this.teamRepository.findById(teamMapper.map(teamdto).getId());
        if(!t.equals(Optional.empty()))
        {
            t.get().setSlogan(teamMapper.map(teamdto).getSlogan());
            t.get().setName(teamMapper.map(teamdto).getName());
            return teamMapper.map( this.teamRepository.save(t.get()) );
        }
        else
        {
            return teamMapper.map( this.teamRepository.save(teamMapper.map(teamdto)));
        }


    }

    @Transactional
    public void deleteTeamById(Long id)
    {
        this.teamRepository.deleteById(id);
    }

}
