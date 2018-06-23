package gocho.java;


public final class Version {

    private static final String VERSION = "${project.version}";
    private static final String GROUPID = "${project.groupId}";
    private static final String ARTIFACTID = "${project.artifactId}";
    private static final String REVISION = "${buildNumber}";

    public static String getVersion() {
        return VERSION;
    }

    public static String getArtifactId() {
        return ARTIFACTID;
    }
    public static String getGroupid() {
        return GROUPID;
    }
    // other getters...
    // other getters...
}
