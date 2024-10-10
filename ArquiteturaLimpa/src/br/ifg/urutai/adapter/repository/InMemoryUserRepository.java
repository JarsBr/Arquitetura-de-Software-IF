package br.ifg.urutai.adapter.repository;

import br.ifg.urutai.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserRepository {

    private final Map<String, User> inMemory = new HashMap<>();

    @Override
    public User create(final User user) {
        inMemory.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(final String id){
        return Optional.ofNullable(inMemory.get(id));
    }

    @Override
    public Optional
}
