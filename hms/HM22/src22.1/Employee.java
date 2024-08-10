import java.time.Year;

class Employee {
    private String name;
    private String surname;
    private int birthYear;
    private int startYear;

    public Employee(String name, String surname, int birthYear, int startYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.startYear = startYear;
    }

    public int calculateExperience() {
        int currentYear = Year.now().getValue();
        if (startYear > currentYear || birthYear > currentYear) {
            throw new IllegalArgumentException("Год начала работы или год рождения не может быть в будущем.");
        }
        if (startYear < birthYear + 18) {
            throw new IllegalArgumentException("Год начала работы не может быть раньше, чем работнику исполнилось 18 лет.");
        }
        return currentYear - startYear;
    }
}