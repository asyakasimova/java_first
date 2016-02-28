package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class groupCreationTests extends  TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData11("test1", "test2", "test3"));
        submitGroupCreation();
        gotoGroupPage();
    }

}
