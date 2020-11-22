package io.vs.redis.cache.controller;

import io.vs.redis.cache.data.UserRepository;
import io.vs.redis.cache.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("rest/user")
public class UserResource {

    private UserRepository userRepository;

    @Autowired
    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add/{id}/{name}/{salary}")
    public User add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name,
                    @PathVariable("salary") final Long salary) {

        userRepository.save(new User(id, name, salary));

        return userRepository.findById(id);
    }

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public User add(@RequestBody final User user) {

        userRepository.save(user);

        return userRepository.findById(user.getId());
    }

    @PutMapping("/add/{id}/{name}/{salary}")
    public User update(@PathVariable("id") final String id,
                       @PathVariable("name") final String name,
                       @PathVariable("salary") final Long salary) {

        userRepository.update(new User(id, name, salary));

        return userRepository.findById(id);
    }

    @GetMapping("/all")
    public Map<String, User> findAll() {
        return userRepository.findAll();
    }
}
