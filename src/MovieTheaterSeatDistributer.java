

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The movie theater seat distributer class to assign seats based on reservation.
 * 
 * @author Jinxiang Zeng
 * @version 4/5/2022
 */
public class MovieTheaterSeatDistributer {
	
	private HashMap<Integer, Integer> map;
	
	private HashMap<String, ArrayList<Integer>> availableSeats;
	
	private ArrayList<String> nameOfReservation;
	
	private String result;
	
	private String errorMessage;
	
	private String[] rowNames = {"B", "D", "F", "H", "J"};
	
	/**
	 * Initialize Constructor.
	 * 
	 * @precondition map != null and nameOfReservation != null
	 * @postcondition none
	 * 
	 * @param map the map that contains reservation data
	 * @param nameOfReservation the list of reservation identifier
	 */
	public MovieTheaterSeatDistributer(HashMap<Integer, Integer> map, ArrayList<String> nameOfReservation) {
		if (map == null) {
			throw new IllegalArgumentException("The map cannot be null!");
		}
		
		if (nameOfReservation == null) {
			throw new IllegalArgumentException("The name of reservation cannot be null!");
		}
		this.map = map;
		this.availableSeats = new HashMap<String, ArrayList<Integer>>();
		this.nameOfReservation = nameOfReservation; 
		this.result = "Assigned Reservations: \n";
		this.errorMessage = "";
		this.initializeAvailableSeats();
	}
	
	/**
	 * Get error message that shows unassigned reservation data.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return The error message that shows unassigned reservation data.
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
	/**
	 * Get assigned reservation result.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return The assigned reservation result.
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Save assigned reservation result to out file.
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void saveResultToFile() {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("files/output"));
			writer.append(this.result);
			writer.close();
		} catch (IOException e1) {
				e1.printStackTrace();
		} 
	}
	
	/**
	 * Assign seats for customers of each reservation.
	 * 
	 * @precondition none
	 * @postcondition this.result = result and this.erroeMessage = erroeMessage.
	 */
	public void seatDistributer() {
		Iterator<Entry<Integer, Integer>> iterator = this.map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<Integer, Integer> item = (Map.Entry<Integer, Integer>)iterator.next();
			
			int requestSize = item.getValue();
			String reservation = this.nameOfReservation.get(item.getKey() - 1);
			if (requestSize <= 0) {
				this.errorMessage += "The reservation " + reservation + " cannot be assigned because of incorrect customer number!\n";
			} else {
				boolean isAssigned = this.assignMostSatisfactory(requestSize, reservation);
				if (isAssigned == false) {
					boolean isAssignedAgain = this.assignLessSatisfactory(requestSize, reservation);
					if (isAssignedAgain == false) {
						this.errorMessage += "The reservation " + reservation + " cannot be assigned due to public safety!\n";
					}
				}
				
			}
		}
	}
	
	private void initializeAvailableSeats() {
		for (int i = 0; i < this.rowNames.length; i++) {
			ArrayList<Integer> availbles = new ArrayList<Integer>();
			for (int y = 1; y <= 20; y++) {
				availbles.add(y);
			}
			this.availableSeats.put(this.rowNames[i], availbles);
		}
	}
	
	private boolean assignMostSatisfactory(int requestSize, String rowNumber) {
		for (int i = 2; i < 5; i++) {
			String row = this.rowNames[i];
			ArrayList<Integer> availables = this.availableSeats.get(row);
			if ((availables.size() / requestSize) > 0) {
				this.result += "\n" +  rowNumber + " ";
				for (int seat = 0; seat < requestSize; seat++) {
					String seatNumber = row + availables.get(0);
					if (seat == requestSize - 1) {
						this.result += seatNumber;
					} else {
						this.result += seatNumber + ", ";
					}
					availables.remove(0);
				}
				this.availableSeats.put(row, availables);
				return true;
			}
		}
		return false;
	}
	
	private boolean assignLessSatisfactory(int requestSize, String rowNumber) {
		for (int i = 1; i >= 0; i--) {
			String row = this.rowNames[i];
			ArrayList<Integer> availables = this.availableSeats.get(row);
			if ((availables.size() / requestSize) > 0) {
				this.result += "\n" + rowNumber + " ";
				for (int seat = 0; seat < requestSize; seat++) {
					String seatNumber = row + availables.get(0);
					if (seat == requestSize - 1) {
						this.result += seatNumber;
					} else {
						this.result += seatNumber + ", ";
					}
					availables.remove(0);
				}
				this.availableSeats.put(row, availables);
				return true;
			}
		}
		return false;
	}
}
