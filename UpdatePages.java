import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;

public class UpdatePages {

	public static void main(String[] args) {
		ArrayList<File> files = getAllHtmlFiles();
		update(files);
		System.out.println("Successfully updated all HTML pages.");
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

	public static void update(ArrayList<File> files) {
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
			Scanner temp = null;
			try {
				temp = new Scanner(new File("commonbuttons.txt"));
			} catch (FileNotFoundException e) {
				System.err.println("Failure");
				continue;
			}
			String templateText = "";
			while (temp.hasNext()) {
				templateText += temp.nextLine() + "\n";
			}
			String currentLine = "";
			String wholeText = "";
			while (input.hasNext()) {
				while (input.hasNext() && currentLine.indexOf("<!--template-->") == -1) {
					currentLine = input.nextLine();
					wholeText += currentLine + "\n";
				}
				if (!input.hasNext()) break;
				wholeText += templateText;
				while (input.hasNext() && currentLine.indexOf("<!--end-->") == -1) {
					currentLine = input.nextLine();
				}
				if (!input.hasNext()) break;
				if (currentLine.indexOf("<!--end-->") != -1) wholeText += currentLine + "\n";
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
			temp.close();
			System.out.println("Success");
		}
	}
}