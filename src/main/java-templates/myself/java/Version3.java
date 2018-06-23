package myself.java;


import java.io.IOException;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public final class Version3{


    private static String getValuebyKey(String attrKey) throws IOException{
        Class clazz = GetJarVersion.class;
        String className = clazz.getSimpleName() + ".class";
        String classPath = clazz.getResource(className).toString();
        if (!classPath.startsWith("jar")) {
            // Class not from JAR
            throw new IOException("Error while loading jar informations");
        }
        String manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) + "/META-INF/MANIFEST.MF";
        Manifest manifest = new Manifest(new URL(manifestPath).openStream());
        Attributes attr = manifest.getMainAttributes();
        String value = attr.getValue(attrKey);
        return value;

    }

    public static String getVersion() {
        try {
            return getValuebyKey("Component-version");
        }
        catch (IOException ioe){
            return "Error while getting Manifest.mf informations\n" + ioe.getStackTrace();
        }
    }
    public static String getGroupId() {
        try{
            return getValuebyKey("Component-groupId");
        }
        catch (IOException ioe){
            return "Error while getting Manifest.mf informations\n" + ioe.getStackTrace();
        }
    }
    public static String getArtifactId() {
        try{
            return getValuebyKey("Component-name");
        }
        catch (IOException ioe){
            return "Error while getting Manifest.mf informations\n" + ioe.getStackTrace();
        }
    }

}
