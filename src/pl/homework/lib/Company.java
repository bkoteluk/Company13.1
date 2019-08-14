package pl.homework.lib;

public class Company implements Numerable {
    private Employee[] employees;

    public Company(Employee[] employees) {
        this.employees = employees;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    @Override
    public double averageSalary() {
        double sumSalary = 0;
        for (Employee employee: employees) {
            sumSalary += employee.getSalary();
        }
        return sumSalary/employees.length;
    }

    @Override
    public double minimumSalary() {
        double minSalary = employees[0].getSalary();
        for (Employee employee: employees) {
            if (minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }

    @Override
    public double maximumSalary() {
        double maxSalary = employees[0].getSalary();
        for (Employee employee: employees) {
            if (maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    @Override
    public Division[] divistionStat() {
        Division[] divisions = new Division[3];

        for (int i = 0; i < divisions.length ; i++) {
            divisions[i] = new Division();
        }
        for (Employee employee: employees) {
            for (int i = 0; i< divisions.length; i++) {
                if (divisions[i].getName() == null) {
                    divisions[i].setName(employee.getDivision());
                    divisions[i].setStatCounter(divisions[i].getStatCounter()+1);
                    break;
                } else if (divisions[i].getName().equals(employee.getDivision())) {
                    divisions[i].setStatCounter(divisions[i].getStatCounter()+1);
                    break;
                }
            }
        }
        return divisions;
    }
}
