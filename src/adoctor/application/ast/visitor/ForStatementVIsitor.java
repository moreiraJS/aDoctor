package adoctor.application.ast.visitor;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.SimpleName;

import java.util.ArrayList;

public class ForStatementVIsitor extends ASTVisitor {

    private ArrayList<ForStatement> forStatements;

    public ForStatementVIsitor(ArrayList<ForStatement> forStatements) {
        this.forStatements = forStatements;
    }

    @Override
    public boolean visit(ForStatement forStatement) {
        forStatements.add(forStatement);
        return true;
    }
}
