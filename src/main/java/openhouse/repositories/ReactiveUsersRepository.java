package openhouse.repositories;

import openhouse.dto.Users;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ReactiveUsersRepository implements ReactiveCrudRepository<Users, Integer> {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Mono save(Users s) {
        if (s.getId()!= null) {
            return Mono.justOrEmpty(usersMapper.updateUser(s));
        } else {
            return Mono.justOrEmpty(usersMapper.insertUser(s));
        }
    }

    @Override
    public <S extends Users> Flux<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends Users> Flux<S> saveAll(Publisher<S> publisher) {
        return null;
    }

    @Override
    public Mono<Users> findById(Integer s) {
        return Mono.justOrEmpty(usersMapper.findUserById(s));
    }

    @Override
    public Mono<Users> findById(Publisher<Integer> publisher) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Integer s) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Publisher<Integer> publisher) {
        return null;
    }

    @Override
    public Flux<Users> findAll() {
        return Flux.fromIterable(usersMapper.findAllUser());
    }

    @Override
    public Flux<Users> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public Flux<Users> findAllById(Publisher<Integer> publisher) {
        return null;
    }

    @Override
    public Mono<Long> count() {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Integer s) {
        return usersMapper.deleteUserById(s);
    }

    @Override
    public Mono<Void> deleteById(Publisher<Integer> publisher) {
        return null;
    }

    @Override
    public Mono<Void> delete(Users users) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends Users> iterable) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends Users> publisher) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }
}
