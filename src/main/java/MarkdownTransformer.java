import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownTransformer {
    public String execute(String input) {
        String firstMatch = findMatch(input);
        if (!firstMatch.isEmpty()) {
            return firstMatch;
        }
        return input;
    }

    private String findMatch(String input) {
        Pattern pattern = Pattern.compile("\\[.*]\\(.*\\)");
        Matcher matcher = pattern.matcher(input);
        boolean thereAreLinks = matcher.find();
        if (thereAreLinks) {
            return matcher.group();
        }
        return "";
    }
}
