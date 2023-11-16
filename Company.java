import java.util.Scanner;
import java.util.ArrayList;

public class Company {
    private int companyNumber;
    private String companyType;
    private int troopsCount;
    private ArrayList<Troop> troopsList = new ArrayList<>();

    public Company(){

    }

    public Company(int companyNumber,
                   String companyType,
                   int troopsCount,
                   ArrayList<Troop> troopsList) {
        this.companyNumber = companyNumber;
        this.companyType = companyType;
        this.troopsCount = troopsCount;
        this.troopsList = troopsList;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public void setTroopsCount(int troopsCount) {
        this.troopsCount = troopsCount;
    }

    public void setTroopsList(ArrayList<Troop> troopsList) {
        this.troopsList = troopsList;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public String getCompanyType() {
        return companyType;
    }

    public int getTroopsCount() {
        return troopsCount;
    }

    public ArrayList<Troop> getTroopsList() {
        return troopsList;
    }

    public Company createCompany(){
        int companyNumberStorage;
        String companyTypeStorage;
        int troopsCountStorage;
        ArrayList<Troop> troopsListStorage = new ArrayList<>();
        Troop troopDataStorage = new Troop();
        Company companyDataStorage = new Company();

        Scanner input = new Scanner(System.in);

        System.out.print("Введите номер роты: ");
        companyNumberStorage = input.nextInt();

        input.nextLine();
        System.out.print("Введите тип роты: ");
        companyTypeStorage = input.nextLine();

        System.out.print("Введите количество взводов: ");
        troopsCountStorage = input.nextInt();

        for (int i = 0; i < troopsCountStorage; i++){
            System.out.println("Введите данные о взводе " + (i + 1) + ":");
            troopsListStorage.add(troopDataStorage = troopDataStorage.createTroop());
        }

        companyDataStorage.companyNumber = companyNumberStorage;
        companyDataStorage.companyType = companyTypeStorage;
        companyDataStorage.troopsCount = troopsCountStorage;
        companyDataStorage.troopsList = troopsListStorage;

        return companyDataStorage;
    }

    public void printCompany(){
        Troop troopDataStorage;
        System.out.println("Номер роты: " + this.companyNumber);
        System.out.println("Тип роты: " + this.companyType);
        System.out.println("Количество взводов в роте: " + this.troopsCount);
        System.out.println("Список взводов:");
        for (int i = 0; i < this.troopsCount; i++){
            troopDataStorage = this.troopsList.get(i);

            System.out.println("Взвод " + (i + 1));
            troopDataStorage.printTroop();
            System.out.println("-----------------------");
        }
    }

    public void addTroop(Troop troopDataStorage){
        this.troopsCount++;
        this.troopsList.add(troopDataStorage);
    }

    public void deleteTroop(){
        int deleteTroopNumber;
        Troop troopDataStorage;

        Scanner input = new Scanner(System.in);

        System.out.println("Список взводов:\n");
        for (int i = 0; i < this.troopsCount; i++){
            System.out.println("Взвод " + (i + 1) + ":");
            troopDataStorage = this.troopsList.get(i);
            troopDataStorage.printTroop();
        }

        System.out.println("Введите номер взвода, которого хотите удалить:");

        do{
            deleteTroopNumber = input.nextInt();
            if ((deleteTroopNumber > this.troopsCount) | (deleteTroopNumber < 1)) {
                System.out.println("Вы ввели неверный номер. Повторите ввод:");
            }
        }while((deleteTroopNumber > this.troopsCount) | (deleteTroopNumber < 1));
        this.troopsList.remove(deleteTroopNumber - 1);
        this.troopsCount--;
    }
}
