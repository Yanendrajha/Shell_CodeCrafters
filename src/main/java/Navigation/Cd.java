package Navigation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cd {
    private Path cwd;

    public Cd() {
        this.cwd = Path.of("").toAbsolutePath();
    }

    public String getCwd(){
        return cwd.toString();
    }

    public void setCd(String argument){
        Path newDir = resolvePath(argument); // Resolve the new path.
        if (!Files.isDirectory(newDir)) { // Check if the directory exists.
            System.out.println("cd: " + argument + ": No such file or directory");
        } else {
            cwd = newDir.normalize(); // Update the current working directory to the resolved path.
        }
    }

    private Path resolvePath(String dir) {

        // checking if it is for home directory
        if (dir.equals("~"))
             return Paths.get(System.getenv("HOME"));

        Path targetPath = cwd.resolve(dir); // Resolves the path relative to the current working directory.

        if (dir.startsWith("/")) {
            targetPath = Path.of(dir); // If the path is absolute, use it directly.
        }
        return targetPath.normalize(); // Normalize the path (handles "..", ".", etc.).
    }
}
