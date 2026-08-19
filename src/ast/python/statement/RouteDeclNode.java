package ast.python.statement;

import ast.python.PythonAstVisitor;

import java.util.List;

public class RouteDeclNode extends StatementNode {

    public static final class RouteInfo {
        public final String path;
        public final List<String> methods;

        public RouteInfo(String path, List<String> methods) {
            this.path = path;
            this.methods = methods;
        }
    }

    public final List<RouteInfo> decorators;
    public final FunctionDeclNode function;

    public RouteDeclNode(int line, List<RouteInfo> decorators, FunctionDeclNode function) {
        super(line);
        this.decorators = decorators;
        this.function = function;
    }

    @Override
    public void print(int indent) {
        StringBuilder paths = new StringBuilder();
        for (RouteInfo info : decorators) {
            paths.append(info.path).append(info.methods).append(' ');
        }
        System.out.println(pad(indent) + "RouteDecl(" + paths.toString().trim() + ") [line " + line + "]");
        function.print(indent + 1);
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
