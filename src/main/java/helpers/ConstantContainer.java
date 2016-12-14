package helpers;


public class ConstantContainer {

    public static final String SUBJECT_TEXT = RandomString.getRandomStringEng(8);
    public static final String MESSAGE_TEXT = RandomString.getRandomStringEng(70);
    public static final String SIGNATURE1_TEXT = PropertyProvider.getProperty("signature_user1");
    public static final String SPAMPAGE_EXPECTED_RESULT = PropertyProvider.getProperty("user_name");
    public static final String LOGIN_USER1 = PropertyProvider.getProperty("login_user1");
    public static final String LOGIN_USER2 = PropertyProvider.getProperty("login_user2");
    public static final String LOGIN_USER3 = PropertyProvider.getProperty("login_user3");
    public static final String PASSWORD_USER1 = PropertyProvider.getProperty("password_user1");
    public static final String PASSWORD_USER2 = PropertyProvider.getProperty("password_user2");
    public static final String PASSWORD_USER3 = PropertyProvider.getProperty("password_user3");

}
