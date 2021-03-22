import static org.junit.Assert.*;
import org.junit.*;

public class CustomerTest {
	Customer CustomerTestObject;
	Rental rentalTest;
	
	@Before
	public void init() {
		CustomerTestObject = new Customer("NameTest");
		rentalTest = new Rental(new Movie("MovieTest", Movie.REGULAR),1);
	}
	@Test
	public void testAddRental_GetRentals() {
		CustomerTestObject.addRental(rentalTest);
		assertSame(rentalTest,CustomerTestObject.getRentals().nextElement());
	}

	@Test
	public void testGetName() {
		assertEquals("NameTest",CustomerTestObject.getName());
	}

	@Test
	public void testTextStatement() {
		CustomerTestObject.addRental(rentalTest);
		String result = "Rental Record for " + "NameTest" + "\n" + 
		"\t" + "MovieTest" + "\t" + String.valueOf(rentalTest.getCharge()) + "\n" + 
		"Amount owed is " + String.valueOf(rentalTest.getCharge()) + "\n" + 
		"You earned " + String.valueOf(rentalTest.getFrequentRenterPoints()) +
        " frequent renter points";
		assertEquals(result,CustomerTestObject.textStatement());
	}

	@Test
	public void testGetTotalCharge() {
		assertTrue(0==CustomerTestObject.getTotalCharge());
	}

	@Test
	public void testGetTotalFrequentRenterPoints() {
		assertTrue(0==CustomerTestObject.getTotalFrequentRenterPoints());
	}

	@Test
	public void testHtmlStatement() {
		CustomerTestObject.addRental(rentalTest);
		String result = "<H1>Rentals for <EM>" + "NameTest" + "</EM></H1><P>\n" +
		"MovieTest" + ": " + String.valueOf(rentalTest.getCharge()) + "<BR>\n" +
		"<P>You owe <EM>" + String.valueOf(rentalTest.getCharge()) + "</EM><P>\n" + 
		"On this rental you earned <EM>" + String.valueOf(rentalTest.getFrequentRenterPoints()) + 
	    "</EM> frequent renter points<P>";
		assertEquals(result,CustomerTestObject.htmlStatement());
	}

}
