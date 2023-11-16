import java.util.Scanner;
import java.util.ArrayList;

public class Troop {
    private int troopNumber;
    private String troopType;
    private int soldiersCount;
    private ArrayList<Soldier> soldiersList = new ArrayList<>();

    public Troop(){

    }

    public Troop(int troopNumber,
                 String troopType,
                 int soldiersCount,
                 ArrayList<Soldier> soldiersList) {
        this.troopNumber = troopNumber;
        this.troopType = troopType;
        this.soldiersCount = soldiersCount;
        this.soldiersList = soldiersList;
    }

    public void setTroopNumber(int troopNumber) {
        this.troopNumber = troopNumber;
    }

    public void setTroopType(String troopType) {
        this.troopType = troopType;
    }

    public void setSoldiersCount(int soldiersCount) {
        this.soldiersCount = soldiersCount;
    }

    public void setSoldiersList(ArrayList<Soldier> soldiersList) {
        this.soldiersList = soldiersList;
    }

    public int getTroopNumber() {
        return troopNumber;
    }

    public String getTroopType() {
        return troopType;
    }

    public int getSoldiersCount() {
        return soldiersCount;
    }

    public ArrayList<Soldier> getSoldiersList() {
        return soldiersList;
    }

    public Troop createTroop(){
        int troopNumberStorage;
        String troopTypeStorage;
        int soldiersCountStorage;
        ArrayList<Soldier> soldiersListStorage = new ArrayList<>();
        Soldier soldierDataStorage = new Soldier();
        Troop troopDataStorage = new Troop();

        Scanner input = new Scanner(System.in);

        System.out.print("Введите номер взвода: ");
        troopNumberStorage = input.nextInt();

        input.nextLine();
        System.out.print("Введите тип взвода: ");
        troopTypeStorage = input.nextLine();

        System.out.print("Введите количество солдат: ");
        soldiersCountStorage = input.nextInt();

        for (int i = 0; i < soldiersCountStorage; i++){
            System.out.println("Введите данные о солдате " + (i + 1) + ":");
            soldiersListStorage.add(soldierDataStorage = soldierDataStorage.createSoldier());
        }

        troopDataStorage.troopNumber = troopNumberStorage;
        troopDataStorage.troopType = troopTypeStorage;
        troopDataStorage.soldiersCount = soldiersCountStorage;
        troopDataStorage.soldiersList = soldiersListStorage;

        return troopDataStorage;
    }

    public void printTroop(){
        Soldier soldierDataStorage;
        System.out.println("Номер взвода: " + this.troopNumber);
        System.out.println("Тип взвода: " + this.troopType);
        System.out.println("Количество солдат во взводе: " + this.soldiersCount);
        System.out.println("Список солдат:");
        for (int i = 0; i < this.soldiersCount; i++){
            soldierDataStorage = this.soldiersList.get(i);

            System.out.println("Солдат " + (i + 1));
            soldierDataStorage.printSoldier();
        }
    }

    public void addSoldier(Soldier soldierDataStorage){
        this.soldiersCount++;
        this.soldiersList.add(soldierDataStorage);
    }

    public void deleteSoldier(){
        int deleteSoldierNumber;
        Soldier soldierDataStorage;

        Scanner input = new Scanner(System.in);

        System.out.println("Список солдат:\n");
        for (int i = 0; i < this.soldiersCount; i++){
            System.out.println("Солдат " + (i + 1) + ":");
            soldierDataStorage = this.soldiersList.get(i);
            soldierDataStorage.printSoldier();
        }

        System.out.println("Введите номер солдата, которого хотите удалить:");

        do{
            deleteSoldierNumber = input.nextInt();
            if ((deleteSoldierNumber > this.soldiersCount) | (deleteSoldierNumber < 1)) {
                System.out.println("Вы ввели неверный номер. Повторите ввод:");
            }
        }while((deleteSoldierNumber > this.soldiersCount) | (deleteSoldierNumber < 1));
        this.soldiersList.remove(deleteSoldierNumber - 1);
        this.soldiersCount--;
    }
}
