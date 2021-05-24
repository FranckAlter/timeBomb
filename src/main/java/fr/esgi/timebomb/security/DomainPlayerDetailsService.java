package fr.esgi.timebomb.security;

import fr.esgi.timebomb.dao.PlayerDao;
import fr.esgi.timebomb.domain.Player;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DomainPlayerDetailsService implements UserDetailsService {


    private final PlayerDao playerDao;

    public DomainPlayerDetailsService(PlayerDao userRepository) {
        this.playerDao = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player appUser = playerDao.findPlayerByUsername(username)
                .orElseThrow(() -> new AuthenticationServiceException("username " + username + " not found"));

        return User.builder()
                .username(username)
                .password(appUser.getPassword())
                .build();
    }
}
