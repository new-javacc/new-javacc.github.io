import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AddToHead {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter what you would like to add to the head:");
		String addition = kb.nextLine();
		update(getAllHtmlFiles(), addition);
	}

	public static ArrayList<File> getAllHtmlFiles() {
		ArrayList<File> allFiles = new ArrayList<File>();
		File folder = new File(".");
		File[] files1 = folder.listFiles();
		for (int i = 0; i < files1.length; i++) {
			if (files1[i].getName().endsWith(".html")) allFiles.add(files1[i]);
		}
		return allFiles;
	}

	public static void update(ArrayList<File> files, String addition) {
		for (int i = 0; i < files.size(); i++) {
			File htmlFile = files.get(i);
			System.out.println("Updating file: " + htmlFile.getName());
			Scanner input = null;
			try {
				input = new Scanner(htmlFile);
			} catch (FileNotFoundException e) {
				System.err.println("Failure");
				continue;
			}
			String currentLine = "";
			String wholeText = "";
			while (input.hasNext()) {
				currentLine = input.nextLine();
				wholeText += currentLine + "\n";
				if (currentLine.indexOf("<head>") != -1) wholeText += "\t\t" + addition + "\n";
			}
			PrintWriter output = null;
			try {
				output = new PrintWriter(htmlFile);
			} catch (FileNotFoundException e) {
				System.err.println("Failure");
				continue;
			}
			output.print(wholeText);
			output.close();
			input.close();
			System.out.println("Success");
		}
	}
}