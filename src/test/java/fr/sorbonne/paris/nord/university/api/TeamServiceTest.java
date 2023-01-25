package fr.sorbonne.paris.nord.university.api;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.Team;
import fr.sorbonne.paris.nord.university.api.mappers.TeamMapper;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TeamServiceTest {

    @Mock
    private TeamRepository repository;
    @Mock
    private TeamMapper mapper;
    @InjectMocks
    private TeamService service;

    @BeforeEach
    void setup()
    {

    }
    @AfterEach
    void tearDown(){}

    @Test
    void when_getAll_then_return_list_having_same_size_as_repository_list()
    {
        //Given
        List<Team> t = List.of( new Team(1L, "ff", "fff") , new Team(2L, "ff", "fff"), new Team(3L, "ff", "fff") );
        //when
        Mockito.when(repository.findAll()).thenReturn(t);
        //then
        List<Team> actual = repository.findAll();
        //assertEquals
        assertEquals(actual.size(), t.size());
        //Mockito.when(repository.findAll()).thenReturn(List.of( ));

    }

    @Test
    void givenId_WhenGet_ThenTeamWithThisId ()
    {

        //given
        Long id = 5L;
        Team team = new Team();
        team.setId(id);
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(team)) ;
        TeamDTO actual = service.getTeamById(id);
        assertNotNull(actual);
        assertEquals(5, actual.getId());
    }

    @Test
    void givenTeam_WhenAdd_thenAdd ()
    {
        //given
        Team team = new Team();
        team.setId(5L);
        team.setSlogan("Siwar Siwar Siwar");
        team.setName("Mazembé");
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(team)) ;
        Mockito.when(repository.save(any(Team.class))).thenReturn(team);
        Mockito.when(mapper.map(Mockito.any(Team.class))).thenReturn(TeamDTO.builder().id((team.getId())).name(team.getName()).slogan(team.getSlogan()).build());
        TeamDTO actual = service.updateTeam(mapper.map(team));
        assertNotNull(actual);
        assertEquals("Mazembé", actual.getName());
    }

    /*@Test
    /void givenExistingTeam_WhenUpdate_thenUpdateTeam ()
    {
        //given
        Team team = new Team();
        team.setId(5L);
        team.setSlogan("Siwar Siwar Siwar");
        team.setName("Mazembé");
        Mockito.when(repository.save(any(Team.class))).thenReturn(team);
        Mockito.when(mapper.map(Mockito.any(Team.class))).thenReturn(TeamDTO.builder().id((team.getId())).name(team.getName()).slogan(team.getSlogan()).build());
        team.setSlogan("ABCDEFGHIJH");
        TeamDTO actual = service.updateTeam(mapper.map(team));
        assertNotNull(actual);
        assertEquals("ABCDEFGHIJH", actual.getSlogan());
    }*/

    @Test
    void givenExistingTeam_WhenUpdate_thenUpdateTeam ()
    {
        //given
        List<Team> t = List.of( new Team(1L, "ff", "fff") , new Team(2L, "ff", "fff"), new Team(3L, "ff", "fff") );
        Long id = 2L;
        Team teamToUpdate = t.get(id.intValue()-1);

        //System.out.println(teamToUpdate);
        Mockito.when(repository.findById(any())).thenReturn(Optional.of(teamToUpdate)) ;
        Mockito.when(repository.save(any(Team.class))).thenReturn(teamToUpdate);

        //Modify it
        teamToUpdate.setSlogan("Siwar Siwar Siwar");
        teamToUpdate.setName("Mazembé");

        Mockito.when(mapper.map(Mockito.any(Team.class))).thenReturn(TeamDTO.builder().id((teamToUpdate.getId())).name(teamToUpdate.getName()).slogan(teamToUpdate.getSlogan()).build());
        TeamDTO actual = service.updateTeam(mapper.map(teamToUpdate));
        assertNotNull(actual);
        assertEquals("Mazembé", actual.getName());
    }

    @Test
    void givenNonExistingTeam_WhenUpdate_thenUpdateTeam ()
    {
        Team team = new Team(1L, "Siwar", "Siwar");
        //System.out.println(teamToUpdate);
        Mockito.when(repository.findById(any())).thenReturn(Optional.empty()) ;
        Mockito.when(repository.save(any(Team.class))).thenReturn(team);
        Mockito.when(mapper.map(Mockito.any(Team.class))).thenReturn(TeamDTO.builder().id((team.getId())).name(team.getName()).slogan(team.getSlogan()).build());

        TeamDTO actual = service.updateTeam(mapper.map(team));
        assertNotNull(actual);
        assertEquals("Siwar", actual.getName());
    }

    @Test
    void givenTeam_WhenDelete_thenDeleteTeam ()
    {
        /*

        Long id = 5L;
        Team team = new Team();
        team.setId(id);
        Mockito.when(mapper.map(Mockito.any(Team.class))).thenReturn(TeamDTO.builder().id((team.getId())).name(team.getName()).slogan(team.getSlogan()).build());
        //Mockito.when(repository.deleteById(id)).thenReturn(mapper.map(team)) ;
        TeamDTO actual = service.updateTeam(mapper.map(team));
        assertNotNull(actual);
        assertEquals("Siwar", actual.getName());

         */
    }


}
