package io.vs.redis.cache.controller;

import io.vs.redis.cache.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface IUserResource {

    @PostMapping("/add/{id}/{name}/{salary}")
    User add(@PathVariable("id") String id,
             @PathVariable("name") String name,
             @PathVariable("salary") Long salary);

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    User add(@RequestBody User user);

    @PutMapping("/add/{id}/{name}/{salary}")
    User update(@PathVariable("id") String id,
                @PathVariable("name") String name,
                @PathVariable("salary") Long salary);

    @GetMapping("/all")
    Map<String, User> findAll();

    @DeleteMapping("/del/{id}")
    Map<String, User> delete(@PathVariable("id") String id);
}
