package com.unibell.clients.repository;

import com.unibell.clients.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@SpringBootTest
@Testcontainers
@Transactional
@Import(TestDatabaseConfiguration.class)
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void shouldBeEmptyContactList() {
        List<Contact> contactList = contactRepository.findByClientId(999L);
        Assertions.assertEquals(0, contactList.size());
    }

    @Test
    public void shouldReturn1Contact() {
        Client client = new Client();
        client.setName("test - 1");

        clientRepository.save(client);

        Contact contact = new Phone();
        contact.setValue("79627680000");
        contact.setClient(client);
        contactRepository.save(contact);

        List<Contact> contacts = contactRepository.findByClientId(client.getId());

        Assertions.assertEquals(1, contacts.size());
    }

    @Test
    public void shouldReturnOnlyEmail() {
        Client client = new Client();
        client.setName("test - 2");
        clientRepository.save(client);

        Contact phone = new Phone();
        phone.setValue("79627680000");
        phone.setClient(client);
        contactRepository.save(phone);

        Contact email = new Email();
        email.setValue("test01@mail.ru");
        email.setClient(client);
        contactRepository.save(email);

        List<Contact> contacts = contactRepository.findByClientIdAndContactType(client.getId(), ContactType.EMAIL.toString());

        Assertions.assertEquals(1, contacts.size());
        Assertions.assertEquals("Email", contacts.getFirst().getClass().getSimpleName());
    }

    @Test
    public void shouldReturnOnlyPhone() {
        Client client = new Client();
        client.setName("test - 3");
        clientRepository.save(client);

        Contact phone = new Phone();
        phone.setValue("79627680000");
        phone.setClient(client);
        contactRepository.save(phone);

        Contact email = new Email();
        email.setValue("test01@mail.ru");
        email.setClient(client);
        contactRepository.save(email);

        List<Contact> contacts = contactRepository.findByClientIdAndContactType(client.getId(), ContactType.PHONE.toString());

        Assertions.assertEquals(1, contacts.size());
        Assertions.assertEquals("Phone", contacts.getFirst().getClass().getSimpleName());
    }
}
