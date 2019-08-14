package pl.homework.app;

import pl.homework.lib.Company;
import pl.homework.lib.Division;
import pl.homework.lib.Employee;
import java.io.IOException;
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


    public static void printCompanyStat(Company company){
        Division[] divisions;

        System.out.println("Średnia wypłata :" + company.averageSalary());
        System.out.println("Najmniejsza wypłata : " + company.minimumSalary());
        System.out.println("Największa wypłata : " + company.maximumSalary());
        System.out.println("Łączna liczba pracownikków: " + company.getEmployees().length);

        divisions = company.divistionStat();
        for (Division division: divisions) {
            System.out.println("Liczba pracowników w dziale " + division);
        }

        System.out.println("\n >>> Wczytana baza pracowników :");
        for (Employee employee : company.getEmployees()) {
            System.out.println(employee);
        }
    }

}

