package kz.e16training.serialization.model;


import java.io.Serializable;
import java.util.Set;

/**
 * Movie.
 *
 */
public class Movie implements Serializable{
    private String nameOfMovie;
    private Set<Actor> actors;

    public Movie(String nameOfMovie, Set<Actor> actors) {
        this.nameOfMovie = nameOfMovie;
        this.actors = actors;
    }

    public String actorsToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(actors.size()).append(" : [ ");
        for (Actor actor : actors) {
            sb.append(actor).append(" : ");
        }
        sb.delete(sb.length() - 2, sb.length()).append("] ");
        return sb.toString();
    }

    @Override
    public String toString() {
        return nameOfMovie + " : " + actorsToString();
    }
}
