import java.util.Scanner;
public class Soldier{
    private String callSign;
    private int equipNumber;
    Equip equipKit;

    public Soldier(){

    }

    public Soldier(String setCallSign,
                   int setEquipNumber,
                   Equip setEquipKit)
    {
        this.callSign = setCallSign;
        this.equipNumber = setEquipNumber;
        this.equipKit = setEquipKit;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public void setEquipNumber(int equipNumber) {
        this.equipNumber = equipNumber;
    }

    public void setEquipKit(Equip equipKit) {
        this.equipKit = equipKit;
    }

    public String getCallSign() {
        return callSign;
    }

    public int getEquipNumber() {
        return equipNumber;
    }

    public Equip getEquipKit() {
        return equipKit;
    }

    public Soldier createSoldier(){
        String callSignStorage;
        int equipNumberStorage;
        Equip equipKitStorage = new Equip();
        Soldier dataSoldierStorage = new Soldier();

        Scanner input = new Scanner(System.in);

        System.out.print("Введите позывной солдата: ");
        callSignStorage = input.nextLine();

        System.out.print("Введите номер снаряжения: ");
        equipNumberStorage = input.nextInt();

        equipKitStorage.createEquipKit();

        dataSoldierStorage.callSign = callSignStorage;
        dataSoldierStorage.equipNumber = equipNumberStorage;
        dataSoldierStorage.equipKit = equipKitStorage;
        return dataSoldierStorage;
    }

    public void printSoldier() {
        System.out.println("Позывной: " + callSign);
        System.out.println("Номер снаряжения: " + equipNumber);
        this.equipKit.printEquipKit();
    }

}