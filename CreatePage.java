import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class CreatePage {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the name of the new file -> ");
		newFile(kb.nextLine());
		System.out.println("Successfully created new page.");
	}

	public static void newFile(String name) {
		Scanner input = null;
		try {
			input = new Scanner(new File("template.html"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		PrintWriter output = null;
		try {
			output = new PrintWriter(new File(name));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		while (input.hasNext()) {
			output.println(input.nextLine());
		}
		input.close();
		output.close();
	}
}