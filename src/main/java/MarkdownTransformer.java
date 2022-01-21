import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownTransformer {
    public String execute(String input) {
        Pattern pattern = Pattern.compile("\\[.*]\\(.*\\)");
        Matcher matcher = pattern.matcher(input);
        boolean thereAreLinks = matcher.find();
        if (thereAreLinks){
            return matcher.group();
        }
        return input;
    }
}
