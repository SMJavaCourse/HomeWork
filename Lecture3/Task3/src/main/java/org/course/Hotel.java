package org.course;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Apartment> apartments;
    private String startTime;

    public Hotel(String name, String startTime, ArrayList<Apartment> apartments) {
        this.name = name;
        this.apartments = apartments;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }

    @Override
    public String toString() throws NullPointerException {
        StringBuilder text = new StringBuilder("Отель \"" + name + "\"\nКоличество номеров: " + apartments.size() +
                "\nВремя заселение/выселения: " + startTime + "\nНомера:\n");
        for (Apartment apartment : apartments) {
            text.append(apartment.toString());
        }
        return text.toString();
    }

    public static ArrayList<Hotel> findHotelNew(ArrayList<Hotel> hotels, String nameOfHotel, int numberOfGuests) {
        int numberOfApartmentsFound = 0;
        String findHotel = "";
        String findApartment = "";

        ArrayList findHotelsResult = new ArrayList();
        ArrayList<Apartment> findApartmentsResult = new ArrayList<>();

        if (numberOfGuests == 0) {
            findHotelsResult.add("Количество гостей равно нулю");
            return findHotelsResult;
        } else if (numberOfGuests < 0) {
            findHotelsResult.add("Количество гостей не может быть отрицательным");
            return findHotelsResult;
        } else if (nameOfHotel == null) {
            for (int i = 0; i < hotels.size(); i++) {
                findApartmentsResult = findApartmentNew(hotels.get(i).getApartments(),numberOfGuests);
                if (findApartmentsResult != null) {
                    findHotelsResult.add(hotels.get(i));
                }
            }
//            findHotelsResult.add("Найдено отелей: " + numberOfHotelsFound + "\n" + findHotel);
//            findHotelsResult.add(findApartmentsResult);
            return findHotelsResult;
        }
        for (int i = 0; i < hotels.size(); i++) {
            if (StringUtils.equalsIgnoreCase(nameOfHotel, hotels.get(i).getName())) {
                findHotel += "Отель \"" + hotels.get(i).name + "\"\n";
                for (int j = 0; j < hotels.get(i).getApartments().size(); j++) {
                    if (numberOfGuests <= hotels.get(i).getApartments().get(j).getCapacity()) {
                        findApartment += hotels.get(i).getApartments().get(j).toString();
                        numberOfApartmentsFound += 1;
                    }
                }
                if (numberOfApartmentsFound == 0) {
                    findHotelsResult.add("В отеле \"" + nameOfHotel + "\" подходящих номеров не найдено.");
                } else {
                    findHotelsResult.add(findHotel + "Подходящих номеров: " + numberOfApartmentsFound + "\nНомера:\n" + findApartment);
                }
                return findHotelsResult;
            }
        }
        findHotelsResult.add("У нас нет информации по отелю \"" + nameOfHotel + "\"");
        return findHotelsResult;
    }

    public static ArrayList<Apartment> findApartmentNew(ArrayList<Apartment> apartments, int numberOfGuests) {
        ArrayList findApartmentsResult = new ArrayList();
        for (int j = 0; j < apartments.size(); j++) {
            if (numberOfGuests <= apartments.get(j).getCapacity()) {
                findApartmentsResult.add(apartments.get(j));
            }
        }
        if (findApartmentsResult.size() == 0) {
            findApartmentsResult.add("подходящих номеров не найдено");
            return null;
        }
        return findApartmentsResult;
    }


    public static String findHotel(ArrayList<Hotel> hotels, String nameOfHotel, int numberOfGuests) {
        int numberOfApartmentsFound = 0;
        String findHotel = "";
        String findApartment = "";

        if (numberOfGuests == 0) {
            return "Количество гостей равно нулю";
        } else if (numberOfGuests < 0) {
            return "Количество гостей не может быть отрицательным";
        } else if (nameOfHotel == null) {
            int numberOfHotelsFound = 0;
            for (int i = 0; i < hotels.size(); i++) {
                findHotel += "Отель \"" + hotels.get(i).name + "\"\n";
                for (int j = 0; j < hotels.get(i).getApartments().size(); j++) {
                    if (numberOfGuests <= hotels.get(i).getApartments().get(j).getCapacity()) {
                        findApartment += hotels.get(i).getApartments().get(j).toString();
                        numberOfApartmentsFound += 1;
                    }
                }
                if (numberOfApartmentsFound == 0) {
                    findHotel = "";
                } else {
                    numberOfHotelsFound += 1;
                    findHotel += "Подходящих номеров: " + numberOfApartmentsFound + "\nНомера:\n" + findApartment;
                }
            }
            return "Найдено отелей: " + numberOfHotelsFound + "\n" + findHotel;
        }
        for (int i = 0; i < hotels.size(); i++) {
            if (StringUtils.equalsIgnoreCase(nameOfHotel, hotels.get(i).getName())) {
                findHotel += "Отель \"" + hotels.get(i).name + "\"\n";
                for (int j = 0; j < hotels.get(i).getApartments().size(); j++) {
                    if (numberOfGuests <= hotels.get(i).getApartments().get(j).getCapacity()) {
                        findApartment += hotels.get(i).getApartments().get(j).toString();
                        numberOfApartmentsFound += 1;
                    }
                }
                if (numberOfApartmentsFound == 0) {
                    return "В отеле \"" + nameOfHotel + "\" подходящих номеров не найдено.";
                } else {
                    return findHotel + "Подходящих номеров: " + numberOfApartmentsFound + "\nНомера:\n" + findApartment;
                }
            }
        }
        return "У нас нет информации по отелю \"" + nameOfHotel + "\"";
    }


}
