//package com.kyocoolcool.springsecurity.productservice.mongo.bean;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
///**
// * @author 陳金昌 Chris Chen
// * @version 1.0 2021/1/29 4:08 PM
// */
//@Document
//public class Boss {
//        @Id
//        public String id;
//
//        public String firstName;
//        public String lastName;
//
//        public Boss() {}
//
//        public Boss(String firstName, String lastName) {
//            this.firstName = firstName;
//            this.lastName = lastName;
//        }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    @Override
//        public String toString() {
//            return String.format(
//                    "Customer[id=%s, firstName='%s', lastName='%s']",
//                    id, firstName, lastName);
//        }
//
//    }
