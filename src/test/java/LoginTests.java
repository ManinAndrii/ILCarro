import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(isLogged()) logout();
    }

    @Test
    public void loginPositiveTest1(){
        openLoginForm();
        fillLoginForm("skrydj1984@mail.com", "Ll12345$");
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());

    }

    public void loginPositiveTestProperties(){
        openLoginForm();
        fillLoginForm(getEmail(), getPassword());
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());

    }
    @Test
    public void loginPositiveTestModel(){
        User user = new User()
                .withEmail("skrydj1984@mail.com")
                .withPassword("Ll12345$");
        openLoginForm();
        fillLoginForm(user.getEmail(), user.getPassword());
        submitLogin();
        assertTrue(isLoggedSuccess());
        logger.info("LoginPositiveTestModel -->" + user.getEmail() + " & " + user.getPassword());
    }

    @AfterMethod
    public void postcondition(){
        clickOkButton();
    }

}