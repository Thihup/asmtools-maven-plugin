module dev.thihup.asmtools.toolprovider {
    requires asmtools.core;

    provides java.util.spi.ToolProvider with
        dev.thihup.asmtools.toolprovider.JasmToolProvider,
        dev.thihup.asmtools.toolprovider.JcdecToolProvider,
        dev.thihup.asmtools.toolprovider.JcoderToolProvider,
        dev.thihup.asmtools.toolprovider.JdecToolProvider,
        dev.thihup.asmtools.toolprovider.JdisToolProvider;
}