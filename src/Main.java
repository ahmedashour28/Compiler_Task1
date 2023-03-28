import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = "Example.java";
        FileInputStream inputStream = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        TokenStreamRewriter rewriter = new TokenStreamRewriter(tokens);
        walker.walk(new blockListener(rewriter), tree);

        File output = new File("src/Example.java");
        output.createNewFile();
        FileWriter w = new FileWriter("src/Example.java");
        w.write(rewriter.getText());
        w.close();
        //System.out.println(rewriter.getText());

    }
}
