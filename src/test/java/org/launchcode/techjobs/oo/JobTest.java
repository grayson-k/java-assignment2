package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Check name
        assertTrue(job1.getName() instanceof String);
        assertEquals(job1.getName(),"Product tester");

        // Check Employer
        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals(job1.getEmployer().getValue(), "ACME");

        // Check Location
        assertTrue(job1.getLocation() instanceof Location);
        assertEquals(job1.getLocation().getValue(), "Desert");

        // Check PositionType
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertEquals(job1.getPositionType().getValue(), "Quality control");

        // Check CoreCompetency
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job1.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testjob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(System.lineSeparator(), testjob.toString().substring(0,1));
        assertEquals(System.lineSeparator(), testjob.toString().substring(testjob.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testjob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = "ID: " + testjob.getId() + System.lineSeparator() +
                "Name: " + testjob.getName() + System.lineSeparator() +
                "Employer: " + testjob.getEmployer() + System.lineSeparator() +
                "Location: " + testjob.getLocation() + System.lineSeparator() +
                "Position Type: " + testjob.getPositionType() + System.lineSeparator() +
                "Core Competency: " + testjob.getCoreCompetency();

        assertEquals(expected, testjob.toString().substring(1, testjob.toString().length() - 1));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testjob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = "ID: " + testjob.getId() + System.lineSeparator() +
                "Name: " + testjob.getName() + System.lineSeparator() +
                "Employer: " + "Data not available" + System.lineSeparator() +
                "Location: " + testjob.getLocation() + System.lineSeparator() +
                "Position Type: " + testjob.getPositionType() + System.lineSeparator() +
                "Core Competency: " + testjob.getCoreCompetency();

        assertEquals(expected, testjob.toString().substring(1, testjob.toString().length() - 1));

    }
}
