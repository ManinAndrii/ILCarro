import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        if(isLogged()) logout();
    }
    @Test
    public void registrationPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "John",
                "Smith",
                "john_" + i + "@mail.com",
                "Li12345$"
        );

        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
        logger.info("RegistrationPositive -->"+user.getName()+" "+user.getLastName()+" , "+user.getEmail()+" , "+user.getPassword());
        Assert.assertTrue(isLoggedSuccess());
    }

    @Test
    public void registrationNegativeTestWrongName() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "  ",
                "Smith",
                "john_" + i + "@mail.com",
                "Li12345$");

        openRegistrationForm();
        fillRegistrationForm(user);
        logger.info("RegistrationNegativeWrongName -->"+user.getName()+" "+user.getLastName()+" , "+user.getEmail()+" , "+user.getPassword());


    }
    @Test
    public void registrationNegativeTestWrongLastName() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "John",
                "  ",
                "john_" + i + "@mail.com",
                "Li12345$");

        openRegistrationForm();
        fillRegistrationForm(user);
        logger.info("RegistrationNegativeWrongLastName -->"+user.getName()+" "+user.getLastName()+" , "+user.getEmail()+" , "+user.getPassword());


    }
    @Test
    public void registrationNegativeTestWrongEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "John",
                "Smith",
                "john_" + i + "mail.com",
                "Li12345$");

        openRegistrationForm();
        fillRegistrationForm(user);
        logger.info("RegistrationNegativeWrongEmail -->"+user.getName()+" "+user.getLastName()+" , "+user.getEmail()+" , "+user.getPassword());


    }
    @Test
    public void registrationNegativeTestWrongPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "John",
                "Smith",
                "john_" + i + "@mail.com",
                "Li12345");

        openRegistrationForm();
        fillRegistrationForm(user);
        logger.info("RegistrationNegativeWrongPassword -->"+user.getName()+" "+user.getLastName()+" , "+user.getEmail()+" , "+user.getPassword());


    }

}