package pl.homework.utils;

import pl.homework.lib.Employee;

import java.io.*;

public class FileUtils {

    public static final String EMPLOYEES_DB = "employees.csv";
    public static final String EMPLOYEES_STAT = "emp_stat.txt";

    public static Employee[] staffReader() throws IOException {
        Employee[] employees = new Employee[4];
        File file = new File(EMPLOYEES_DB);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = "";
        int i = 0;
        while((line = bufferedReader.readLine()) != null) {
            String[] strings = line.split(";");
            employees[i] = new Employee(strings[0], strings[1], strings[2], strings[3], Double.parseDouble(strings[4]));
            i++;
        }
        bufferedReader.close();
        return employees;
    }

    public static void staffWriter(BufferedWriter bufferedWriter, Employee[] employees) throws IOException {
        for (Employee employee: employees) {
            bufferedWriter.write(employee.toCsv());
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
