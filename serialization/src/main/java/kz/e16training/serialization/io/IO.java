package kz.e16training.serialization.io;

import kz.e16training.serialization.model.Actor;
import kz.e16training.serialization.model.Movie;

import java.util.Scanner;
import java.util.Set;

/**
 * Input - output.
 *
 */
public class IO {
    private static final String ASK_FOR_ACTOR_NUMBER =
            "Type the number of actor:";
    private static final String ASK_FOR_NEW_ACTOR_NAME =
            "Type name for new actor:";
    private static final String ASK_FOR_NEW_ACTOR_SURNAME =
            "Type surname for new actor:";
    private static final String MAIN_MENU =
            "Type select:\n1. View movies collection\n" +
                    "2. Add new movie to collection\n" +
                    "3. Remove movie from collection\n0. Exit program";
    private static final String ASK_FOR_INDEX_OF_MOVIE_FOR_DEL =
            "Type index of movie for delete:";
    private final static String ASK_FOR_MOVIE_NAME =
            "Type name for movie:";
    private static final String ASK_FOR_INPUT_TYPE_OF_ACTOR =
            "Type input type of actor numb/new or exit:";
    private Scanner scanner = new Scanner(System.in);

    private void print(String stringForPrint) {
        System.out.println(stringForPrint);
    }

    private void askForMovieName() {
        print(ASK_FOR_MOVIE_NAME);
    }

    private String getString() {
        return scanner.nextLine();
    }

    private void askForActorNumber() {
        print(ASK_FOR_ACTOR_NUMBER);
    }

    private void askForNewActorName() {
        print(ASK_FOR_NEW_ACTOR_NAME);
    }

    private void askIndexOfMovieForDel() {
        print(ASK_FOR_INDEX_OF_MOVIE_FOR_DEL);
    }

    private void viewMainMenu() {
        print(MAIN_MENU);
    }

    private void askForNewActorSurname() {
        print(ASK_FOR_NEW_ACTOR_SURNAME);
    }

    private void askForInputTypeOfActor() {
        print(ASK_FOR_INPUT_TYPE_OF_ACTOR);
    }

    public void printActorsCollection(Set<Actor> actorsCollection) {
        int count = 0;
        for (Actor actor : actorsCollection) {
            print(count++ + " : " + actor);
        }
    }

    public String getMovieName() {
        askForMovieName();
        return getString();
    }

    public String getNewActorName() {
        askForNewActorName();
        return getString();
    }

    public Actor getActorFromCollection(Set<Actor> actorsCollection) {
        printActorsCollection(actorsCollection);
        askForActorNumber();
        String userChoice = getString();
        int count = 0;
        for (Actor actor : actorsCollection) {
            if (userChoice.equals(String.valueOf(count++)))
                return actor;
        }
        return null;
    }

    public String getNewActorSurname() {
        askForNewActorSurname();
        return getString();
    }

    public String getMainMenuChoice() {
        viewMainMenu();
        return getString();
    }

    public void printMoviesCollection(Set<Movie> moviesCollection) {
        int count = 0;
        for (Movie movie : moviesCollection) {
            System.out.println(count++ + " : " + movie.toString());
        }
    }

    public Movie getMovieForDel(Set<Movie> moviesCollection) {
        printMoviesCollection(moviesCollection);
        askIndexOfMovieForDel();
        String userChoice = getString();
        int count = 0;
        for (Movie movie : moviesCollection) {
            if (userChoice.equals(String.valueOf(count++)))
                return movie;
        }
        return null;
    }

    public String getTypeOfInput() {
        askForInputTypeOfActor();
        return getString();
    }
}
