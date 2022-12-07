package pairmatching;

import org.junit.jupiter.api.Test;
import pairmatching.view.OutputView;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LearningTest {

    @Test
    void 파일에서_프론트엔드_크루이름_불러오기() throws IOException {
        Scanner scanner = new Scanner(new File("./src/main/resources/frontend-crew.md"));

        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(str);
        }
    }

    @Test
    void 파일에서_백엔드_크루이름_불러오기() throws IOException {
        Scanner scanner = new Scanner(new File("./src/main/resources/backend-crew.md"));

        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(str);
        }
    }

    @Test
    void printCourse() {
        OutputView.printCourseMissionLevel();
    }
}
