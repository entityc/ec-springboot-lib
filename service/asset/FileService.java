package ${domain.namespace}.asset;

import ${exceptionNamespace}.ServiceException;
import lombok.extern.java.Log;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Log
@Service
@ConditionalOnProperty(name = "org.entitycompiler.tutorial.binaryPersistence", havingValue = "file")
public class FileService implements BinaryPersistence {

    private final String tmpDir = System.getProperty("java.io.tmpdir");

    @Override
    public void delete(String path, String filename) {
        Path completePath = path == null ? Paths.get(tmpDir, filename) : Paths.get(tmpDir + path, filename);
        completePath.toFile().delete();
    }

    @Override
    public void save(String path, String filename, InputStream inputStream, Metadata metadata) throws ServiceException {
        Path completePath = path == null ? Paths.get(tmpDir, filename) : Paths.get(tmpDir + path, filename);

        if (completePath.getParent().toFile().exists()) {
            if (!completePath.getParent().toFile().isDirectory()) {
                throw new IllegalArgumentException(String.format(
                        "Folder [%s] cannot be created because a file with this name already exists",
                        completePath.getParent()));
            }
        } else {
            try {
                Files.createDirectories(completePath.getParent());
            } catch (IOException ioException) {
                throw new IllegalArgumentException(String.format("IO Exception creating directory %s: %s", completePath,
                        ioException.getMessage()));
            }
        }
        if (completePath.toFile().exists()) {
            delete(path, filename);
        }
        completePath.toFile().deleteOnExit();
        try (FileOutputStream fileOutputStream = new FileOutputStream(completePath.toFile())) {
            IOUtils.copy(inputStream, fileOutputStream);
        } catch (FileNotFoundException fnfException) {
            throw new ServiceException(String.format("Exception writing to file %s: %s", completePath, fnfException.getMessage()));
        } catch (IOException ioException) {
            throw new ServiceException(String.format("IO Exception opening file %s: %s", completePath, ioException.getMessage()));
        }
    }
    @Override
    public String getUrl(String path, String filename) {
        Path completePath = path == null ? Paths.get(filename) : Paths.get(path, filename);
        return completePath.toString();
    }
}
