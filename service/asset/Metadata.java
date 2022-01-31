package ${domain.namespace}.asset;

public class Metadata {
    private long contentLength;
    private String contentType;
    private String contentDisposition;

    public Metadata() {};

    public Metadata(final long contentLength) {
        this.contentLength = contentLength;
    }

    public Metadata(final long contentLength, final String contentType) {
        this(contentLength);
        this.contentType = contentType;
    }

    public Metadata(final long contentLength, final String contentType, final String contentDisposition) {
        this(contentLength, contentType);
        this.contentDisposition = contentDisposition;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentDisposition() {
        return contentDisposition;
    }

    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }
}
