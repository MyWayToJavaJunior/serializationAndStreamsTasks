package kz.e16training.serialization.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model of movie collection.
 *
 */
public class MovieCollection {
    private List<Movie> movies;

    public MovieCollection() {
        movies = new ArrayList<Movie>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(int indexOfMovie) {
        if (isIndexValid(indexOfMovie)) movies.remove(indexOfMovie);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (Movie movie: movies) {
            result.append(count++).append(" : ")
                    .append(movie).append("\n");
        }
        return result.toString();
    }

    public boolean isIndexValid(int indexOfMovie) {
        return indexOfMovie >= 0 && indexOfMovie < movies.size();
    }
}
