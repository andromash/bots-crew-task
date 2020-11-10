package com.bots.crew;

import java.util.Scanner;

import com.bots.crew.model.Department;
import com.bots.crew.model.Head;
import com.bots.crew.service.DepartmentService;
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
    private final DepartmentService departmentService;

    @Autowired
    public Application(DepartmentService departmentService) {
        this.departmentService = departmentService;
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
                String department = command.replace(GET_HEAD_COMMAND, "").trim();
                Head headOfDepartment = departmentService.getHeadOfDepartment(department);
                System.out.println("Head of " + department + " department is " + headOfDepartment.toString());
            } else if (command.contains(GET_AVERAGE_SALARY_COMMAND)) {
                String department = command.replace(GET_AVERAGE_SALARY_COMMAND, "").trim();
                double averageSalary = departmentService.getAverageSalary(department);
                System.out.println("The average salary of " + department + " is " + averageSalary);
            } else if (command.contains(GET_NUMBER_OF_EMPLOYEE_COMMAND)) {
                String department = command.replace(GET_NUMBER_OF_EMPLOYEE_COMMAND, "").trim();
                int numberOfEmployee = departmentService.numberOfEmployees(department);
                System.out.println(numberOfEmployee);
            }
            System.out.println("Unknown command.");
        }
    }
}
