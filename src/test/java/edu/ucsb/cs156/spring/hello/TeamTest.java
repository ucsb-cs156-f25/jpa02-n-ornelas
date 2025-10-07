package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;
    Team t1;
    Team t2;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    // Case 1: same object
    @Test
    void equals_sameObject_isTrue() {
        team = new Team("A");
        assertTrue(team.equals(team));
    }

    // Case 2: different class
    @Test
    void equals_differentClass_isFalse() {
        team = new Team("A");
        Object o = "not a team";
        assertFalse(team.equals(o));
    }

    // Case 3a: name=T, members=T  -> true
    @Test
    void equals_sameName_sameMembers_isTrue() {
        t1 = new Team("A");
        t2 = new Team("A");
        t1.addMember("Bob");
        t2.addMember("Bob");
        assertTrue(t1.equals(t2));
        // symmetry
        assertTrue(t2.equals(t1));
    }

    // Case 3b: name=T, members=F -> false
    @Test
    void equals_sameName_diffMembers_isFalse() {
        Team t1 = new Team("A");
        t1.addMember("Bob");
        Team t2 = new Team("A");
        t2.addMember("Alice");
        assertFalse(t1.equals(t2));
        assertFalse(t2.equals(t1));
    }

    // Case 3c: name=F, members=T -> false
    @Test
    void equals_diffName_sameMembers_isFalse() {
        Team t1 = new Team("A");
        t1.addMember("Bob");
        Team t2 = new Team("B");
        t2.addMember("Bob");
        assertFalse(t1.equals(t2));
        assertFalse(t2.equals(t1));
    }

    // Case 3d: name=F, members=F -> false
    @Test
    void equals_diffName_diffMembers_isFalse() {
        Team t1 = new Team("A");
        t1.addMember("Bob");
        Team t2 = new Team("B");
        t2.addMember("Alice");
        assertFalse(t1.equals(t2));
        assertFalse(t2.equals(t1));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    void testhash() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }

}
