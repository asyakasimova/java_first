package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.GroupData11;

/**
 * Created by Valkyrja on 01.03.2016.
 */
public class GroupHelper extends HelperBase {


    public GroupHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData11 groupData11) {
        type(By.name("group_name"), groupData11.getName1());
        type(By.name("group_header"), groupData11.getHeader1());
        type(By.name("group_footer"), groupData11.getFooter1());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.xpath("//div[@id='content']/form/input[5]"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }
}
