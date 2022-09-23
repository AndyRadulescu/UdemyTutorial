package com.example.udemytutorial.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@ToString
public class Customer {

    @Id
    @Column(name = "id")
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Getter
    @Setter
    private UUID id;

    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;
}
