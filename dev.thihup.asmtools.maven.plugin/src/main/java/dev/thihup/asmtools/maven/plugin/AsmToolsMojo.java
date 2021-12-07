package dev.thihup.asmtools.maven.plugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "asm-tools", defaultPhase = LifecyclePhase.COMPILE)
public class AsmToolsMojo extends AbstractMojo {

    @Parameter(property = "project.build.outputDirectory", required = true, readonly = true)
    private File outputDirectory;

    @Parameter(property = "project.build.sourceDirectory", required = true, readonly = true)
    private File sourceDirectory;

    @Parameter(property = "asmtools.skip", required = false)
    private boolean skip;

    @Parameter(required = true)
    private String name;

    @Parameter
    private String[] args;

    public void execute() throws MojoExecutionException {
        try {
            Files.walkFileTree(sourceDirectory.toPath(), new AsmToolsFileVisitor(outputDirectory.toPath()));
        } catch (IOException e) {
            throw new MojoExecutionException("Failed to walk source directory", e);
        }
    }
}
