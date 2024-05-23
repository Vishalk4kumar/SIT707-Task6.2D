package com.example.ontrack;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OnTrack {

    public String submitTask(int studentId, int unitId, int taskId, String taskFile) {
        if (!isValidTaskFile(taskFile)) {
            return "Error: Invalid task file format";
        }
        // Simulate file upload logic
        return "Task submitted successfully";
    }

    public String viewTaskFeedback(int studentId, int unitId, int taskId) {
        String feedback = getFeedback(studentId, unitId, taskId);
        if (feedback == null || feedback.isEmpty()) {
            return "Error: Feedback not available";
        }
        return feedback;
    }

    public String sendDeadlineReminder(int studentId, int unitId, int taskId) {
        Date deadline = getTaskDeadline(unitId, taskId);
        if (deadline == null) {
            return "Reminder sent";
        }
        // Simulate sending reminder logic
        return "Reminder sent";
    }

    public String trackProgress(int studentId, int unitId) {
        String progress = calculateProgress(studentId, unitId);
        if (progress == null) {
            return "Error: Unable to calculate progress";
        }
        return progress;
    }

    public String unitOverview(int unitId) {
        String overview = getUnitOverview(unitId);
        if (overview == null) {
            return "Error: Unit overview not found";
        }
        return overview;
    }

    public String viewTutorAvailability(int tutorId) {
        String availability = getTutorAvailability(tutorId);
        if (availability == null || availability.isEmpty()) {
            return "Error: Tutor availability not found";
        }
        return availability;
    }

    public String getAnnouncements(int unitId) {
        List<String> announcements = fetchAnnouncements(unitId);
        if (announcements.isEmpty()) {
            return "No announcements available";
        }
        return String.join("\n", announcements);
    }

    public String shareResource(int tutorId, int unitId, String resourceFile) {
        if (!isValidResourceFile(resourceFile)) {
            return "Error: Invalid resource file format";
        }
        // Simulate resource sharing logic
        return "Resource shared successfully";
    }

    public String collaborateOnTask(int studentId, int taskId, List<Integer> peerIds) {
        if (!peerIds.stream().allMatch(this::isValidStudentId)) {
            return "Error: Invalid peer IDs";
        }
        // Simulate collaboration setup logic
        return "Collaboration setup successfully";
    }

    // Simulated helper methods
    private boolean isValidTaskFile(String taskFile) {
        return taskFile.endsWith(".txt") || taskFile.endsWith(".pdf");
    }

    private String getFeedback(int studentId, int unitId, int taskId) {
        // Simulated feedback retrieval. Return null if feedback does not exist.
        if (taskId == 1001) {
            return "Great job!";
        }
        return null;
    }

    private Date getTaskDeadline(int unitId, int taskId) {
        // Simulated deadline retrieval
        return new Date();
    }

    private String calculateProgress(int studentId, int unitId) {
        // Simulated progress calculation
        return "75%";
    }

    public String getUnitOverview(int unitId) {
        // Simulated unit overview retrieval. Return null if unit does not exist.
        if (unitId == 101) {
            return "Unit Overview: Advanced Java Programming";
        }
        return null;
    }

    private String getTutorAvailability(int tutorId) {
        // Simulated tutor availability retrieval
        if (tutorId == 1) {
            return "Available Mon-Fri, 10am-4pm";
        }
        return null; // No availability for other tutor IDs
    }

    private List<String> fetchAnnouncements(int unitId) {
        // Simulated announcements retrieval
        return Arrays.asList("Midterm exam next week", "Project deadline extended");
    }

    private boolean isValidResourceFile(String resourceFile) {
        return resourceFile.endsWith(".ppt") || resourceFile.endsWith(".pdf");
    }

    private boolean isValidStudentId(int studentId) {
        // Simulated student ID validation
        return studentId > 0;
    }
}
