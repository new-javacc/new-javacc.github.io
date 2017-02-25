import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;

public class UpdatePages {

	public static void main(String[] args) {
		ArrayList<File> files = getAllFiles("html", ".");
		ArrayList<File> temps = getAllFiles("tpl", ".");
		update(files, temps);
		System.out.println("Successfully updated all HTML pages.");
	}

	public static ArrayList<File> getAllFiles(String ext, String dir) {
		ArrayList<File> allFiles = new ArrayList<File>();
		File folder = new File(dir);
		File[] files1 = folder.listFiles();
		for (int i = 0; i < files1.length; i++) {
			if (files1[i].isDirectory() && !files1[i].getName().equals(".git")) {
				allFiles.addAll(getAllFiles(ext, dir + "/" + files1[i].getName()));
			}
			if (files1[i].getName().endsWith("." + ext)) allFiles.add(files1[i]);
		}
		return allFiles;
	}

	public static void update(ArrayList<File> files, ArrayList<File> templates) {
		for (File f : templates) {
			update(files, f.getName());
		}
	} 

	public static void update(ArrayList<File> files, String commonpath) {
		String name = commonpath.substring(0, commonpath.indexOf("."));
		for (int i = 0; i < files.size(); i++) {
			File htmlFile = files.get(i);
			System.out.println("Updating file: " + htmlFile.getName());
			Scanner input = null;
			try {
				input = new Scanner(htmlFile);
			} catch (FileNotFoundException e) {
				System.err.println("Failure in html file");
				continue;
			}
			Scanner temp = null;
			try {
				temp = new Scanner(new File(commonpath));
			} catch (FileNotFoundException e) {
				System.err.println("Failure in common path");
				continue;
			}
			String templateText = "";
			while (temp.hasNext()) {
				templateText += temp.nextLine() + "\n";
			}
			String currentLine = "";
			String wholeText = "";
			while (input.hasNext()) {
				while (input.hasNext() && currentLine.indexOf("<!--" + name + "-->") == -1) {
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