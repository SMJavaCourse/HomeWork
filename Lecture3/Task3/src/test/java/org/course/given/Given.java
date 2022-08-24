package org.course.given;

import org.course.entity.Apartment;
import org.course.entity.Hotel;
import org.course.entity.properties.*;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.api.Randomizer;

import java.util.*;

public class Given {

    private static ArrayList<Services> sourceServices = new ArrayList<>();
    Random random = new Random();

    public Apartment randomApartment(EasyRandom easyRandom) {
        int rooms = random.nextInt(3) + 1;
        int numberOfRoom = random.nextInt(100) + 1;
        int capacity = (random.nextInt(2) + 1) * rooms;
        int price = random.nextInt(100) * 100 + 100;

        var apartament = easyRandom.nextObject(Apartment.class);
        apartament.setPrice(price);
        apartament.setRooms(rooms);
        apartament.setNumberOfRoom(numberOfRoom);
        apartament.setCapacity(capacity);

        if (rooms == 1) {
            apartament.setName("Однокомнатный номер");
        } else if (rooms == 2) {
            apartament.setName("Двухкомнатный номер");
        } else {
            apartament.setName("Трёхкомнатный номер");
        }

        return apartament;
    }

    public EasyRandom getEasyRandom() {
        sourceServices.add(new Balcony());
        sourceServices.add(new Cleaning());
        sourceServices.add(new Conditioner());
        sourceServices.add(new Internet());
        sourceServices.add(new Jacuzzi());
        sourceServices.add(new Meat());

        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.collectionSizeRange(1, sourceServices.size());
        parameters.stringLengthRange(10,50);
        parameters.randomize(Services.class, new Randomizer<>() {
            @Override
            public Services getRandomValue() {
                int number = random.nextInt(sourceServices.size());
                return sourceServices.get(number);
            }
        });
        return new EasyRandom(parameters);
    }

    public Hotel randomHotel(EasyRandom easyRandom) {
        ArrayList time = new ArrayList<>(Arrays.asList("07:00", "08:00", "09:00", "10:00", "11:00", "12:00",
                "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"));
        String startTime = time.get(random.nextInt(time.size())).toString();

        ArrayList<Apartment> apartments = new ArrayList<>();
        for (int i = 0; i < random.nextInt(5) + 1; i++) {
            apartments.add(randomApartment(easyRandom));
        }
        var hotel = easyRandom.nextObject(Hotel.class);
        hotel.setStartTime(startTime);
        hotel.setApartments(apartments);

        return hotel;
    }
    public ArrayList<Hotel> getSomeHotels(int count, EasyRandom easyRandom){
        ArrayList<Hotel> hotels = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            hotels.add(randomHotel(easyRandom));
        }
        return hotels;
    }
}
