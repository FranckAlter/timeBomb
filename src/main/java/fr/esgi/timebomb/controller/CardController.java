package fr.esgi.timebomb.controller;

import fr.esgi.timebomb.dao.CardDao;
import fr.esgi.timebomb.domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardDao cardDao;

    @GetMapping
    public List<Card> listCard() {
        return cardDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@PathVariable int id) {
        return cardDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> notFound().build());
    }
}
