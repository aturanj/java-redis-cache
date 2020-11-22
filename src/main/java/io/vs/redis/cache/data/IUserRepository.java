package io.vs.redis.cache.data;

import io.vs.redis.cache.model.User;

import java.util.Map;

public interface IUserRepository {

    public void save(User user);

    public Map<String, User> findAll();

    public User findById(String id);

    public void update(User user);

    public void delete(String id);
}
