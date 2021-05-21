package fr.esgi.timebomb.dao;

import fr.esgi.timebomb.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDao extends JpaRepository<Card, Integer> {
}
