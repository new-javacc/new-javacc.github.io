import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReplaceURL {
	public static void main(String[] args) {
		File file = new File(".");
		ArrayList<File> files = UpdatePages.getAllFiles("html");
		for (File f : files) {
			Scanner scan = null;
			try {
				scan = new Scanner(f);
			} catch (FileNotFoundException e) {
				System.err.println("ERROR: Could not find file " + f.getName());
				continue;
			}
			System.out.println("Fixing file " + f.getName());
			String text = "";
			while (scan.hasNext()) {
				String str = scan.nextLine();
				String oldURL = "new-javacc.github.io";
				int index = str.indexOf(oldURL);
				if (index != -1) {
					str = str.substring(0, index) + "javacc.org" + str.substring(index + oldURL.length());
				}
				text += str + "\n";
			}
			scan.close();
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(f);
			} catch (FileNotFoundException e) {
				System.err.println("ERROR: Could not find file " + f.getName());
				continue;
			}
			pw.println(text);
			pw.close();
		}
	}
}