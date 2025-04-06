package base.core.library;

import java.time.Duration;

public class Constants {

    public static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(15);

    public static final class Platforms {
        public static final String ANDROID = "android";
        public static final String IOS = "ios";
    }

    public static final class Apps {
        public static final String ANDROID = "/Users/iqramanzoor/Downloads/qacodechallenge/src/test/resources/apps/app-debug.apk";
    }

    public static final class Errors {
        public static final String INVALID_EMAIL = "Invalid email";
        public static final String INVALID_PASSWORD = "Invalid password";
        public static final String INVALID_LAST_NAME = "Invalid Last name";
        public static final String USER_ALREADY_EXISTS = "User already exists";
        public static final String INVALID_FIRST_NAME = "Invalid First name";
    }

}
