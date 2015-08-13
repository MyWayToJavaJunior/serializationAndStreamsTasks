package kz.e16training.serialization;

import kz.e16training.serialization.model.Movie;
import kz.e16training.serialization.model.MovieCollection;

import java.util.Scanner;

/**
 * Main controller.
 *
 */
public class Controller {
    private MovieCollection movies;
    private Scanner scanner = new Scanner(System.in);
    private Movie movie;

    public Controller() {
        movies = new MovieCollection();
    }

    public void mainMenu() {
        String choice;
        while(!MainMenu.EXIT.getNumber().equals(choice = scanner.nextLine())) {
            showMainMenu();
            if (MainMenu.VIEW_ALL.getNumber().equals(choice)) {
                showAllMovies();
            } else if (MainMenu.DEL.getNumber().equals(choice)) {
                delMovies();
            } else if (MainMenu.ADD_NEW.getNumber().equals(choice)) {
                addMovie();
            }

        }
    }

    private void addMovie() {
        movies.addMovie(getMovie());
    }

    private void delMovies() {
        movies.removeMovie(getNumberOfMovie());
    }

    private int getNumberOfMovie() {
        showAllMovies();
        askForNumberOfMovie();
        return scanner.nextInt();
    }

    private void askForNumberOfMovie() {
        System.out.println("Type number of movie:");
    }

    private void showAllMovies() {
        System.out.println(movies);
    }

    private void showMainMenu() {
        for (MainMenu menu : MainMenu.values()) {
            System.out.println(menu + ". " + menu.option());
        }
    }

    public Movie getMovie() {

        return movie;
    }
}
