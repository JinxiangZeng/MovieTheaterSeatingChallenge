
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The file reader class to read data from file.
 * 
 * @author Jinxiang Zeng
 * @version 4/5/2022
 */
public class FileReader {
	
	private HashMap<Integer, Integer> map;
	
	private int reservationIdentifier;
	
	private int reservationRequest;
	
	private ArrayList<String> nameOfReservation;
	
	/**
	 * Initialize constructor.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param fileName the file that contains reservation data.
	 */
	public FileReader(String fileName) {
		this.map = new HashMap<Integer, Integer>();
		this.reservationIdentifier = 0;
		this.reservationRequest = 1;
		this.nameOfReservation = new ArrayList<String>();
		this.readFile(fileName);
	}

	private void readFile(String fileName) {
		File file = new File(fileName);
		try {
			Scanner scanner = new Scanner(file);
			int count = 1;
			while(scanner.hasNextLine()) {
				String[] nextLine = scanner.nextLine().split(" ");
				int requestReservation = Integer.parseInt(nextLine[this.reservationRequest]);
				this.nameOfReservation.add(nextLine[this.reservationIdentifier]);
				this.map.put(count, requestReservation);
				count++;
			}
			scanner.close();
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("\nError:\n" + fileNotFoundException.getMessage());
		} catch (NoSuchElementException fileInvalid) {
			System.out.println("\nError:\n" + fileInvalid.getMessage());
		} catch (IndexOutOfBoundsException indexOutOfBound) {
			System.out.println("\nError:\n" + indexOutOfBound.getMessage());
		} catch (NumberFormatException numberError) {
			System.out.println("\nError:\n" + numberError.getMessage());
		}
	}
	
	/**
	 * Get the map that contains reservation data phrased from file.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return The map that contains reservation data phrased from file.
	 */
	public HashMap<Integer, Integer> getMap() {
		return this.map;
	}
	
	/**
	 * Get list of reservation identifier.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return The list of reservation identifier.
	 */
	public ArrayList<String> getNameOfReservation() {
		return this.nameOfReservation;
	}
}
