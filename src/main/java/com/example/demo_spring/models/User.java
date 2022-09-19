package com.example.demo_spring.models;

import com.example.demo_spring.models.enums.Gender;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private int age;

    @Column
    private UUID activationToken;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime registered;

    @Column
    private LocalDateTime updated;


    @PrePersist
    public void onCreate() {
        this.created = LocalDateTime.now();
        this.updated = created;
    }

    @PreUpdate
    public void onUpdate() {
        this.updated = LocalDateTime.now();
    }

//    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, orphanRemoval = true)
//    private List<Article> articles = new ArrayList<>();

//    @JoinTable(name = "user_addresses",
//            joinColumns = {
//                    @JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "address_id", referencedColumnName = "id")})
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Address address;

}
