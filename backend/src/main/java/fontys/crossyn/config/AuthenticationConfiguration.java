package fontys.crossyn.config;

public class AuthenticationConfiguration {
    public static final String SECRET = "BigSecret";
    public static final long EXPIRATION_TIME = 2 * 60 * 1000; // 1 minute
    public static final long REFRESH_EXPIRATION_TIME = 10 * 60 * 1000; // 10 minutes
    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "auth_token";
    public static final String REFRESH_HEADER_STRING = "refresh_token";


    //URLs
    public static final String SIGN_UP_URL = "/account";
    public static final String REFRESH_URL = SIGN_UP_URL + "/token/refresh";
    public static final String LOGIN_URL = "/login";
}
