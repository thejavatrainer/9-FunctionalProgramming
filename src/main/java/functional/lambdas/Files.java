package functional.lambdas;

import java.io.File;
import java.io.FileFilter;
import java.util.function.Predicate;

public class Files {

    public static void main(String[] args) {
        new File(".").listFiles((File file) -> file.isHidden());

        new File(".").listFiles(File::isHidden);
        new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(final File pathname) {
                return pathname.isHidden();
            }
        });

        new File(".").listFiles(file -> file.isHidden());
        new MyFile().listFiles(file -> file.isHidden());

    }

    static class MyFile {
        File[] listFiles(Predicate<File> predicate) {
            return null;
        }
    }
}
