package codegen;

/** Shared helper for both emitters: a StringBuilder that tracks the current
 *  indentation depth so callers just say "one level deeper" / "back out"
 *  instead of managing spaces by hand. */
public class IndentingWriter {

    private final StringBuilder out = new StringBuilder();
    private int depth = 0;
    private final String unit;

    public IndentingWriter(int spacesPerLevel) {
        this.unit = " ".repeat(spacesPerLevel);
    }

    public void indent() {
        depth++;
    }

    public void dedent() {
        if (depth > 0) {
            depth--;
        }
    }

    public void line(String text) {
        out.append(unit.repeat(depth)).append(text).append('\n');
    }

    public void blank() {
        out.append('\n');
    }

    public int depth() {
        return depth;
    }

    @Override
    public String toString() {
        return out.toString();
    }
}
