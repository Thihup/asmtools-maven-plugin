package dev.thihup.asmtools.toolprovider;

import java.io.PrintWriter;
import java.util.spi.ToolProvider;
import org.openjdk.asmtools.jdec.Main;

public class JdecToolProvider implements ToolProvider {

    @Override
    public String name() {
        return "jdec";
    }

    @Override
    public int run(PrintWriter out, PrintWriter err, String... args) {
        Main main = new Main(out, err, name());
        return main.decode(args) ? 0 : 1;
    }

}
