package main.java.org.course;

public class Task3 {
    public static void main(String[] args) throws HotelException {

        // вывести по каждому из отелей:
        // общее количество номеров
        // список номеров с их описанием

        Hotel[] hotels = new Hotel[2];
        hotels[0] = HotelFactory.createHotel("У мамы лучше");
        hotels[1] = HotelFactory.createHotel("Шашлычок");

        Hotels.printHotelInfo(hotels);

        Hotel.printAvailableApartmentByHotelName(hotels, "У мамы лучше", 4);

        // for test:
//        Hotel.printAvailableApartmentByHotelName(hotels, "У папы лучше", 4);
//        Hotel.printAvailableApartmentByHotelName(hotels, "У мамы лучше", 40);
//        Hotel.printAvailableApartmentByHotelName(new Hotel[0], "У мамы лучше", 4);
//        Hotel.printAvailableApartmentByHotelName(new Hotel[1], "У мамы лучше", 4);


    }
}
