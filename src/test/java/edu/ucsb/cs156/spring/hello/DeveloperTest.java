package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-f25-teams>
        assertEquals("Derek", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-f25-teams>
        assertEquals("derekkirschbaum", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("f25-00", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Daniel"),"Team should contain Daniel");
        assertTrue(t.getMembers().contains("Kate"),"Team should contain Kate");
        assertTrue(t.getMembers().contains("Divyani"),"Team should contain Divyani");
        assertTrue(t.getMembers().contains("Sanjay"),"Team should contain Sanjay");
        assertTrue(t.getMembers().contains("Samuel"),"Team should contain Samuel");
        assertTrue(t.getMembers().contains("Derek"),"Team should contain Derek");
        assertTrue(t.getMembers().contains("Phill"),"Team should contain Phill");
        // ... etc
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
