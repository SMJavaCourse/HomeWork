//package test.helper;
//
//import org.course.Hotel;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import test.BaseTest;
//
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.Random;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//import static helper.SearchHelper.searchHotelString;
//import static org.junit.jupiter.api.Assertions.*;
//
//class SearchHelperTest extends BaseTest {
//
//    ArrayList<Hotel> hotels = new ArrayList<>();
//    Map<String, Hotel> hotelsByName;
//    String commandService = null;
//    String nameHotel = null;
//    int numberOfGuests = 0;
//    Random random = new Random();
//
//    @BeforeAll
//    void setUp() {
//        hotels = given.getSomeHotels(10, easyRandom);
//        hotelsByName = hotels
//                .stream()
//                .collect(Collectors.toMap(hotel -> hotel.getName().toLowerCase(), Function.identity()));
//    }
//    @Test
//    void findHotel(){
//    String actual = searchHotelString(nameHotel, commandService, numberOfGuests, hotelsByName).replaceAll("\n.*", "");
//    String expected = "Найдено отелей: " + hotels.size();
//    assertEquals(expected, actual);
//}
//}