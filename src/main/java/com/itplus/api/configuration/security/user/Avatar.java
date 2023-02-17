//package com.itplus.api.configuration.security.user;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "avatar")
//public class Avatar {
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue
//    private long id;
//
//    @Column(name = "avatar")
//    private String avatar;

//    @JsonBackReference
//    @ManyToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST},targetEntity =User.class)
//    @JoinColumn(name = "user_id")
//    private User user;
//}
