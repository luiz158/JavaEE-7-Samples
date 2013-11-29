///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package org.javaee7.crudexam.web;
//
//import java.sql.Date;
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.security.auth.message.MessageInfo;
//import org.javaee7.crudexam.model.Book;
//import org.javaee7.crudexam.sessions.ContactFacade;
//
///**
// *
// * @author Masud
// */
//@ManagedBean
//@SessionScoped
//public class ContactController {
//     @EJB
//    private ContactFacade contactFacade;
//    private Book contact;
////    private MessageInfo message;
//
//    public Book getContact() {
//        return contact;
//    }
//
//    public void setContact(Book contact) {
//        this.contact = contact;
//    }
//
//
//    /** Creates a new instance of ContactController */
//    public ContactController() {
//        contact = new Book();
//    }
//
//    public void addContact(){
//        Date currentdate= new Date();
//        String email = contact.getContactEmail();
//            if(!email.matches(".+@.+\\.[a-z]+")){
//                message.ErrorMessage("Email không hợp lệ");
//            }else if(email.matches(".+@.+\\.[a-z]+")){
//                  contact.setContactStatus("New");
//                  contact.setContactDate(currentdate);
//                  contact = contactFacade.addContact(contact);
//
//                  message.SuccessMessage("We will send you message as soon as possible.");
//                  contact = null;
//            }
//    }    
//}
