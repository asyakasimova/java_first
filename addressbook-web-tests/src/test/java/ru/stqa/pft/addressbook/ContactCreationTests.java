package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreationTests() throws Exception {
    contactCreationPage();
    fillingContactParameters(new ContactData("Asya", "Kasimova", "+7 495 111 11 11", "test address", "asya.kasimova@something.ru"));
    submittingNewContact();
    returnToHomePage();
  }

}
