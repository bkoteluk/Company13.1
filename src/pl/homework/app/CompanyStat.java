package pl.homework.app;

import pl.homework.lib.Company;
import pl.homework.lib.Division;
import pl.homework.lib.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static pl.homework.utils.FileUtils.EMPLOYEES_STAT;
import static pl.homework.utils.FileUtils.staffReader;

public class CompanyStat {

    public static void main(String[] args) {
        try {
            Company company = new Company(staffReader());
            printCompanyStat(company);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void printCompanyStat(Company company) throws IOException {
        Division[] divisions;
        File file = new File(EMPLOYEES_STAT);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        String line = "Średnia wypłata :" + company.averageSalary() + "\n";
        bufferedWriter.write(line);
        System.out.print(line);
        line = "Najmniejsza wypłata : " + company.minimumSalary()+ "\n";
        bufferedWriter.write(line);
        System.out.print(line);
        line = "Największa wypłata : " + company.maximumSalary()+ "\n";
        bufferedWriter.write(line);
        System.out.print(line);
        line = "Łączna liczba pracownikków: " + company.getEmployees().length + "\n";
        bufferedWriter.write(line);
        System.out.print(line);

        divisions = company.divistionStat();
        for (Division division: divisions) {
            line = "Liczba pracowników w dziale " + division+ "\n";
            bufferedWriter.write(line);
            System.out.print(line);
        }
        bufferedWriter.flush();
        bufferedWriter.close();

        System.out.println("\n >>> Wczytana baza pracowników :");
        for (Employee employee : company.getEmployees()) {
            System.out.println(employee);
        }
    }

}

