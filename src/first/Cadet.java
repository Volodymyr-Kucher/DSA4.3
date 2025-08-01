package first;

public class Cadet {

    private final int id;
    private final String name;
    private final String lastName;
    private final SpecialityTrends speciality;

    private Cadet(int id, String name, String lastName, SpecialityTrends speciality) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.speciality = speciality;
    }

    public static Cadet of(int id, String name, String lastName, SpecialityTrends speciality) {
        // Додамо перевірку діапазону id
        if (id < 0 || id > 31) {
            throw new IllegalArgumentException("ID повинен бути в діапазоні від 0 до 31.");
        }
        return new Cadet(id, name, lastName, speciality);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public SpecialityTrends getSpeciality() {
        return speciality;
    }


    @Override
    public String toString() {
        return String.format("first.Cadet [ID=%d, Name=%s, LastName=%s, Speciality=%s]",
                id, name, lastName, speciality);
    }
}