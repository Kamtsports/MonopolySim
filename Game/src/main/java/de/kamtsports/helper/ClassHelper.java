package de.kamtsports.helper;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import de.kamtsports.game.Main;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class ClassHelper {

    @SuppressWarnings("UnstableApiUsage")
    public static List<String> getListOfClassesInPackage(String packageName){
        ClassPath classPath = null;
        try {
            classPath = ClassPath.from(Main.class.getClassLoader());
        } catch (IOException ignored) {}
        ImmutableSet<ClassPath.ClassInfo> set = Objects.requireNonNull(classPath).getTopLevelClasses(packageName);
        return set.stream().map(ClassPath.ClassInfo::getSimpleName).collect(Collectors.toList());
    }


}
