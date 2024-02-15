package org.example;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Employee[] employeesArray = new Employee[10];

        employeesArray[0] = new Employee("Иванов Иван Иванович", 1, 50000.0);
        employeesArray[1] = new Employee("Петров Петр Петрович", 2, 60000.0);


        Scanner scanner = new Scanner(System.in);


        File file = new File("./file.txt");
        if (file.createNewFile()) {
            System.out.println("Файл успешно был создан");
        } else {
            System.out.println("Файл уже существует");
        }
        try (FileReader fileReader = new FileReader(file)) {
            Scanner fileScanner = new Scanner(fileReader);
            if (fileScanner.hasNextLine()) {
                String str2 = fileScanner.nextLine();
                Gson gson = new Gson();
                employeesArray = new Employee[]{gson.fromJson(str2, Employee.class)};
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден ");}catch (IOException e){

            throw new RuntimeException(e);
        }
        int menu = 0;

        do {
            try {

                mainMenu();
                String S = scanner.nextLine();

                menu = Integer.parseInt(S);
            } catch (Exception e) {
                System.out.println("Введено не число");
            }
            switch (menu) {


                case 1:findEmployeeWithMinSalary(employeesArray);

                    break;
                case 2:printAllEmployees(employeesArray); break;

                case 3: findEmployeeWithMaxSalary(employeesArray);

                    break;
                case 4: calculateAverageSalary(employeesArray);

                    break;

                case 8:;

                    break;
                case 5:calculateTotalSalary(employeesArray);

                    break;

                case 6: printFullNames(employeesArray);

                    break;

                case 7: {
                    Gson gson = new Gson();
                    String str1 = gson.toJson(employeesArray);
                    try (FileWriter fileWriter = new FileWriter(file)) {
                        fileWriter.write(str1);
                        System.out.println("Данные успешно созранены в файл ");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("До свидание!");

                }
                break;
                default:
                    ;

                    System.out.println("Я начинаю догадываться, почему у тебя проблемы ");
            }
            }while (menu != 7) ;


        }






    public static void mainMenu() {
        System.out.println("Выберите нужное действие: \n" +
                "1 - С меньшей зп \n" +
                "2 - Вывести \n" +
                "3 - С большей зп \n" +
                "4 - Средняя зп\n" +
                "5 - Вся зп\n"+
                "6 - Все имена\n"+
        "7 - закрыть программу\n");

    }


    private static void printAllEmployees(Employee[] employees) {
        System.out.println("Список всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }


    private static void calculateTotalSalary(Employee[] employees) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплаты в месяц: " + totalSalary + "\n");
    }

    private static void findEmployeeWithMinSalary(Employee[] employees) {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee + "\n");
    }

    private static void findEmployeeWithMaxSalary(Employee[] employees) {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee + "\n");
    }

    private static void calculateAverageSalary(Employee[] employees) {
        int count = 0;
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
                totalSalary += employee.getSalary();
            }
        }
        double averageSalary = (count > 0) ? (totalSalary / count) : 0;
        System.out.println("Среднее значение зарплат: " + averageSalary + "\n");
    }

    private static void printFullNames(Employee[] employees) {
        System.out.println("Ф. И. О. всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
}








////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    int Menu = 0;
//        do {
//        try {
//            Scanner scanner;
//            String S = scanner.nextLine();
//            ;
//            Menu = Integer.parseInt(S);
//        } catch (Exception e) {
//            System.out.println("Введено не число");
//        }
//  switch (Menu) {
//        case 1:
//            baza.getData().add(adddBook());
//            break;
//        case 2:
//            allBooks(baza);
//            break;
//        case 3:
//            maxZP(baza);
//
//            break;
//        case 4:
//            minZP(baza);
//            //searchMenu(baza);
//            break;
//        case 5:
//            allZP(baza);
//            break;
//        case 6:allPeople(baza);break;
//        case 7:{// завершение работы  и запись данных в файл
//            Gson gson = new Gson();
//            String str1 = gson.toJson(baza);
//            try (FileWriter fileWriter = new FileWriter(file)) {
//                fileWriter.write(str1);
//                System.out.println("Данные успешно созранены в файл ");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("До свидание!");
//        }
//        break;
//    }
//
//} while (Menu != 7);
//
//        }