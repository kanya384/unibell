package com.unibell.clients.repository;

import com.unibell.clients.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByClientId(Long clientId);

    @Query(value = "SELECT * FROM contact WHERE client_id = ?1 and contact_type = ?2", nativeQuery = true)
    List<Contact> findByClientIdAndContactType(Long clientId, String contactType);
}
