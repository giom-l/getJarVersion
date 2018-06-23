package myself.java;

import com.jcabi.manifests.Manifests;

import java.io.IOException;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.Manifest;


public class GetJarVersion {
    public static void main (String[] args) throws IOException{

        String param = args[0];

        if ("--version".equals(param)) {
            System.out.println("GroupId : " + Version.getGroupId());
            System.out.println("Component : " + Version.getArtifactId());
            System.out.println("Version : " + Version.getVersion());
        }

        if ("--version2".equals(param)) {
            String component = Manifests.read("Component-name");
            String version = Manifests.read("Component-version");
            System.out.println("Component name : "+component);
            System.out.println("Component version : "+version);
        }

        if ("--version3".equals(param)) {
            System.out.println("GroupId : " + Version3.getGroupId());
            System.out.println("Component : " + Version3.getArtifactId());
            System.out.println("Version : " + Version3.getVersion());
/*        Class clazz = GetJarVersion.class;
        String className = clazz.getSimpleName() + ".class";
        String classPath = clazz.getResource(className).toString();
        if (!classPath.startsWith("jar")) {
            // Class not from JAR
            return;
        }
        String manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) + "/META-INF/MANIFEST.MF";
        Manifest manifest = new Manifest(new URL(manifestPath).openStream());
        Attributes attr = manifest.getMainAttributes();
        String groupId = attr.getValue("Component-groupId");
        String component = attr.getValue("Component-name");
        String version = attr.getValue("Component-version");
        System.out.println("GroupId : "+groupId);
        System.out.println("Component : "+component);
        System.out.println("Version : "+version);*/
        }

    }
}
