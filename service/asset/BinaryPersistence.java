package ${domain.namespace}.asset;

import ${exceptionNamespace}.ServiceException;

import java.io.InputStream;

public interface BinaryPersistence {
    void delete(String path, String filename) throws ServiceException;

    void save(String path, String filename, InputStream inputStream, Metadata metadata) throws ServiceException;
    /**
     * Returns the fully qualified path to the requested binary asset
     *
     * @param path     the path of the binary asset
     * @param filename the name of the file
     * @return the fully qualified path to the binary asset
     */
    String getUrl(String path, String filename);
}
