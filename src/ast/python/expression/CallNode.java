package ast.python.expression;

import ast.python.PythonAstVisitor;

import java.util.List;

public class CallNode extends ExpressionNode {

    public static final class Argument {
        public final String name;
        public final ExpressionNode value;

        public Argument(String name, ExpressionNode value) {
            this.name = name;
            this.value = value;
        }

        void print(int indent) {
            String label = name == null ? "Argument:" : ("Argument(" + name + "=):");
            System.out.println("  ".repeat(indent) + label);
            value.print(indent + 1);
        }
    }

    public final ExpressionNode callee;
    public final List<Argument> args;

    public CallNode(int line, ExpressionNode callee, List<Argument> args) {
        super(line);
        this.callee = callee;
        this.args = args;
    }

    @Override
    public void print(int indent) {
        System.out.println(pad(indent) + "Call(" + args.size() + " args) [line " + line + "]");
        callee.print(indent + 1);
        for (Argument arg : args) {
            arg.print(indent + 1);
        }
    }

    @Override
    public <R> R accept(PythonAstVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
