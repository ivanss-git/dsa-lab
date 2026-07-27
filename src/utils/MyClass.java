package utils;

import java.util.logging.Logger;

public class MyClass {
    private MyClass() {
        /* This utility class should not be instantiated */
    }

    // Class-level logger setup
    private static final Logger logger = Logger.getLogger(MyClass.class.getName());

    // This method must exist and be 'static' for MyClass.log() to work
    public static void log(String result) {
        logger.info(result);
    }
    // 2. Added Overload: Automatically handles naked boolean values (true/false)
    public static void log(boolean value) {
        logger.info(String.valueOf(value));
    }

    // 3. Pro-Tip Overload: Clean format option to pass anything as a single object
    public static void log(Object obj) {
        logger.info(obj == null ? "null" : obj.toString());
    }
}

