import static org.junit.Assert.*;
import org.junit.*;

public class RentalTest {
	Rental RentalTestObject;
	Movie movieTest;
	@Before
	public void init() {
		movieTest = new Movie("MovieTest", Movie.REGULAR);
		RentalTestObject = new Rental(movieTest,1);
	}
	@Test
	public void testGetDaysRented() {
		assertTrue(1==RentalTestObject.getDaysRented());
	}

	@Test
	public void testGetMovie() {
		assertSame(movieTest,RentalTestObject.getMovie());
	}

	@Test
	public void testGetCharge() {
		assertTrue(2==RentalTestObject.getCharge());
	}

	@Test
	public void testGetFrequentRenterPoints() {
		assertTrue(1==RentalTestObject.getFrequentRenterPoints());
	}

}
