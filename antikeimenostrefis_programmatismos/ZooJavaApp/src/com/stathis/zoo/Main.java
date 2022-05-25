package com.stathis.zoo;

import com.stathis.zoo.util.UI;
import com.stathis.zoo.util.ZooImpl;

public class Main {

    /**
     * App entry point. Initializes an instance of the ZooImpl and UI.
     * After that, the ui methods are called.
     */

    public static void main(String[] args) {
        ZooImpl zoo = new ZooImpl();
        UI ui = new UI();
        ui.loadDataFromFile(zoo);
        ui.showHeaderInfo();
        ui.performAction(zoo);
    }
}
