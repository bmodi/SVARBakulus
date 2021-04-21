package ca.svarb.svarbakulus;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class FileSystemTest {

	@Test
	public void testConstructor() throws Exception {
		String pathString = "e:/work/test-tree";
		Path path = Paths.get(pathString);
		new FileSystem(path);
	}

}
