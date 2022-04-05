import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class TestCases {
	
	@Test
	void testOneReservation() {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		
		ArrayList<String> nameOfReservation = new ArrayList<String>();
		nameOfReservation.add("R001");
		
		MovieTheaterSeatDistributer distributer = new MovieTheaterSeatDistributer(map, nameOfReservation);
		
		distributer.seatDistributer();
		
		String result = "Assigned Reservations: \n" + "\n" + "R001 F1";
		assertEquals(result, distributer.getResult());
	}
	
	@Test
	void testInvalidReservation() {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, -1);
		
		ArrayList<String> nameOfReservation = new ArrayList<String>();
		nameOfReservation.add("R001");
		
		MovieTheaterSeatDistributer distributer = new MovieTheaterSeatDistributer(map, nameOfReservation);
		
		distributer.seatDistributer();
		
		String result = "The reservation R001 cannot be assigned because of incorrect customer number!\n";
		assertEquals(result, distributer.getErrorMessage());
	}
	
	@Test
	void testExceedCustomerNumberReservation() {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 50);
		
		ArrayList<String> nameOfReservation = new ArrayList<String>();
		nameOfReservation.add("R001");
		
		MovieTheaterSeatDistributer distributer = new MovieTheaterSeatDistributer(map, nameOfReservation);
		
		distributer.seatDistributer();
		
		String result = "The reservation R001 cannot be assigned due to public safety!\n";
		assertEquals(result, distributer.getErrorMessage());
	}
	
	@Test
	void testMaxCustomerReservation() {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 20);
		map.put(2, 20);
		map.put(3, 20);
		map.put(4, 20);
		
		ArrayList<String> nameOfReservation = new ArrayList<String>();
		nameOfReservation.add("R001");
		nameOfReservation.add("R002");
		nameOfReservation.add("R003");
		nameOfReservation.add("R004");
		
		MovieTheaterSeatDistributer distributer = new MovieTheaterSeatDistributer(map, nameOfReservation);
		
		distributer.seatDistributer();
		
		String result = "Assigned Reservations: \n" + "\n" + "R001 F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, F17, F18, F19, F20"
				+ "\n" + "R002 H1, H2, H3, H4, H5, H6, H7, H8, H9, H10, H11, H12, H13, H14, H15, H16, H17, H18, H19, H20"
				+ "\n" + "R003 J1, J2, J3, J4, J5, J6, J7, J8, J9, J10, J11, J12, J13, J14, J15, J16, J17, J18, J19, J20"
				+ "\n" + "R004 D1, D2, D3, D4, D5, D6, D7, D8, D9, D10, D11, D12, D13, D14, D15, D16, D17, D18, D19, D20";
		assertEquals(result, distributer.getResult());
	}

}
