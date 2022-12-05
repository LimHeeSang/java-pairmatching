package pairmatching.domain.repository;

import pairmatching.domain.model.Course;
import pairmatching.domain.model.Crew;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadorCrewName {

    private static final String FILE_PATH_FRONTEND_CREW = "./src/main/resources/frontend-crew.md";
    private static final String FILE_PATH_BACKEND_CREW = "./src/main/resources/backend-crew.md";

    private ReadorCrewName() {
    }

    public static List<Crew> readCrew() throws FileNotFoundException {
        List<Crew> crews = new ArrayList<>();
        crews.addAll(addCrewsFromFile(FILE_PATH_FRONTEND_CREW, Course.FRONTEND));
        crews.addAll(addCrewsFromFile(FILE_PATH_BACKEND_CREW, Course.BACKEND));
        return crews;
    }

    private static List<Crew> addCrewsFromFile(String fileName, Course course) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<Crew> crews = new ArrayList<>();
        while (scanner.hasNext()) {
            String name = scanner.next();
            crews.add(new Crew(name, course));
        }
        return crews;
    }
}
