

/**
 * Created by madinen on 23/07/2015.
 */
public class Capabilitity {
    public String DeviceName;
    public String AppiumVersion;
    public String PlatformName;
    public String PlatformVersion;
    public String AppPath;
    public String UDID;
    public String BundleID;
    public Capabilitity(String deviceName , String platformName, String platformVersion, String appPath,String bundleID,String udid)
    {
        DeviceName=deviceName;
        PlatformName=platformName;
        PlatformVersion=platformVersion;
        BundleID=bundleID;
        UDID=udid;
        AppiumVersion="1.0";
        AppPath=appPath;
    }
}
