import java.util.Scanner;
import java.util.ArrayList;

public class Battalion {
    private int battalionNumber;
    private String battalionType;
    private int companiesCount;
    private ArrayList<Company> companiesList = new ArrayList<>();

    public Battalion(){

    }

    public Battalion(int battalionNumber,
                     String battalionType,
                     int companiesCount,
                     ArrayList<Company> companiesList) {
        this.battalionNumber = battalionNumber;
        this.battalionType = battalionType;
        this.companiesCount = companiesCount;
        this.companiesList = companiesList;
    }

    public void setBattalionNumber(int battalionNumber) {
        this.battalionNumber = battalionNumber;
    }

    public void setBattalionType(String battalionType) {
        this.battalionType = battalionType;
    }

    public void setCompaniesCount(int companiesCount) {
        this.companiesCount = companiesCount;
    }

    public void setCompaniesList(ArrayList<Company> companiesList) {
        this.companiesList = companiesList;
    }

    public int getBattalionNumber() {
        return battalionNumber;
    }

    public String getBattalionType() {
        return battalionType;
    }

    public int getCompaniesCount() {
        return companiesCount;
    }

    public ArrayList<Company> getCompaniesList() {
        return companiesList;
    }

    public Battalion createBattalion(){
        int battalionNumberStorage;
        String battalionTypeStorage;
        int companiesCountStorage;
        ArrayList<Company> companiesListStorage = new ArrayList<>();
        Company companyDataStorage = new Company();
        Battalion battalionDataStorage = new Battalion();

        Scanner input = new Scanner(System.in);

        System.out.print("Введите номер баттальона: ");
        battalionNumberStorage = input.nextInt();

        input.nextLine();
        System.out.print("Введите тип баттальона: ");
        battalionTypeStorage = input.nextLine();

        System.out.print("Введите количество рот: ");
        companiesCountStorage = input.nextInt();

        for (int i = 0; i < companiesCountStorage; i++){
            System.out.println("Введите данные о роте " + (i + 1) + ":");
            companiesListStorage.add(companyDataStorage = companyDataStorage.createCompany());
        }

        battalionDataStorage.battalionNumber = battalionNumberStorage;
        battalionDataStorage.battalionType = battalionTypeStorage;
        battalionDataStorage.companiesCount = companiesCountStorage;
        battalionDataStorage.companiesList = companiesListStorage;

        return battalionDataStorage;
    }

    public void printBattalion(){
        Company companyDataStorage;
        System.out.println("Номер баттальона: " + this.battalionNumber);
        System.out.println("Тип баттальона: " + this.battalionType);
        System.out.println("Количество рот в баттальоне: " + this.companiesCount);
        System.out.println("Список рот:");
        for (int i = 0; i < this.companiesCount; i++){
            companyDataStorage = this.companiesList.get(i);

            System.out.println("Рота " + (i + 1));
            companyDataStorage.printCompany();
        }
    }

    public void addCompany(Company companyDataStorage){
        this.companiesCount++;
        this.companiesList.add(companyDataStorage);
    }

    public void deleteCompany(){
        int deleteCompanyNumber;
        Company companyDataStorage;

        Scanner input = new Scanner(System.in);

        System.out.println("Список рот:\n");
        for (int i = 0; i < this.companiesCount; i++){
            System.out.println("Рота " + (i + 1) + ":");
            companyDataStorage = this.companiesList.get(i);
            companyDataStorage.printCompany();
        }

        System.out.println("Введите номер роты, которую хотите удалить:");

        do{
            deleteCompanyNumber = input.nextInt();
            if ((deleteCompanyNumber > this.companiesCount) | (deleteCompanyNumber < 1)) {
                System.out.println("Вы ввели неверный номер. Повторите ввод:");
            }
        }while((deleteCompanyNumber > this.companiesCount) | (deleteCompanyNumber < 1));
        this.companiesList.remove(deleteCompanyNumber - 1);
        this.companiesCount--;
    }
}
