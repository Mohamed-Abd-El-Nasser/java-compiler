import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class MyListenerClass extends JavaParserBaseListener {
    TokenStreamRewriter rewriter;
    int blocksCount = 1;

    public MyListenerClass(TokenStream tokens) {
        rewriter = new TokenStreamRewriter(tokens);
    }

    @Override
    public void enterIfStatement(JavaParser.IfStatementContext ctx){
        int lineNumber = ctx.start.getLine();
        String injectedMessage = String.format("\"%d\\n\"", blocksCount);
        if(ctx.getChild(2).getText().charAt(0) =='{') {
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
            rewriter.insertAfter(ctx.ifBody.getStart(), injectedCode);
        }else{
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
            rewriter.insertAfter(ctx.ifExp.getStop(), '{');
            rewriter.insertBefore(ctx.ifBody.getStart(), injectedCode);
        }
        blocksCount++;
        super.enterIfStatement(ctx);
    }

    @Override
    public void exitIfStatement(JavaParser.IfStatementContext ctx) {
        if(ctx.getChild(2).getText().charAt(0) !='{') {
            rewriter.insertAfter(ctx.ifBody.getStop(), "\n\t\t}");
        }
        super.exitIfStatement(ctx);
    }

    @Override
    public void enterElseStatement(JavaParser.ElseStatementContext ctx) {
        int lineNumber = ctx.start.getLine();
        String injectedMessage = String.format("\"%d\\n\"", blocksCount);

        if(ctx.getChildCount()>0){
            int count = ctx.getChildCount();
            if(!ctx.elseBody.getStart().getText().equals("if")){
                if(ctx.getChild(1).getText().charAt(0) =='{') {
                    String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
                    rewriter.insertAfter(ctx.elseBody.getStart(), injectedCode);
                }
                else{
                    String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
                    rewriter.insertAfter(ctx.ELSE().getSymbol(), '{');
                    rewriter.insertBefore(ctx.elseBody.getStart(), injectedCode);
                }
            }
            blocksCount++;
        }
        super.enterElseStatement(ctx);
    }

    @Override
    public void exitElseStatement(JavaParser.ElseStatementContext ctx) {
        if (!ctx.elseBody.getStart().getText().equals("if")) {
            if (ctx.getChild(1).getText().charAt(0) !='{') {
                rewriter.insertAfter(ctx.elseBody.getStop(), "\n\t\t}");
            }
            super.exitElseStatement(ctx);
        }
    }

    @Override
    public void enterForStatement(JavaParser.ForStatementContext ctx) {
        int lineNumber = ctx.start.getLine();
        String injectedMessage = String.format("\"%d\\n\"", blocksCount);
        if(ctx.getChild(4).getText().charAt(0) =='{') {
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
            rewriter.insertAfter(ctx.forBody.getStart(), injectedCode);
            rewriter.insertBefore(ctx.forBody.getStop(),"\n\t\tbreak;");
        }
        else{
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";

            rewriter.insertAfter(ctx.endBracket, '{');
            rewriter.insertBefore(ctx.forBody.getStart(), injectedCode);
        }
        blocksCount++;
 //       System.out.println(ctx.getChild(1));

        super.enterForStatement(ctx);
    }

    @Override
    public void exitForStatement(JavaParser.ForStatementContext ctx) {

        if(ctx.getChild(4).getText().charAt(0) !='{') {
            rewriter.insertAfter(ctx.forBody.getStop(), "\n\t\tbreak;");
            rewriter.insertAfter(ctx.forBody.getStop(), "\n\t\t}");
        }

        super.exitForStatement(ctx);
    }

    @Override
    public void enterWhileStatement(JavaParser.WhileStatementContext ctx) {

        int lineNumber = ctx.start.getLine();
        String injectedMessage = String.format("\"%d\\n\"", blocksCount);

        if(ctx.getChild(2).getText().charAt(0) =='{') {
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
            rewriter.insertBefore(ctx.whileBody.getStop(),"\n\t\tbreak;");
            rewriter.insertAfter(ctx.whileBody.getStart(), injectedCode);

        }else{
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
            rewriter.insertAfter(ctx.whileExp.getStop(), '{');
            rewriter.insertBefore(ctx.whileBody.getStart(), injectedCode);
        }
        blocksCount++;

        super.enterWhileStatement(ctx);
    }

    @Override
    public void exitWhileStatement(JavaParser.WhileStatementContext ctx) {
        if(ctx.getChild(2).getText().charAt(0) !='{') {
            rewriter.insertAfter(ctx.whileBody.getStop(), "\n\t\tbreak;");
            rewriter.insertAfter(ctx.whileBody.getStop(), "\n\t\t}");
        }
        super.exitWhileStatement(ctx);
    }
    @Override
    public void enterSwitchLabel(JavaParser.SwitchLabelContext ctx) {
        int lineNumber = ctx.start.getLine();

        String injectedMessage = String.format("\"%d\\n\"", blocksCount);
        blocksCount++;
        String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
        rewriter.insertAfter(ctx.COLON().getSymbol(), injectedCode);
        super.enterSwitchLabel(ctx);
    }
}
