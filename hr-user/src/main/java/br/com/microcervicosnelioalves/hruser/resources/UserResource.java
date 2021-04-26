package br.com.microcervicosnelioalves.hruser.resources;

import br.com.microcervicosnelioalves.hruser.entites.User;
import br.com.microcervicosnelioalves.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = repository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User object = repository.findById(id).get();
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User object = repository.findByEmail(email);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
}
