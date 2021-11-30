package io.ckt.springboot.VRConcert.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "first_name", updatable = true, nullable = false)
    private String firstname;
    @Column(name = "last_name", updatable = true, nullable = false)
    private String lastname;
    @Column(name = "birthbay", updatable = false, nullable = false)
    private String birthday;
    @Column(name = "email", updatable = false, nullable = false)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "roles", updatable = true, nullable = true)
    private Collection<Role> roles = new ArrayList<>();
    @Column(name = "password", updatable = true, nullable = false)
    private String password;
    @Column(name = "is_valid", updatable = true, nullable = false)
    private Boolean isValid;
    @Column(name = "create_date", updatable = false, nullable = false)
    private String createDate;
    @Column(name = "update_date", updatable = true, nullable = false)
    private String updateDate;
}
