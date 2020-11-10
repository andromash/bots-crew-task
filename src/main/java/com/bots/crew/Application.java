package com.bots.crew;

import com.bots.crew.model.Head;
import com.bots.crew.service.DegreeService;
import com.bots.crew.service.DepartmentService;
import com.bots.crew.service.LectorService;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final String GET_HEAD_COMMAND = "Who is head of department";
    private static final String GET_AVERAGE_SALARY_COMMAND = "Show the average salary"
            + " for the department";
    private static final String GET_NUMBER_OF_EMPLOYEE_COMMAND = "Show count of employee for";
    private static final String GLOBAL_SEARCH_COMMAND = "Global search by";
    private static final String STATISTICS_COMMAND = "statistics";
    private final DepartmentService departmentService;
    private final LectorService lectorService;
    private final DegreeService degreeService;

    @Autowired
    public Application(DepartmentService departmentService, LectorService lectorService,
                       DegreeService degreeService) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
        this.degreeService = degreeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command to execute. "
                    + "If you want close the app just enter `close`.");
            String command = in.nextLine();
            if (command.contains("close")) {
                System.out.println("Stop working.");
                return;
            }
            if (command.contains(GET_HEAD_COMMAND)) {
                showHead(command);
            } else if (command.contains(GET_AVERAGE_SALARY_COMMAND)) {
                showAverage(command);
            } else if (command.contains(GET_NUMBER_OF_EMPLOYEE_COMMAND)) {
                showNumberOfEmployee(command);
            } else if (command.contains(GLOBAL_SEARCH_COMMAND)) {
                provideGlobalSearch(command);
            } else if (command.contains(STATISTICS_COMMAND)) {
                showStatistics(command);
            } else {
                System.out.println("Unknown command.");
            }
        }
    }

    private void showHead(String command) {
        String department = command.replace(GET_HEAD_COMMAND, "").trim();
        Head headOfDepartment = departmentService.getHeadOfDepartment(department);
        System.out.println("Head of " + department + " department is "
                + headOfDepartment.toString());
    }

    private void showAverage(String command) {
        String department = command.replace(GET_AVERAGE_SALARY_COMMAND, "").trim();
        double averageSalary = departmentService.getAverageSalary(department);
        System.out.println("The average salary of " + department + " is " + averageSalary);
    }

    private void showNumberOfEmployee(String command) {
        String department = command.replace(GET_NUMBER_OF_EMPLOYEE_COMMAND, "").trim();
        int numberOfEmployee = departmentService.getNumberOfEmployees(department);
        System.out.println(numberOfEmployee);
    }

    private void provideGlobalSearch(String command) {
        String part = command.replace(GLOBAL_SEARCH_COMMAND, "").trim();
        lectorService.provideGlobalSearch(part).forEach(lector -> System.out.print(
                lector.getName() + " " + lector.getSurname() + ", "));
        departmentService.provideGlobalSearch(part).forEach(
                department -> System.out.print(department.getName() + ", "));
        degreeService.provideGlobalSearch(part).forEach(
                degree -> System.out.print(degree.getName() + ", "));
    }

    private void showStatistics(String command) {
        String department = command.replace(STATISTICS_COMMAND, "")
                .replace("Show", "").trim();
        String statistics = departmentService.showStatistics(department);
        System.out.println(statistics);
    }
}
