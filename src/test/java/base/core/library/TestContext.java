package base.core.library;

public class TestContext {

    private static String registeredEmail;


    public static void setRegisteredEmail(String email) {
        registeredEmail = email;
    }

    public static String getRegisteredEmail() {
        return registeredEmail;
    }

}

