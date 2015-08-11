package kz.e16training.serialization;

import kz.e16training.serialization.controller.Controller;

import java.io.IOException;


/**
 * @author DK
 * @version 1.0.0
 *
 */
public class Run {

    public static void main(String[] args) {
        try {
            Controller controller = new Controller();
            controller.mainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
