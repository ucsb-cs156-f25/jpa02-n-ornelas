package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

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

    // Case 1: Same object
    @Test
    public void equals_returns_same_Object() {
        Team tmp = team;

        assert(team.equals(tmp));
    }

    // Case 2: Object is not a Team object; different type (i.e., int, String)
    @Test
    public void object_not_instance_Team() {
        int teamNumber = 13;

        assertEquals(false, team.equals(teamNumber));
    }

    // Case 3: Comparing fields
    @Test
    public void returns_true_same_name() {
        Team tmp = new Team("test-team");

        assert(team.name.equals(tmp.name));
    }

    @Test
    public void returns_true_same_members() {
        Team tmp1 = new Team("tmp1");
        tmp1.addMember("Member 1");
        Team tmp2 = new Team("tmp2");
        tmp2.addMember("Member 1");

        assert(tmp1.members.equals(tmp2.members));
    }

    @Test
    public void returns_true_same_values() {
        Team tmp = new Team("test-team");
        tmp.addMember("Member 1");

        team.addMember("Member 1");

        assert(team.equals(tmp));
    }

    @Test
    public void returns_false_different_name() {
        Team tmp = new Team("tmp");

        assertEquals(false, team.name.equals(tmp.name));
    }

    @Test
    public void returns_false_different_members() {
        Team tmp = new Team("test-team");
        tmp.addMember("Member 1");

        assertEquals(false, team.members.equals(tmp.members));
    }

    @Test
    public void returns_false_different_values() {
        Team tmp1 = new Team("tmp1");
        Team tmp2 = new Team("tmp2");

        tmp1.addMember("Member 1");
        tmp2.addMember("Member 1");
        tmp2.addMember("Member 2");

        assertEquals(false, tmp1.equals(tmp2));
    }

    // Hash code check
    @Test
    public void check_hash_Code() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

}
