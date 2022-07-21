package constructors;

import constructors.ApartBuilder;
import org.course.Apartment;
import org.course.Hotel;

public class HotelFactory {

    private static HotelFactory instance;

    public static HotelFactory getInstance(){
        if (instance == null) {
            instance = new HotelFactory();
        }
        return instance;
    }

    public Hotel createHotel(String nameOfHotel){
        ApartBuilder builder = new ApartBuilder();
        
        switch (nameOfHotel) {
            case "У мамы лучше":
                Apartment[] apartmentsHotelGMama = new Apartment[5];
                apartmentsHotelGMama[0] = builder
                        .apartment(1).num(1).price(1000).capacity(2)
                        .isClean(false)
                        .isInternet(false)
                        .isСonditioner(false)
                        .isBalcony(true)
                        .build();
                apartmentsHotelGMama[1] = builder
                        .apartment(2).num(2).price(3000.0F).time("12:00").capacity(4)
                        .isClean(true)
                        .isInternet(true)
                        .isСonditioner(true)
                        .isBalcony(true)
                        .build();
                apartmentsHotelGMama[2] = builder
                        .apartment(2).num(3).price(3000.0F).time("12:00").capacity(4)
                        .isClean(true)
                        .isInternet(true)
                        .isСonditioner(true)
                        .isBalcony(true)
                        .build();
                apartmentsHotelGMama[3] = builder
                        .apartment(3).num(4).price(2500.0F).time("12:00").capacity(6)
                        .isClean(false)
                        .isInternet(false)
                        .isСonditioner(false)
                        .isBalcony(false)
                        .build();
                apartmentsHotelGMama[4] = builder
                        .apartment(4).num(5).price(3500.0F).time("12:00").capacity(6)
                        .isClean(false)
                        .isInternet(true)
                        .isСonditioner(false)
                        .isBalcony(true)
                        .build();
                return new Hotel("У мамы лучше", "12:00", apartmentsHotelGMama);
            case "Шашлычок":
                Apartment[] apartmentsHotelShashlik = new Apartment[3];
                apartmentsHotelShashlik[0] = builder
                        .apartment(1).num(6).price(1000.0F).time("09:00").capacity(2)
                        .isClean(false)
                        .isInternet(false)
                        .isСonditioner(false)
                        .isBalcony(true)
                        .build();
                apartmentsHotelShashlik[1] = builder
                        .apartment(2).num(7).price(1000.0F).time("09:00").capacity(4)
                        .isClean(true)
                        .isInternet(false)
                        .isСonditioner(false)
                        .isBalcony(true)
                        .build();
                apartmentsHotelShashlik[2] = builder
                        .apartment(3).num(8).price(4000.0F).time("09:00").capacity(6)
                        .isClean(true)
                        .isInternet(false)
                        .isСonditioner(false)
                        .isBalcony(false)
                        .build();
                return new Hotel("Шашлычок", "09:00", apartmentsHotelShashlik);
        }
        return null;
    }
}
