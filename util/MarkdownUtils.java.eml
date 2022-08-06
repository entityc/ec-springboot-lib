package ${domain.namespace};

public class MarkdownUtils {

    private static final String[] headingNotations = {"# ", "## ", "### ", "#### ", "##### ", "###### "};

    public static final String headingNotation(int level) {
        if (level < 1) {
            level = 1;
        } else if (level > headingNotations.length) {
            level = headingNotations.length;
        }
        return headingNotations[level - 1];
    }

    public static final int largestSupportedSectionLevel() {
        return headingNotations.length;
    }
}
