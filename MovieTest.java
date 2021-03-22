import static org.junit.Assert.*;

import org.junit.*;

public class MovieTest {
	Movie MovieTestObject;
	
	@Before
	public void init() {
		MovieTestObject = new Movie("Regular",Movie.REGULAR);
	}

	@Test
	public void testGetPriceCode() {
		assertEquals(Movie.REGULAR, MovieTestObject.getPriceCode());
	}

	@Test
	public void testSetPriceCodeRegular() {
		MovieTestObject.setPriceCode(Movie.REGULAR);
		assertEquals(Movie.REGULAR, MovieTestObject.getPriceCode());
	}
	
	@Test
	public void testSetPriceCodeChildrens() {
		MovieTestObject.setPriceCode(Movie.CHILDRENS);
		assertEquals(Movie.CHILDRENS, MovieTestObject.getPriceCode());
	}
	
	@Test
	public void testSetPriceCodeNew_Release() {
		MovieTestObject.setPriceCode(Movie.NEW_RELEASE);
		assertEquals(Movie.NEW_RELEASE, MovieTestObject.getPriceCode());
	}
	
	@Test
	public void testSetPriceCodeExeption() {
		try {
			MovieTestObject.setPriceCode(10);
			assertTrue(false);
		}catch(IllegalArgumentException exeption){
			assertTrue(true);
		}		
	}

	@Test
	public void testGetTitle() {
		assertEquals("Regular", MovieTestObject.getTitle());
	}

	@Test
	public void testGetChargeRegular() {
		assertTrue(3.5==MovieTestObject.getCharge(3));
	}
	
	@Test
	public void testGetChargeNewRelease() {
		MovieTestObject.setPriceCode(Movie.NEW_RELEASE);
		assertTrue(3==MovieTestObject.getCharge(1));
	}
	
	@Test
	public void testGetChargeChildrens() {
		MovieTestObject.setPriceCode(Movie.CHILDRENS);
		assertTrue(3==MovieTestObject.getCharge(4));
	}

	@Test
	public void testGetFrequentRenterPoints() {
		assertTrue(1==MovieTestObject.getFrequentRenterPoints(1));
	}
	
	@Test
	public void testGetFrequentRenterPointsNewRelease() {
		MovieTestObject.setPriceCode(Movie.NEW_RELEASE);
		int auxAssert = MovieTestObject.getFrequentRenterPoints(1);
		auxAssert += MovieTestObject.getFrequentRenterPoints(2);
		assertTrue(3==auxAssert);
	}

}
