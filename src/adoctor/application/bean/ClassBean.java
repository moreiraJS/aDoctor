package adoctor.application.bean;

import org.eclipse.jdt.core.dom.TypeDeclaration;

import java.io.File;
import java.util.HashMap;

public class ClassBean extends Bean {
    private File sourceFile;
    private TypeDeclaration typeDeclaration;
    private String qualifiedName;
    private HashMap<String, ClassBean> descendents;

    public String getQualifiedName() {
        return qualifiedName;
    }

    public void setQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    public HashMap<String, ClassBean> getDescendents() {
        return descendents;
    }

    public void addDescendent(ClassBean descendent) {
        String qualifiedName = descendent.getQualifiedName();
        this.descendents.put(qualifiedName, descendent);
    }

    public File getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public TypeDeclaration getTypeDeclaration() {
        return typeDeclaration;
    }

    public void setTypeDeclaration(TypeDeclaration typeDeclaration) {
        this.typeDeclaration = typeDeclaration;
    }

}
