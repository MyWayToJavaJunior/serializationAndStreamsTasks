package kz.e16training.serialization;

import kz.e16training.serialization.controller.Controller;



/**
 * @author DK
 * @version 1.0.0
 *
 */
public class Run {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.load();
        controller.mainMenu();
        controller.save();
    }

}
