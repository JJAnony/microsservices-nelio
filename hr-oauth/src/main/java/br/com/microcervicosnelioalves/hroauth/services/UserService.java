package br.com.microcervicosnelioalves.hroauth.services;

import br.com.microcervicosnelioalves.hroauth.clients.UserClient;
import br.com.microcervicosnelioalves.hroauth.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserClient client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = client.findByEmail(username).getBody();
        if (user == null) {
            logger.error("Username not Found: " + username);
            throw new UsernameNotFoundException("Account not Found");
        }
        logger.error("Username Found: " + username);
        return user;
    }
}
