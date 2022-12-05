package pairmatching.domain.model;

public class Crew {

    private final String name;
    private final Course course;

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public boolean isSameCourse(Course course) {
        return this.course == course;
    }
}
