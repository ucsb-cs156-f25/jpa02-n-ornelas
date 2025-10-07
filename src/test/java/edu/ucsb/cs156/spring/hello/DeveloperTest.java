package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Nataly G.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("n-ornelas", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("f25-13", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Amy L."), "Team should contain Amy L.");
        assertTrue(t.getMembers().contains("Tim C."), "Team should contain Tim C.");
        assertTrue(t.getMembers().contains("Yulin Y."), "Team should contain Yulin Y.");
        assertTrue(t.getMembers().contains("Hao D."), "Team should contain Hao D.");
        assertTrue(t.getMembers().contains("Jackson C."), "Team should contain Jackson C.");
        assertTrue(t.getMembers().contains("Nataly G."), "Team should contain Nataly G.");

    }
}
