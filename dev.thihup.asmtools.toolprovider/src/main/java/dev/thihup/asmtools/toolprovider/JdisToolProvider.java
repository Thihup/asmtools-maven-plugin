package dev.thihup.asmtools.toolprovider;

import java.io.PrintWriter;
import java.util.spi.ToolProvider;
import org.openjdk.asmtools.jdis.Main;

public class JdisToolProvider implements ToolProvider {

    @Override
    public String name() {
        return "jdis";
    }

    @Override
    public int run(PrintWriter out, PrintWriter err, String... args) {
        Main main = new Main(out, err, name());
        return main.disasm(args) ? 0 : 1;
    }

}
