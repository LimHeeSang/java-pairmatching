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
        addCrewsFromFile(crews, FILE_PATH_FRONTEND_CREW);
        addCrewsFromFile(crews, FILE_PATH_BACKEND_CREW);
        return crews;
    }

    private static void addCrewsFromFile(List<Crew> crews, String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            String name = scanner.next();
            System.out.println(name);
            crews.add(new Crew(name, Course.FRONTEND));
        }
    }
}
