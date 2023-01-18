package fr.sorbonne.paris.nord.university.api.repository;

import fr.sorbonne.paris.nord.university.api.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
