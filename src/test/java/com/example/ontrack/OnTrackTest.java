package com.example.ontrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

public class OnTrackTest {

    private OnTrack onTrack = new OnTrack();
    
    @BeforeEach
    public void setUp() {
        onTrack = new OnTrack();
    }

    @Test
    public void testSubmitTask() {
        String result = onTrack.submitTask(1, 101, 1001, "assignment1.txt");
        assertEquals("Task submitted successfully", result);

        result = onTrack.submitTask(1, 101, 1001, "assignment1.exe");
        assertEquals("Error: Invalid task file format", result);
    }

    @Test
    public void testViewTaskFeedback() {
        // Test case for existing feedback
        String result = onTrack.viewTaskFeedback(1, 101, 1001);
        assertEquals("Great job!", result);

        // Test case for non-existing feedback
        result = onTrack.viewTaskFeedback(1, 101, 9999);
        assertEquals("Error: Feedback not available", result);
    }

    @Test
    public void testSendDeadlineReminder() {
        String result = onTrack.sendDeadlineReminder(1, 101, 1001);
        assertEquals("Reminder sent", result);

        result = onTrack.sendDeadlineReminder(1, 101, 9999);
        assertEquals("Reminder sent", result);
    }

    @Test
    public void testTrackProgress() {
        String result = onTrack.trackProgress(1, 101);
        assertTrue(result.endsWith("%") || result.startsWith("Error"));

        result = onTrack.trackProgress(1, 9999);
        assertTrue(result.endsWith("%") || result.startsWith("Error"));
    }

    @Test
    public void testUnitOverview() {
        String result = onTrack.unitOverview(101);
        assertEquals("Unit Overview: Advanced Java Programming", result);

        result = onTrack.unitOverview(9999);
        assertEquals("Error: Unit overview not found", result);
    }

    @Test
    public void testTutorAvailability() {
        // Create a new instance of OnTrack
        OnTrack onTrack = new OnTrack();

        // Test case 1: Tutor with availability
        String availability1 = onTrack.viewTutorAvailability(1);
        assertEquals("Available Mon-Fri, 10am-4pm", availability1);

        // Test case 2: Tutor with no availability
        String availability2 = onTrack.viewTutorAvailability(9999);
        assertEquals("Error: Tutor availability not found", availability2);
    }

    @Test
    public void testGetAnnouncements() {
        String result = onTrack.getAnnouncements(101);
        assertEquals("Midterm exam next week\nProject deadline extended", result);
    }

    @Test
    public void testShareResource() {
        String result = onTrack.shareResource(201, 101, "lecture1.ppt");
        assertEquals("Resource shared successfully", result);

        result = onTrack.shareResource(201, 101, "lecture1.exe");
        assertEquals("Error: Invalid resource file format", result);
    }

    @Test
    public void testCollaborateOnTask() {
        String result = onTrack.collaborateOnTask(1, 1001, Arrays.asList(2, 3));
        assertEquals("Collaboration setup successfully", result);

        result = onTrack.collaborateOnTask(1, 1001, Arrays.asList(2, -1));
        assertEquals("Error: Invalid peer IDs", result);
    }
}
