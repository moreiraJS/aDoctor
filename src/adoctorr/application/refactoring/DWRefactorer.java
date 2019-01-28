package adoctorr.application.refactoring;

import adoctorr.application.ast.ASTUtilities;
import adoctorr.application.bean.proposal.DWProposal;
import adoctorr.application.bean.proposal.MethodProposal;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.text.edits.UndoEdit;

import java.io.IOException;

public class DWRefactorer extends MethodSmellRefactorer {

    public DWRefactorer() {

    }

    @Override
    public boolean applyRefactoring(MethodProposal methodProposal) throws BadLocationException, IOException {
        if (!(methodProposal instanceof DWProposal)) {
            return false;
        }
        DWProposal dwProposal = (DWProposal) methodProposal;
        MethodDeclaration proposedMethod = dwProposal.getProposedMethodDeclaration();

        CompilationUnit compilationUnit = getCompilationUnit(methodProposal);
        // MethodDeclaration to be replaced
        MethodDeclaration targetMethod = ASTUtilities.getMethodDeclarationFromContent(methodProposal.getMethodSmell().getMethodBean().getTextContent(), compilationUnit);
        if (targetMethod == null) {
            return false;
        }

        // Accumulate the replacements
        ASTRewrite astRewrite = ASTRewrite.create(compilationUnit.getAST());
        astRewrite.replace(targetMethod, proposedMethod, null);

        UndoEdit undoEdit = rewriteFile(methodProposal, astRewrite);
        //TODO Eliminare
        if (undoEdit != null) {
            return true;
        } else {
            return false;
        }
    }
}