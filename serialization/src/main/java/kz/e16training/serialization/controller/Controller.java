package kz.e16training.serialization.controller;

import kz.e16training.serialization.io.IO;
import kz.e16training.serialization.model.Actor;
import kz.e16training.serialization.model.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Controller.
 *
 */
public class Controller implements Serializable{
    private final static String MOVIES_COLLECTION = "movies";
    private final static String ACTORS_COLLECTION = "actors";
    private List<Movie> moviesCollection;
    private List<Actor> actorsCollection;
    transient private IO io;

    public Controller() {
        this.moviesCollection = new ArrayList<Movie>();
        this.actorsCollection = new ArrayList<Actor>();
        this.io = new IO();
    }

    private void printMoviesCollection() {
        io.printMoviesCollection(moviesCollection);
    }

    private Movie getMovie() {
        String nameOfMovie = io.getMovieName();
        Set<Actor> actorsOfMovie = getActorsOfMovie();
        return new Movie(nameOfMovie, actorsOfMovie);
    }

    private Actor getNewActor() {
        return new Actor(io.getNewActorName(), io.getNewActorSurname());
    }

    private Set<Actor> getActorsOfMovie() {
        String choice;
        Set<Actor> actors = new HashSet<Actor>();
        Actor actor;
        while (!"exit".equals(choice = io.getUserChoice(actorsCollection))) {
            if ("new".equals(choice)) {
                actor = getNewActor();
                actorsCollection.add(actor);
            } else {
                actor = actorsCollection.get(Integer.valueOf(choice));
            }
            if (!(actor == null)) actors.add(actor);
        }
        return actors;
    }

    private void removeMovieByIndex(int index) {
        moviesCollection.remove(index);
    }

    private boolean isFilesExists() {
        File actorsFile = new File(ACTORS_COLLECTION);
        File moviesFile = new File(MOVIES_COLLECTION);
        return  (actorsFile.exists() || moviesFile.exists());
    }

    private void loadMovies() throws IOException, ClassNotFoundException {
        InputStream in = new FileInputStream(MOVIES_COLLECTION);
        ObjectInputStream oin = new ObjectInputStream(in);
        moviesCollection = (List<Movie>) oin.readObject();
    }

    private void loadActors() throws IOException, ClassNotFoundException {
        InputStream in = new FileInputStream(ACTORS_COLLECTION);
        ObjectInputStream oin = new ObjectInputStream(in);
        actorsCollection = (List<Actor>) oin.readObject();
    }

    private void saveMovies() throws IOException {
        OutputStream os = new FileOutputStream(MOVIES_COLLECTION);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(moviesCollection);
    }

    private void saveActors() throws IOException {
        OutputStream os = new FileOutputStream(ACTORS_COLLECTION);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(actorsCollection);
    }

    public void mainMenu() {
        String choice;
        while (!("0".equals(choice = io.getMainMenuChoice()))) {
            if ("2".equals(choice)) {
                moviesCollection.add(getMovie());
            } else if ("3".equals(choice)) {
                printMoviesCollection();
                removeMovieByIndex(Integer.valueOf(io.getIndexOfMovieForDel()));
            } else {
                printMoviesCollection();
            }
        }
    }

    public void save() {
        try {
            saveActors();
            saveMovies();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        if (!isFilesExists()) return;
        try {
            loadActors();
            loadMovies();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
