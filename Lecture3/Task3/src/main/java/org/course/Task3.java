package org.course;


public class Task3 {
    public static void main(String[] args) {
        Apartment[] apartmentsMom = new Apartment[2];
        apartmentsMom[0] = new Apartment(1, 2, 1, true, false, false, true, false);
        apartmentsMom[1] = new Apartment(3, 3, 2, true, true, false, false, true);
        Hotel mom = new Hotel("У мамы лучше", apartmentsMom, "12:00");
        System.out.println("Отель \"" + mom.getName() + "\"");
        System.out.println("Количество номеров: " + apartmentsMom.length + "\n" + "Номера:");
        for (Apartment apartment : apartmentsMom) {
            System.out.println("- Количество номеров на " + apartment.getRoomsCount() + " человека :" + apartment.getAmount()
                    + "\n" + "  - Время заселение/выселения: " + mom.getCheckInTime()
                    + "\n" + "  - Дополнительные услуги: " + apartment.isClening());
        }
    }
}


//        Hotel hotel1 = new Hotel("Первый нахъ", apartments);
//        Hotel hotel2 = new Hotel("Второй нахъ", apartments);
//
//        System.out.println(hotel1);
//        System.out.println(hotel2);
//        System.out.println(hotel1.getName());

//        HotelBuilder builder = new HotelBuilder();
//        Hotel grill = builder.name("Шашлычок").build();
//        Hotel mother = builder.name("У мамы лучше").build();
//        System.out.println(grill.getName());
//        System.out.println(mother.getName());
//        System.out.println(Arrays.toString(mother.getRooms()));


//проверка, что я не совсем кукухой отлетел и оно должно выводить хоть что то
//        String[] ciphers = new String[] {"раз","два","три","четыре,","пять","шесть","семь","восемь", "девять","десять"};
//        for (int i=0; i<1; ++i){
//            System.out.println(ciphers[i]);
//        }



