import java.util.ArrayList;

public class Main {

    public static void main(String args[]){

        // Создание экземпляров классов с помощью конструкторов
        Equip equip1 = new Equip("AK-47", "P7", "6B11-M");

        Soldier soldier1 = new Soldier("Музыкант", 1, equip1);
        ArrayList<Soldier> soldiers_list = new ArrayList<>();
        soldiers_list.add(soldier1);

        Troop troop1 = new Troop(1, "Пехота", 1, soldiers_list);
        ArrayList<Troop> troops_list = new ArrayList<>();
        troops_list.add(troop1);

        Company company1 = new Company(1, "Пехота", 1, troops_list);
        ArrayList<Company> companies_list = new ArrayList<>();
        companies_list.add(company1);

        Battalion battalion1 = new Battalion(1, "Пехота", 1, companies_list);

        System.out.println("---------------Constructor Test------------------");
        battalion1.printBattalion();

        // Тестирование методов класса Equip
        System.out.println("---------------Equip Test------------------");
        equip1.createEquipKit();  // Метод отсутствует в исходном описании класса
        equip1.printEquipKit();

        // Тестирование методов класса Soldier
        System.out.println("---------------Soldier Test------------------");
        soldier1.createSoldier(); // Метод отсутствует в исходном описании класса
        soldier1.printSoldier();

        // Тестирование методов класса Troop
        System.out.println("---------------Troop Test------------------");
        troop1.createTroop();     // Метод отсутствует в исходном описании класса
        System.out.println("Информация о взводе после создания");
        troop1.printTroop();

        soldier1 = new Soldier("Добавленный", 2, equip1);
        troop1.addSoldier(soldier1);
        System.out.println("Информация о взводе после добавления солдата soldier1:");
        troop1.printTroop();

        System.out.println("Список солдат для тестирования метода удаления солдата:");
        troop1.deleteSoldier();  // Предполагается, что deleteSoldier принимает индекс удаляемого солдата
        System.out.println("Информация о взводе после удаления солдата:");
        troop1.printTroop();

        // Тестирование методов класса Company
        System.out.println("---------------Company Test------------------");
        System.out.println("Информация о роте после создания:");
        company1.printCompany();

        troop1 = new Troop(2, "Танки", 0, new ArrayList<>());
        company1.addTroop(troop1);
        System.out.println("Информация о роте после добавления взвода troop1:");
        company1.printCompany();

        System.out.println("Список взводов для тестирования метода удаления взвода");
        company1.deleteTroop();  // Предполагается, что deleteTroop принимает индекс удаляемого взвода
        System.out.println("Информация о роте после удаления взвода:");
        company1.printCompany();

        // Тестирование методов класса Battalion
        System.out.println("---------------Battalion Test------------------");
        System.out.println("Информация о батальоне после создания:");
        battalion1.printBattalion();

        company1 = new Company(2, "Танки", 0, new ArrayList<>());
        battalion1.addCompany(company1);
        System.out.println("Информация о батальоне после добавления роты company1:");
        battalion1.printBattalion();

        System.out.println("Список рот для тестирования метода удаления роты");
        battalion1.deleteCompany();
        System.out.println("Информация о батальоне после удаления роты:");
        battalion1.printBattalion();
    }

}
