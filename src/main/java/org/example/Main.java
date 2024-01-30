package org.example;


import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ListBooX baza = new ListBooX();//база
        File file = new File("./file.txt");// создание файла
        if (file.createNewFile()) {
            System.out.println("Файл успешно был создан");        // несколько строк с проверкой на наличие файла
        } else {
            System.out.println("Файл уже существует");
        }
        try (FileReader fileReader = new FileReader(file)) {
            Scanner fileScanner = new Scanner(fileReader);
            if (fileScanner.hasNextLine()) {
                String str2 = fileScanner.nextLine();// сдесь происходит чтение файла, наверное
                Gson gson = new Gson();
                baza = gson.fromJson(str2, ListBooX.class);
            }
        } catch (FileNotFoundException e) {//
            System.out.println("Файл не найден ");
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
        int Menu = 0;
        do {
            try {

                mainMenu();
                String S = scanner.nextLine();
                ;
                Menu = Integer.parseInt(S);
            } catch (Exception e) {
                System.out.println("Введено не число");
            }
            switch (Menu) {
                case 1:
                    baza.getData().add(adddBook());
                    break;
                case 2:
                    allBooks(baza);
                    break;
                case 3:
                    maxZP(baza);

                    break;
                case 4:
                    minZP(baza);
                    //searchMenu(baza);
                    break;
                case 5:
                   allZP(baza);
                    break;
                case 6:allPeople(baza);break;
                case 7:{// завершение работы  и запись данных в файл
                    Gson gson = new Gson();
                    String str1 = gson.toJson(baza);
                    try (FileWriter fileWriter = new FileWriter(file)) {
                        fileWriter.write(str1);
                        System.out.println("Данные успешно созранены в файл ");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("До свидание!");
                }
                break;
            }

        } while (Menu != 7);


    }

    public static void mainMenu() {// метод вывода менюшки
        System.out.println("Выберите нужное действие: \n" +
                "1 - Добавить данные \n" +
                "2 - Вывести все данные\n" +
                "3 - Сотрудник с большей ЗП\n" +
                "4 - Сотрудник с минимальной ЗП\n" +
                "5 - Сума затрат на зп \n"+
                "6 - ФИО всех сотрудников \n"+
                "7 - закрыть программу\n");

    }

    public static Staff adddBook() {// метод заполнения массива данными
        int b=0;
        Scanner scanner = new Scanner(System.in);
        Staff booX = new Staff();
        booX.setId(String.valueOf(b++));
        System.out.println("Введите Имя сотрудника; ");
        booX.setVadim(scanner.nextLine());
        System.out.println("Введите Фамилия сотрудника; ");
        booX.setVsenko(scanner.nextLine());
        System.out.println("Введите Отчество сотрудника; ");
        booX.setNikolaevich(scanner.nextLine());
        try {

            System.out.println("Введите Отдел сотрудника; ");

            booX.setDepartment(scanner.nextInt());
            System.out.println("Введите ЗП сотрудника; ");
            booX.setZP(scanner.nextInt());
        } catch (Exception o) {
            System.out.println("Введено не число, все данные кроме последующтх будут внесены ╰（‵□′）╯");
        }
        return booX;
    }

    public static void allBooks(ListBooX masBook) { // все книги, вывод


        int i = 1;
        int b = 0;
        for (Staff bookaz : masBook.getData()) {
            b++;
            System.out.println("раб №" + i++ + '\n' + bookaz.toString());


        }

    }




    public static void maxZP(ListBooX baza) { //метод макс зп
        int sum = 0;
        String name = null; //Пустота
        for (Staff sigma : baza.getData()) {
            if (sum < sigma.getZP()) {
                sum = sigma.getZP();
                name = sigma.getVadim();
            }
        }
        System.out.println("больший ЗП у " + name + '\n' + sum + "р");


    }

    public static void allZP(ListBooX baza) { //всё зп расчёт
        int sum = 0;

        for (Staff sigma : baza.getData()) {
            sum += sigma.getZP();
        }

        System.out.println("Обшие затраты на ЗП  "+sum +"р");

}


    public static void minZP(ListBooX baza) {
        int sum = 0;
        String name = null;
        for (Staff sigma : baza.getData()) {

            if (sum > sigma.getZP()) {
                sum = sigma.getZP(); //зп
                name = sigma.getVadim();//Имя
            }else if (sum==0)sum= sigma.getZP();
        }
        System.out.println("Меньшее ЗП у " + name + '\n' + sum + "р");

    }

    public static void allPeople(ListBooX masBook) {


        int i = 1;
        int b = 0;
        for (Staff bookaz : masBook.getData()) {
            b++;
            System.out.println("№" + i++ +'\n'+ bookaz.getVsenko()+bookaz.getVadim()+bookaz.getNikolaevich());


        }

    }


}
