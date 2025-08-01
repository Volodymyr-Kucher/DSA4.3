package first;

public class CadetUtil {

    public static void insert(Cadet[] table, Cadet cadet) {
        if (cadet != null && cadet.getId() >= 0 && cadet.getId() < table.length) {
            if (table[cadet.getId()] != null) {
                System.out.println("Помилка: місце з ID " + cadet.getId() + " вже зайняте.");
            } else {
                table[cadet.getId()] = cadet;
            }
        }
    }

    public static Cadet search(Cadet[] table, int id) {
        if (id >= 0 && id < table.length) {
            return table[id];
        }
        return null;
    }

    public static Cadet delete(Cadet[] table, int id) {
        if (id >= 0 && id < table.length) {
            Cadet deletedCadet = table[id];
            table[id] = null;
            return deletedCadet;
        }
        return null;
    }

    public static void printInfo(Cadet[] table, int id) {
        Cadet cadet = search(table, id);
        if (cadet != null) {
            System.out.println(cadet);
        } else {
            System.out.println("Курсанта з ID " + id + " не знайдено.");
        }
    }

    public static void printAll(Cadet[] table) {
        System.out.println("--- Список всіх курсантів ---");
        boolean empty = true;
        for (Cadet cadet : table) {
            if (cadet != null) {
                System.out.println(cadet);
                empty = false;
            }
        }
        if (empty) {
            System.out.println("Таблиця порожня.");
        }
        System.out.println("----------------------------");
    }
}