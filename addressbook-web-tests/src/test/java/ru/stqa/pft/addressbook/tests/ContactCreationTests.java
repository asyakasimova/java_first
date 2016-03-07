package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreationTests() throws Exception {
    app.getContactHelper().contactCreationPage();
    app.getContactHelper().fillingContactParameters(new ContactData("Asya", "Kasimova", "test address", "+7 495 111 11 11",  "asya.kasimova@something.ru"));
    app.getContactHelper().submittingNewContact();
    app.getContactHelper().returnToHomePage();
  }

}