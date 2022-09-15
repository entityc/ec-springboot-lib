package ${domain.namespace};

public class MarkdownBuilder {

    private StringBuilder stringBuilder = new StringBuilder(100);

    public MarkdownBuilder() {
    }

    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public void appendHeading(int level, String headingText) {
        if (!isEmpty(headingText)) {
            stringBuilder.append(MarkdownUtils.headingNotation(level));
            stringBuilder.append(headingText);
            stringBuilder.append("\n\n");
        }
    }

    public void appendHeading(int level, String prefix, Integer number, String separator, String title) {
        stringBuilder.append(MarkdownUtils.headingNotation(level));
        boolean hasPrefix = !isEmpty(prefix);
        boolean hasNumber = number != null;
        boolean hasSeparator = !isEmpty(separator);
        boolean hasTitle = !isEmpty(title);
        if (hasPrefix) {
            stringBuilder.append(prefix);
        }
        if (hasNumber) {
            if (hasPrefix) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(number);
        }
        if (hasSeparator && (hasPrefix || hasNumber) && hasTitle) {
            stringBuilder.append(separator);
            stringBuilder.append(" ");
        }
        if (hasTitle) {
            stringBuilder.append(title);
        }
        stringBuilder.append("\n\n");
    }

    public void appendPara(String para) {
        if (!isEmpty(para)) {
            stringBuilder.append(para);
            stringBuilder.append("\n\n");
        }
    }

    public void append(String text) {
        if (!isEmpty(text)) {
            stringBuilder.append(text);
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
