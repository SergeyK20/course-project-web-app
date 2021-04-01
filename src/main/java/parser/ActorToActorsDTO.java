package parser;

import dto.ActorDTO;
import entity.Actor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ActorToActorsDTO implements Parse<Actor, ActorDTO> {

    @Override
    public ActorDTO parse(Actor actor) throws NullPointerException {
        Objects.requireNonNull(actor);

        return new ActorDTO(
                actor.getIdActor(),
                actor.getNameActor()
        );
    }

    @Override
    public Set<ActorDTO> parseCollection(Set<Actor> actors) throws NullPointerException {
        Objects.requireNonNull(actors);

        Set<ActorDTO> actorsDTO = new HashSet<>();
        actors.stream().forEach(actor -> actorsDTO.add(parse(actor)));
        return actorsDTO;
    }
}
