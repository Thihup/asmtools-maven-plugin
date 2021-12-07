package dev.thihup.asmtools.toolprovider;

import java.io.PrintWriter;
import java.util.spi.ToolProvider;
import org.openjdk.asmtools.jcdec.Main;

public class JcdecToolProvider implements ToolProvider {

    @Override
    public String name() {
        return "jcdec";
    }

    @Override
    public int run(PrintWriter out, PrintWriter err, String... args) {
        Main main = new Main(out, name());
        return main.decode(args) ? 0 : 1;
    }

}
