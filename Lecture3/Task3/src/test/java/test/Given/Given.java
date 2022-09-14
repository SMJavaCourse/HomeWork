//package test.Given;
//
//import org.course.Apartment;
//import org.course.Hotel;
//import org.jeasy.random.EasyRandom;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
//public class Given {
//
//    Random random = new Random();
//
//    public Apartment randomApartments(EasyRandom easyRandom) {
//        int numberOfApart = random.nextInt(8);
//        int rooms = random.nextInt(4);
//        int capacity = random.nextInt(7);
//
//        var apartment = easyRandom.nextObject(Apartment.class);
//        apartment.setNumberOfApart(numberOfApart);
//        apartment.setRooms(rooms);
//        apartment.setCapacity(capacity);
//        return apartment;
//    }
//
//    public Hotel randomHotel(EasyRandom easyRandom) {
//
//        ArrayList<Apartment> apartments = new ArrayList<>();
//        for (int i = 0; i < random.nextInt(5) + 1; i++) {
//            apartments.add(randomApartments(easyRandom));
//        }
//        var hotel = easyRandom.nextObject(Hotel.class);
//        hotel.setApartments(apartments);
//
//        return hotel;
//    }
//
//    public ArrayList<Hotel> getSomeHotels(int count, EasyRandom easyRandom){
//        ArrayList<Hotel> hotels = new ArrayList<>(count);
//        for (int i = 0; i < count; i++) {
//            hotels.add(randomHotel(easyRandom));
//        }
//        return hotels;
//    }
//}
