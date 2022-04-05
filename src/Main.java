
/**
 * The main class to run program
 * 
 * @author Jinxiang Zeng
 * @version 4/5/2022
 */
public class Main {

	/**
	 * Main entry point of program.
	 * 
	 * @param args the command argument to run program.
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			
			String fileName = args[0];
			
			FileReader fileReader = new FileReader(fileName);
			
			MovieTheaterSeatDistributer distributer = new MovieTheaterSeatDistributer(fileReader.getMap(), fileReader.getNameOfReservation());
			distributer.seatDistributer();
			
			System.out.println(distributer.getResult());
			System.out.println();
			System.out.println("Please check your unassigned reservations: ");
			System.out.println();
			System.out.println(distributer.getErrorMessage());
			
			distributer.saveResultToFile();
			System.out.println();
			System.out.println("Woudl like to check result in file? --> Go to file/output could find output result file!");
		}
	}

}
