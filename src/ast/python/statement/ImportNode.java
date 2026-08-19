package ast.python.statement;

import ast.python.PythonAstVisitor;

import java.util.List;

public class ImportNode extends StatementNode {

    public final boolean fromImport;
    public final String moduleName;
    public final List<String> importedNames;

    public ImportNode(int line, boolean fromImport, String moduleName, List<String> importedNames) {
        super(line);
        this.fromImport = fromImport;
        this.moduleName = moduleName;
        this.importedNames = importedNames;
    }

    @Override
    public void print(int indent) {
        String kind = fromImport ? ("from " + moduleName + " import " + importedNames) : ("import " + moduleName);
        System.out.println(pad(indent) + "Import(" + kind + ") [line " + line + "]");
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
