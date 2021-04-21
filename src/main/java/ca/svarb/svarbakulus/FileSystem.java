package ca.svarb.svarbakulus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class FileSystem {

	private Path path;

	public FileSystem(Path path) {
		this.path = path;
	}

	/**
	 *
	 * @return
	 * @throws IOException
	 * @apiNote This method must be used within a try-with-resources statement or
	 *          similar control structure to ensure that the stream's open
	 *          directories are closed promptly after the stream's operations have
	 *          completed.
	 */
	public Stream<Path> getModifiedFiles() throws IOException {
		BiPredicate<Path, BasicFileAttributes> predicate = (bpPath, bpAttrs) -> {
			return bpAttrs.isRegularFile();
		};
		int maxDepth = Integer.MAX_VALUE;
		return Files.find(path, maxDepth, predicate);
	}
}
