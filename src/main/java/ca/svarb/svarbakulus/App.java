package ca.svarb.svarbakulus;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {

	private static void createAndShowGUI() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		// Set visuals
		JFrame.setDefaultLookAndFeelDecorated(true);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		// Create and set up the window.
		JFrame frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add the ubiquitous "Hello World" label.
		frame.getContentPane().add(new JLabel("Welcome to SVARBakulus!"));

		// Frame dimensions
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width / 2, height / 2);
		frame.setLocationRelativeTo(null);

		// Display the window.
//		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		System.out.println("We are in Java " + System.getProperty("java.version"));

		String pathString = "e:/work/test-tree";
		Path path = Paths.get(pathString);

		BiPredicate<Path, BasicFileAttributes> predicate = (bpPath, bpAttrs) -> {
//				return bpAttrs.isDirectory();
			return bpAttrs.isRegularFile();
		};
		int maxDepth = Integer.MAX_VALUE;
		try (Stream<Path> stream = Files.find(path, maxDepth, predicate)) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					createAndShowGUI();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
