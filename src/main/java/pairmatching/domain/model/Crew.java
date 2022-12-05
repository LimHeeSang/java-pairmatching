package pairmatching.domain.model;

public class Crew {

    private final String name;
    private final Course course;

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public boolean isSame(String name) {
        return this.name.equals(name);
    }
}
