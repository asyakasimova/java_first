package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Phones;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valkyrja on 27.03.2016.
 */
public class ContactDataGenerator {

    @Parameter (names = "-c", description = "Contacts count")
    public int count;

    @Parameter (names = "-f", description = "Target file")
    public String file;

    @Parameter (names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        }else {
            System.out.println("Unrecognised format " + format);
        }

    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts){
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getUsername(), contact.getFamilyName(), contact.getAddress(), contact.getHomePhone(), contact.getEmail(), contact.getPhotoname()));
        }
        writer.close();
    }

    private  List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {

            contacts.add(new ContactData().withUsername(String.format("Asya %s", i)).withFamilyName(String.format("Kas %s", i)).withAddress(String.format("address %s", i))
                    .withPhones(new Phones().withHome(String.format("+7 495 %s", i)).withMobile(String.format("+7 496 %s", i)).withWork(String.format("+7 497 %s", i)))
                    .withEmail(String.format("a.kas%s@mail.ru", i)).withPhotoname(String.format("photo%s", i)));
        }
        return contacts;
    }


}
