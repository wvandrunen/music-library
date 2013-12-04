import org.junit.Test;
import org.musiclibfixer.DirectoryWalker;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DirectoryWalkerTest {

    @Test
    public void shouldReturnOneDirectoryWhenGivenDirectoryWithTwoDirectoriesAndOneWithMP3File() throws IOException {
        DirectoryWalker directoryWalker = new DirectoryWalker();

        Files.walkFileTree(FileSystems.getDefault().getPath("C:\\project\\music-library-fixer\\src\\test\\resources"), directoryWalker);

        List<Path> directories = directoryWalker.getDirectories();

        assertEquals(1, directories.size());
    }

}
