package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Valkyrja on 03.03.2016.
 */
public class SessionHelper extends HelperBase {

    private WebDriver wd;

    public SessionHelper(WebDriver wd) {
        super(wd);
    }
    public void login(String username, String passwrd) {
        type(By.name("user"), username);
        type(By.name("pass"), passwrd);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }

}
