package openhouse.handlers;

import openhouse.dto.Users;
import openhouse.exception.SfaException;
import openhouse.repositories.ReactiveUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class UsersHandler {

    @Autowired
    private ReactiveUsersRepository usersRepository;

    public UsersHandler(ReactiveUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Mono<ServerResponse> allUser(ServerRequest serverRequest) {
        Flux<Users> users = this.usersRepository.findAll();
        return ServerResponse.ok().body(users, Users.class);
    }

    public Mono<ServerResponse> byUserId(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<Users> user = this.usersRepository.findById(Integer.parseInt(id));
        return ServerResponse.ok().body(user, Users.class);
    }

    public Mono<ServerResponse> insertUser(ServerRequest serverRequest) {
        Mono<Users> user = serverRequest.bodyToMono(Users.class);
        return ServerResponse.ok().body(user.flatMap(this.usersRepository::save), Users.class);
    }

    public Mono<ServerResponse> updateUser(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<Users> existingUserMono = this.usersRepository.findById(Integer.parseInt(id));
        Mono<Users> userMono = serverRequest.bodyToMono(Users.class);
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return userMono.zipWith(existingUserMono,
                (user, existingUser) ->
                        new Users(existingUser.getId(), user.getName(), user.getEmail(), user.getSex(),user.getDepartment())
        ).flatMap(user ->
                        ServerResponse.ok().contentType(APPLICATION_JSON).body(this.usersRepository.save(user), Users.class)
                ).switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> deleteUser(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok().build(this.usersRepository.deleteById(Integer.parseInt(id)).switchIfEmpty((Mono.error(new SfaException("Delete not empty")))));
    }
}
