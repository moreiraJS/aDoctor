package adoctor.application.ast.visitor;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ForStatement;

import java.util.ArrayList;

public class EnhancedForStatementVisitor  extends ASTVisitor {

    private ArrayList<EnhancedForStatement> enhancedForStatements;

    public EnhancedForStatementVisitor(ArrayList<EnhancedForStatement> enhancedForStatements) {
        this.enhancedForStatements = enhancedForStatements;
    }

    @Override
    public boolean visit(EnhancedForStatement enhancedForStatement) {
        enhancedForStatements.add(enhancedForStatement);
        return true;
    }
}