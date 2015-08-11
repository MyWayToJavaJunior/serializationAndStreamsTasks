package kz.e16training.serialization.io;

import kz.e16training.serialization.model.Actor;
import kz.e16training.serialization.model.Movie;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

/**
 * Input - output.
 *
 */
public class IO implements Serializable{
    private static final String ASK_FOR_ACTOR_NUMBER = "Type the number of actor(or exit or new):";
    private static final String ASK_FOR_NEW_ACTOR_NAME = "Type name for new actor:";
    private static final String ASK_FOR_NEW_ACTOR_SURNAME = "Type surname for new actor:";
    private static final String MAIN_MENU = "Type select:\n1. View movies collection\n2. Add new movie to collection\n3. Remove movie from collection\n0. Exit program";
    private static final String ASK_FOR_INDEX_OF_MOVIE_FOR_DEL = "Type index of movie for delete:";
    private Scanner scanner = new Scanner(System.in);
    private final static String ASK_FOR_MOVIE_NAME = "Type name for movie:";

    private void print(String stringForPrint) {
        System.out.println(stringForPrint);
    }

    private void askForMovieName() {
        print(ASK_FOR_MOVIE_NAME);
    }


    private String getString() {
        return scanner.nextLine();
    }

    public String getMovieName() {
        askForMovieName();
        return getString();
    }

    private void printCollection(List<Actor> actorsCollection) {
        for (int i = 0; i < actorsCollection.size(); i++) {
            print(i + " : " + actorsCollection.get(i));
        }
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

    public String getNewActorName() {
        askForNewActorName();
        return getString();
    }

    public String getUserChoice(List<Actor> actorsCollection) {
        askForActorNumber();
        printCollection(actorsCollection);
        return getString();
    }

    public String getNewActorSurname() {
        askForNewActorSurname();
        return getString();
    }

    public String getMainMenuChoice() {
        viewMainMenu();
        return getString();
    }

    public void printMoviesCollection(List<Movie> moviesCollection) {
        for (int i = 0; i < moviesCollection.size(); i++) {
            print(i + " : " + moviesCollection.get(i).toString());
        }
    }

    public String getIndexOfMovieForDel() {
        askIndexOfMovieForDel();
        return getString();
    }

}
