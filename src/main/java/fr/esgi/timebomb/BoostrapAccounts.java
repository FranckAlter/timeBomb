package fr.esgi.timebomb;

import fr.esgi.timebomb.dao.PlayerDao;
import fr.esgi.timebomb.domain.Player;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BoostrapAccounts {

    private final PlayerDao playerDao;
    private final PasswordEncoder passwordEncoder;


    public BoostrapAccounts(PlayerDao playerDao, PasswordEncoder passwordEncoder) {
        this.playerDao = playerDao;
        this.passwordEncoder = passwordEncoder;
    }

    @EventListener
    void onStartup(ApplicationReadyEvent event) {
        Player player = new Player(1,"mvestro",passwordEncoder.encode("haribo"));
        playerDao.save(player);
    }
}
