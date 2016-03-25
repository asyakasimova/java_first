package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.addressbook.model.ContactData;



import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Valkyrja on 25.03.2016.
 */
public class ContactInformationTests extends TestBase {

    @BeforeMethod
    public void ensureContactPreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withUsername("Asya1").withFamilyName("Kasimova").withHomePhone("+7 111"), true);
        }
    }

    @Test
    public void testContactInformation() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        String viewData = app.contact().view(contact);
        viewData = viewData.replaceAll("\\s+", " ");

        MatcherAssert.assertThat(viewData, CoreMatchers.equalTo(editData(contactInfoFromEditForm)));
    }

    private String editData (ContactData contact) {
        return Arrays.asList(contact.getUsername(), contact.getFamilyName(), cleaned(contact.getAddress()), homePhone(contact.getHomePhone()), mobilePhone(contact.getMobilePhone()),
                workPhone(contact.getWorkPhone()), mailReworked(contact.getMail1()), mailReworked(contact.getMail2()), mailReworked(contact.getMail3())).stream().filter((c) -> ! c.equals("null")).collect(Collectors.joining(" "));
    }

    public String mailReworked (String mail) {
        if (mail != null) {
            VerbalExpression re = VerbalExpression.regex().find("@").capture().anything().endCapture().build();
            String domain = re.getText(mail, 1);
            mail = mail + " (www." + domain + ")";
        }
        return mail;
    }

    public String cleaned(String address) {
        return address.replaceAll("\\s+", " ");
    }

    public String homePhone (String home) {
        home = "H: " + home;
        return home;
    }

    public String mobilePhone (String mobile) {
        mobile = "M: " + mobile;
        return mobile;
    }

    public String workPhone (String work) {
        work = "W: " + work;
        return work;
    }

    public String unlink (String url) {

        return url;
    }


}
