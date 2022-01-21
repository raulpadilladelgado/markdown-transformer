import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarkdownTransformerShould {
    /*
    *
    *
    * Happy path todo en una linea: ver doc

Input:
[this book](https://codigosostenible.com) and some other text.
Output:
this book [^anchor1] and some other text.

[^anchor1]: https://codigosostenible.com

Happy path con varios enlaces:

Input:
[this book](https://codigosostenible.com) and some other text [and another link](http://url.com)
Output:
this book [^anchor1] and some other text and some other text and another link [^anchor2]

[^anchor1]: https://codigosostenible.com
[^anchor2]: https://url.com

Casos limite:

Enlaces duplicados:

Input:

[this book](https://codigosostenible.com) and some other text [and another link](https://codigosostenible.com)

Output:

this book [^anchor1] and some other text and some other text and another link [^anchor1]

[^anchor1]: https://codigosostenible.com
    *
    * */
    @Test
    void does_not_modify_a_text_without_links() {
        String input = "Some text without links";
        MarkdownTransformer markdownTransformer = new MarkdownTransformer();

        String result = markdownTransformer.execute(input);

        assertThat(result).isEqualTo(input);
    }

    @Test
    void find_a_pattern_in_a_text() {
        String input = "[this book](https://codigosostenible.com) and some other text";
        MarkdownTransformer markdownTransformer = new MarkdownTransformer();

        String result = markdownTransformer.execute(input);

        String expectedResult = "[this book](https://codigosostenible.com)";
        assertThat(result).isEqualTo(expectedResult);

    }

//        @Test
//    void does_modify_a_text_with_one_link() {
//        String input = "[this book](https://codigosostenible.com) and some other text";
//        MarkdownTransformer markdownTransformer = new MarkdownTransformer();
//
//        String result = markdownTransformer.execute(input);
//
//        String expectedResult = "this book [^anchor1] and some other text\n"+
//            "[^anchor1]: https://codigosostenible.com";
//        assertThat(result).isEqualTo(expectedResult);
//    }
}
