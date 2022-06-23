package lesson5;

public class Employee {
    private String name;
    private String jobTitle;
    private String email;
    private String telephone;
    private int age;
    private int salary;

    public int getAge() {
        return age;
    }

    public Employee(String name, String jobTitle, String email, String telephone, int age, int salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.email = email;
        this.telephone = telephone;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, String jobTitle, String email, int telephone, int age, int salary) {
    }

    public void info() {
        System.out.println(name + " " + jobTitle + " " + email + " " + telephone + " " + age + salary);
    }
}
