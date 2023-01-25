package fr.sorbonne.paris.nord.university.api.mappers;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {
    public Team map(TeamDTO dto)
    {
        return Team.builder().id((dto.getId())).name(dto.getName()).slogan(dto.getSlogan()).build();
    }

    public TeamDTO map(Team t)
    {
        return TeamDTO.builder().id((t.getId())).name(t.getName()).slogan(t.getSlogan()).build();
    }
}
