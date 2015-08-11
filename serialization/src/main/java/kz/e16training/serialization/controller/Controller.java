package kz.e16training.serialization.controller;

import kz.e16training.serialization.io.IO;
import kz.e16training.serialization.model.Actor;
import kz.e16training.serialization.model.Movie;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Controller.
 *
 */
public class Controller {
    private final static String MOVIES_COLLECTION = "movies";
    private final static String ACTORS_COLLECTION = "actors";
    private Set<Movie> moviesCollection;
    private Set<Actor> actorsCollection;
    private IO io;

    public Controller() throws IOException, ClassNotFoundException {
        if (isFileExists(MOVIES_COLLECTION) ||
                isFileExists(ACTORS_COLLECTION)) {
            this.moviesCollection = getMoviesFromDump();
            this.actorsCollection = getActorsFromDump();
        } else {
            this.moviesCollection = new HashSet<Movie>();
            this.actorsCollection = new HashSet<Actor>();
        }
        this.io = new IO();
    }

    private void printMoviesCollection() {
        io.printMoviesCollection(moviesCollection);
    }

    private void printActorsCollection() {
        io.printActorsCollection(actorsCollection);
    }

    private Movie getMovie() {
        String nameOfMovie = io.getMovieName();
        Set<Actor> actorsOfMovie = getActorsOfMovie();
        return new Movie(nameOfMovie, actorsOfMovie);
    }

    private Actor getNewActor() {
        return new Actor(io.getNewActorName(),
                io.getNewActorSurname());
    }

    private Set<Actor> getActorsOfMovie() {
        String choice;
        Set<Actor> actors = new HashSet<Actor>();
        Actor actor;
        while (true) {
            printActorsCollection();
            if ("exit".equals(choice = io.getTypeOfInput()))
                break;
            if ("new".equals(choice)) {
                actor = getNewActor();
                actorsCollection.add(actor);
            } else {
                actor = io.getActorFromCollection(
                        actorsCollection);
            }
            if (actor != null) actors.add(actor);
        }
        return actors;
    }

    private void removeMovieBy(Movie movie) {
        moviesCollection.remove(movie);
    }

    private boolean isFileExists(String nameOfFile) {
        return (new File(nameOfFile)).exists();
    }

    private Set<Movie> getMoviesFromDump() throws IOException,
            ClassNotFoundException {
        InputStream in = new FileInputStream(MOVIES_COLLECTION);
        ObjectInputStream oin = new ObjectInputStream(in);
        return  (Set<Movie>) oin.readObject();
    }

    private Set<Actor> getActorsFromDump() throws IOException,
            ClassNotFoundException {
        InputStream in = new FileInputStream(ACTORS_COLLECTION);
        ObjectInputStream oin = new ObjectInputStream(in);
        return (Set<Actor>) oin.readObject();
    }

    private void saveCollection(String nameOfFile, Set collection)
            throws IOException {
        OutputStream os = new FileOutputStream(nameOfFile);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(collection);
    }

    private void saveCollections() {
        try {
            saveCollection(ACTORS_COLLECTION, actorsCollection);
            saveCollection(MOVIES_COLLECTION, moviesCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mainMenu() {
        String choice;
        while (!("0".equals(choice = io.getMainMenuChoice()))) {
            if ("2".equals(choice)) {
                moviesCollection.add(getMovie());
            } else if ("3".equals(choice)) {
                Movie movie = io.getMovieForDel(moviesCollection);
                if (movie != null) removeMovieBy(movie);
            } else {
                printMoviesCollection();
            }
        }
        saveCollections();
    }
}
