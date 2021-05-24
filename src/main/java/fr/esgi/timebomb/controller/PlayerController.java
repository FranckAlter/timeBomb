package fr.esgi.timebomb.controller;

import fr.esgi.timebomb.dao.PlayerDao;
import fr.esgi.timebomb.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private PlayerDao playerDao;

    @GetMapping
    public ResponseEntity<List<Player>> listPlayer() {
        return ok(playerDao.findAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<Player> findByUsername(@PathVariable String username) {
        return playerDao.findPlayerByUsername(username)
                .map(ResponseEntity::ok)
                .orElseGet(() -> notFound().build());
    }
}
