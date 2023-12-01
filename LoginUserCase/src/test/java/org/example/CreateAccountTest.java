package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateAccountTest {


    @Test
    void isuserID() {
        assertEquals(CreateAccount.Account("","gthy","jhf4ir84ytehghh")"Invalid User ID!");
    }


    @Test
    void ispassword() {
        assertEquals(CreateAccount.Account("","gBYJS","jhf4irHY84ytKIKRehghh")"Invalid User password!");
    }

    @Test
    void isemail() {
        assertEquals(CreateAccount.Account("","gthy","jhf4ir84ytehghh")"Invalid Email Address!");
    }

    @Test
    void checkExistingID() {
        assertEquals(CreateAccount.Account("ExistingID")"User ID already exists!");
    }

    @Test
    void checkExistingEmail() {
        assertEquals(CreateAccount.Account("ExistingEmail@address.com")"Email Address already exists!");
    }


}