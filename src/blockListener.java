import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.TerminalNode;

public class blockListener extends JavaParserBaseListener{
    int i;
    TokenStreamRewriter rewriter;
    public blockListener(TokenStreamRewriter rewriter){
        this.rewriter = rewriter;
        this.i=0;
    }
    @Override public void enterBlock(JavaParser.BlockContext ctx) {
        this.i++;
        rewriter.insertAfter(ctx.getStart(),"//block number " + this.i);

    }
    @Override public void exitBlock(JavaParser.BlockContext ctx) {

    }
    @Override public void visitTerminal(TerminalNode node) {
        //System.out.println(node.getText());

    }
}
