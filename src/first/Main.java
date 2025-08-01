package first;

public class Main {
    public static void main(String[] args) {

        Cadet[] dat = new Cadet[32];

        System.out.println("Початковий стан таблиці:");
        CadetUtil.printAll(dat);

        Cadet cadet1 = Cadet.of(5, "Іван", "Петренко", SpecialityTrends.Cybersecurity);
        Cadet cadet2 = Cadet.of(12, "Марія", "Ковальчук", SpecialityTrends.SoftwareDevelopment);
        Cadet cadet3 = Cadet.of(31, "Олексій", "Сидоренко", SpecialityTrends.MachineLearning);

        System.out.println("\nВставляємо трьох курсантів...");
        CadetUtil.insert(dat, cadet1);
        CadetUtil.insert(dat, cadet2);
        CadetUtil.insert(dat, cadet3);

        CadetUtil.printAll(dat);

        System.out.println("\nШукаємо курсанта з ID=12:");
        CadetUtil.printInfo(dat, 12);

        System.out.println("\nШукаємо курсанта з ID=10 (не існує):");
        CadetUtil.printInfo(dat, 10);

        System.out.println("\nВидаляємо курсанта з ID=5...");
        Cadet deleted = CadetUtil.delete(dat, 5);
        if (deleted != null) {
            System.out.println("Успішно видалено: " + deleted.getName());
        }

        System.out.println("\nФінальний стан таблиці:");
        CadetUtil.printAll(dat);
    }
}