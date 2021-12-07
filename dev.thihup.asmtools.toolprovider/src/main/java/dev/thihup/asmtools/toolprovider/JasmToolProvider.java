package dev.thihup.asmtools.toolprovider;

import java.io.PrintWriter;
import java.util.spi.ToolProvider;
import org.openjdk.asmtools.jasm.Main;

public class JasmToolProvider implements ToolProvider {

    static class ToolMain extends Main {

        public ToolMain(PrintWriter out, PrintWriter err, String programName) {
            super(out, programName);
            this.err = err;
        }
    }

    @Override
    public String name() {
        return "jasm";
    }

    @Override
    public int run(PrintWriter out, PrintWriter err, String... args) {
        Main main = new ToolMain(out, err, name());
        return main.compile(args) ? 0 : 1;
    }

}
