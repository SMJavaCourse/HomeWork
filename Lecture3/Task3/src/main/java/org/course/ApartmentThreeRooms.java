package main.java.org.course;

public class ApartmentThreeRooms extends Apartment {
    public ApartmentThreeRooms(float price, int places, int roomNumber) {
        super(price, places, roomNumber);
    }

    @Override
    public String toString() {
        return "Трехкомнатный номер " + "(комната номер " + super.getRoomNumber() + "): \n" +
                "\tЦена: " + super.getPrice() + "\n" +
                "\tВместительность: " + super.getPlaces() + "\n" +
                "\tВремя заселение/выселения: " + super.getCheckinTime() + "\n" +
                "\tДополнительные услуги: " + (super.isBalcony() ? "Балкон " : "") +
                (super.isCleaning() ? "Уборка " : "") +
                (super.isInternet() ? "Интернет " : "") +
                (super.isConditioner() ? "Кондиционер " : "") +
                (super.isGrillMeat() ? "Шашлычок в номер:) " : "");
    }
}
