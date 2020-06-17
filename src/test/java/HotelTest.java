import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HotelTest {

    private ConferenceRoom confRoom1;
    private ConferenceRoom confRoom2;
    private ConferenceRoom confRoom3;
    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private Bedroom bedroom3;
    private Guest guest1;
    private Hotel hotel;

    @Before
    public void before(){
        confRoom1 = new ConferenceRoom("Crazy Conference Room", 3);
        confRoom2 = new ConferenceRoom("Final Conference Room", 5);
        confRoom3 = new ConferenceRoom("The Conference Room", 10);
        bedroom1 = new Bedroom(20, 2, "double");
        bedroom2 = new Bedroom(13, 1, "single");
        bedroom3 = new Bedroom(8, 1, "single");
        guest1 = new Guest("Michael Jackson");
        hotel = new Hotel();
        hotel.addBedroom(bedroom1);
        hotel.addBedroom(bedroom2);
        hotel.addConfRoom(confRoom1);
        hotel.addConfRoom(confRoom2);
    }

    @Test
    public void hasBedroomCount(){
        assertEquals(2, hotel.bedroomCount());
    }

    @Test
    public void hasConfRoomCount(){
        assertEquals(2, hotel.confRoomCount());
    }

    @Test
    public void canAddBedroom(){
        hotel.addBedroom(bedroom3);
        assertEquals(3, hotel.bedroomCount());
    }

    @Test
    public void canAddConfRoom(){
        hotel.addConfRoom(confRoom3);
        assertEquals(3, hotel.confRoomCount());
    }

//    @Test
//    public void hasEmptyRoom(){
//        hotel.addConfRoom(confRoom1);
//        hotel.addBedroom(bedroom1);
//        assertTrue(hotel.bedrooms.hasEmptyRoom());
//        assertTrue(hotel.confRooms.hasEmptyRoom());
//    }

    @Test
    public void canCheckInBedroom(){
        hotel.checkInBedroom(guest1, bedroom1);
        assertEquals(1, bedroom1.guestCount());
    }

    @Test
    public void canCheckInConfRoom(){
        hotel.checkInConfRoom(guest1, confRoom1);
        assertEquals(1, confRoom1.guestCount());
    }

    @Test
    public void canCheckOutBedroom(){
        hotel.checkInBedroom(guest1, bedroom1);
        assertEquals(guest1, hotel.checkOutBedroom(guest1, bedroom1));
    }

    @Test
    public void canCheckOutConfRoom(){
        hotel.checkInConfRoom(guest1, confRoom1);
        hotel.checkOutConfRoom(guest1, confRoom1);
        assertEquals(0, confRoom1.guestCount());
    }
}
