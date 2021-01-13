package com.hcl.ecommerce3;

import com.hcl.ecommerce3.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class TestAuth {

    @BeforeEach
    public void setup(){
        Authentication.list.add(User.builder().name("Orion").password("orion").build());
        Authentication.list.add(User.builder().name("admin").password("admin").build());
        Authentication.list.add(User.builder().name("Steve").password("Jobs").build());
        Authentication.list.add(User.builder().name("Dale").password("Junior").build());
        Authentication.list.add(User.builder().name("Big").password("Badwolf").build());
        Authentication.list.add(User.builder().name("admin").password("failure").build());
    }

    @Test
    public void testLogin() {
        Authentication authentication = new Authentication();
        assertTrue(authentication.login("Orion", "orion"));
    }

    @Test
    public void testWrongInfoLogin() {
        Authentication authentication = new Authentication();
        assertFalse(authentication.login("This test", "Will fail"));
    }

    @Test
    public void testCurrentUser() {
        Authentication authentication = new Authentication();
        assertTrue(authentication.login("Orion", "orion"));
        assertEquals("Orion",authentication.getCurrentUser().getName());
        assertEquals("orion",authentication.getCurrentUser().getPassword());
    }

    @Test
    public void testAdmin(){
        Authentication authentication = new Authentication();
        assertTrue(authentication.login("admin","admin"));
        assertTrue(authentication.isAdmin());
    }

    @Test
    public void testNotAdmin(){
        Authentication authentication = new Authentication();
        assertTrue(authentication.login("admin","failure"));
        assertFalse(authentication.isAdmin());
    }
}
