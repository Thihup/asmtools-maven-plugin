package dev.thihup.asmtools.maven.plugin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import org.apache.maven.plugin.logging.Log;
import org.openjdk.asmtools.jcoder.Main;


class AsmToolsFileVisitor extends SimpleFileVisitor<Path> {

    private final Path outputDirectory;

    public AsmToolsFileVisitor(Path outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String fileName = file.toString();
        System.out.println(fileName);
        if (fileName.endsWith(".jcod")) {
            boolean jcoder = new Main(new PrintWriter(System.out), "jcoder").compile(
                new String[]{file.toAbsolutePath().toString(), "-d",
                    outputDirectory.toAbsolutePath().toString()});
            if (!jcoder)
                throw new RuntimeException("Failed to compile " + fileName);
        } else if (fileName.endsWith(".jasm")) {
            boolean jasm = new org.openjdk.asmtools.jasm.Main(new PrintWriter(System.out),
                "jasm").compile(new String[]{file.toAbsolutePath().toString(), "-d",
                outputDirectory.toAbsolutePath().toString()});
            if (!jasm)
                throw new RuntimeException("Failed to compile " + fileName);
        }
        return FileVisitResult.CONTINUE;
    }
}
