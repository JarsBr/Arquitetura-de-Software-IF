package br.ifg.urutai.adapter.repository;

import br.ifg.urutai.entity.User;
import br.ifg.urutai.usercase.port.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> inMemoryDb = new HashMap<>();

    @Override
    public User create(final User user) {
        inMemoryDb.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(final String id){
        return Optional.ofNullable(inMemoryDb.get(id));
    }

    @Override
    public Optional<User> findByEmail(final String email) {
        return inMemoryDb.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny();
    }

    public List<User> findAllUsers() {
        return new ArrayList<>(inMemoryDb.values());
    }
}
