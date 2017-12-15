package com.example.uploaddevice;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by Bird1 on 16/10/12.
 */
public class DeviceInfo {

    private String display = "";

    private String cpu = "";

    private String type = "";

    private String serial;

    private String baseOS;

    private int sdkVersion;

    private String bootloader;

    private String host;

    private String user;

    private float xdpi;

    private float ydpi;

    private float density;

    private int densityDpi;

    private long allMemory;
    private long availMemory;
    private long availSpaceOfSDC;
    private long availSpaceOfData;

    private String vivoCid;
    private String vivoBuildNumber;
    private String simGsmSerial;

    public String getSimGsmSerial() {
        return simGsmSerial;
    }

    public void setSimGsmSerial(String simGsmSerial) {
        this.simGsmSerial = simGsmSerial;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getBaseOS() {
        return baseOS;
    }

    public void setBaseOS(String baseOS) {
        this.baseOS = baseOS;
    }

    public int getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(int sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getBootloader() {
        return bootloader;
    }

    public void setBootloader(String bootloader) {
        this.bootloader = bootloader;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getXdpi() {
        return xdpi;
    }

    public void setXdpi(float xdpi) {
        this.xdpi = xdpi;
    }

    public float getYdpi() {
        return ydpi;
    }

    public void setYdpi(float ydpi) {
        this.ydpi = ydpi;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public int getDensityDpi() {
        return densityDpi;
    }

    public void setDensityDpi(int densityDpi) {
        this.densityDpi = densityDpi;
    }

    public long getAllMemory() {
        return allMemory;
    }

    public void setAllMemory(long allMemory) {
        this.allMemory = allMemory;
    }

    public long getAvailMemory() {
        return availMemory;
    }

    public void setAvailMemory(long availMemory) {
        this.availMemory = availMemory;
    }

    public long getAvailSpaceOfSDC() {
        return availSpaceOfSDC;
    }

    public void setAvailSpaceOfSDC(long availSpaceOfSDC) {
        this.availSpaceOfSDC = availSpaceOfSDC;
    }

    public long getAvailSpaceOfData() {
        return availSpaceOfData;
    }

    public void setAvailSpaceOfData(long availSpaceOfData) {
        this.availSpaceOfData = availSpaceOfData;
    }

    public String getVivoCid() {
        return vivoCid;
    }

    public void setVivoCid(String vivoCid) {
        this.vivoCid = vivoCid;
    }

    public String getVivoBuildNumber() {
        return vivoBuildNumber;
    }

    public void setVivoBuildNumber(String vivoBuildNumber) {
        this.vivoBuildNumber = vivoBuildNumber;
    }

    private String imei = "";


    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        if (StringUtils.isNotEmpty(imei)) {
            this.imei = imei;
        }
    }

    private String romName = "";

    public String getRomName() {
        return romName;
    }

    public void setRomName(String romName) {
        this.romName = romName;
    }


    private String androidId = "";

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        if (StringUtils.isNotEmpty(androidId)) {
            this.androidId = androidId;
        }
    }

    private String wifiMac = "";

    public String getWifiMac() {
        return wifiMac;
    }

    public void setWifiMac(String wifiMac) {
        if (StringUtils.isNotEmpty(wifiMac)) {
            this.wifiMac = wifiMac;
        } else {
            this.wifiMac = "00:00:00:00:00:00";
        }
    }

    private String wifiSsid = "";

    public String getWifiSsid() {
        return wifiSsid;
    }

    public void setWifiSsid(String wifiSsid) {
        if (StringUtils.isNotEmpty(wifiSsid)) {
            this.wifiSsid = wifiSsid;
        }
    }

    private String wifiBSsid = "";

    public String getWifiBSsid() {
        return wifiBSsid;
    }

    public void setWifiBSsid(String wifiBSsid) {
        if (StringUtils.isNotEmpty(wifiBSsid)) {
            this.wifiBSsid = wifiBSsid;
        }
    }

    private String phoneNum = "";

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        if (StringUtils.isNotEmpty(phoneNum)) {
            this.phoneNum = phoneNum;
        }
    }

    private String iccid = "";

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        if (StringUtils.isNotEmpty(iccid)) {
            this.iccid = iccid;
        }
    }

    private String imsi = "";

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        if (StringUtils.isNotEmpty(imsi)) {
            this.imsi = imsi;
        }
    }

    private String simStatus = "";

    public String getSimStatus() {
        return simStatus;
    }

    public void setSimStatus(String simStatus) {
        if (StringUtils.isNotEmpty(simStatus)) {
            this.simStatus = simStatus;
        }
    }

    private String simOperatorId = "";

    public String getSimOperatorId() {
        return simOperatorId;
    }

    public void setSimOperatorId(String simOperatorId) {
        if (StringUtils.isNotEmpty(simOperatorId)) {
            this.simOperatorId = simOperatorId;
        }
    }

    private String simOperatorName = "";

    public String getSimOperatorName() {
        return simOperatorName;
    }

    public void setSimOperatorName(String simOperatorName) {
        if (StringUtils.isNotEmpty(simOperatorName)) {
            this.simOperatorName = simOperatorName;
        }
    }

    private String simCountryIso = "";

    public String getSimCountryIso() {
        return simCountryIso;
    }

    public void setSimCountryIso(String simCountryIso) {
        if (StringUtils.isNotEmpty(simCountryIso)) {
            this.simCountryIso = simCountryIso;
        }
    }

    private String model = "";

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (StringUtils.isNotEmpty(model)) {
            this.model = model;
        }
    }

    private String manufacturer = "";

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (StringUtils.isNotEmpty(manufacturer)) {
            this.manufacturer = manufacturer;
        }
    }

    private String hardware = "";

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        if (StringUtils.isNotEmpty(hardware)) {
            this.hardware = hardware;
        }
    }

    private String brand = "";

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (StringUtils.isNotEmpty(brand)) {
            this.brand = brand;
        }
    }

    private String radio = "";

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        if (StringUtils.isNotEmpty(radio)) {
            this.radio = radio;
        }
    }

    private String device = "";

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        if (StringUtils.isNotEmpty(device)) {
            this.device = device;
        }
    }

    private String product = "";

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        if (StringUtils.isNotEmpty(product)) {
            this.product = product;
        }
    }

    private String board = "";

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        if (StringUtils.isNotEmpty(brand)) {
            this.board = board;
        }
    }

    private String incremental = "";

    public String getIncremental() {
        return incremental;
    }

    public void setIncremental(String incremental) {
        if (StringUtils.isNotEmpty(incremental)) {
            this.incremental = incremental;
        }
    }

    private String channel = "";

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        if (StringUtils.isNotEmpty(channel)) {
            this.channel = channel;
        }
    }

    private String releaseVersion = "";

    public String getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(String releaseVersion) {
        if (StringUtils.isNotEmpty(releaseVersion)) {
            this.releaseVersion = releaseVersion;
        }
    }

    private String screenWidth = "";

    public String getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(String screenWidth) {
        if (StringUtils.isNotEmpty(screenWidth)) {
            this.screenWidth = screenWidth;
        }
    }

    private String screenHeight = "";

    public String getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(String screenHeight) {
        if (StringUtils.isNotEmpty(screenHeight)) {
            this.screenHeight = screenHeight;
        }
    }

    private String appVersion = "";

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        if (StringUtils.isNotEmpty(appVersion)) {
            this.appVersion = appVersion;
        }
    }

    private String createTime = "";

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        if (StringUtils.isNotEmpty(createTime)) {
            this.createTime = createTime;
        }
    }

    private String fromApp = "";

    public String getFromApp() {
        return fromApp;
    }

    public void setFromApp(String fromApp) {
        if (StringUtils.isNotEmpty(fromApp)) {
            this.fromApp = fromApp;
        }
    }

    private String cpuAbi = "";

    public String getCpuAbi() {
        return cpuAbi;
    }

    public void setCpuAbi(String cpuAbi) {
        if (StringUtils.isNotEmpty(cpuAbi)) {
            this.cpuAbi = cpuAbi;
        }
    }

    private String cpuAbi2 = "";

    public String getCpuAbi2() {
        return cpuAbi2;
    }

    public void setCpuAbi2(String cpuAbi2) {
        if (StringUtils.isNotEmpty(cpuAbi2)) {
            this.cpuAbi2 = cpuAbi2;
        }
    }

    private String fingerprint = "";

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        if (StringUtils.isNotEmpty(fingerprint)) {
            this.fingerprint = fingerprint;
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("imei:");
        stringBuffer.append(getImei());
        stringBuffer.append("\n");

        stringBuffer.append("android id:");
        stringBuffer.append(getAndroidId());
        stringBuffer.append("\n");

        stringBuffer.append("wifi mac:");
        stringBuffer.append(getWifiMac());
        stringBuffer.append("\n");

        stringBuffer.append("wifi ssid:");
        stringBuffer.append(getWifiSsid());
        stringBuffer.append("\n");

        stringBuffer.append("wifi b-ssid:");
        stringBuffer.append(getWifiBSsid());
        stringBuffer.append("\n");

        stringBuffer.append("phone num:");
        stringBuffer.append(getPhoneNum());
        stringBuffer.append("\n");

        stringBuffer.append("iccid:");
        stringBuffer.append(getIccid());
        stringBuffer.append("\n");

        stringBuffer.append("imsi:");
        stringBuffer.append(getImsi());
        stringBuffer.append("\n");

        stringBuffer.append("sim status:");
        stringBuffer.append(getSimStatus());
        stringBuffer.append("\n");

        stringBuffer.append("sim operator id:");
        stringBuffer.append(getSimOperatorId());
        stringBuffer.append("\n");

        stringBuffer.append("sim operator name:");
        stringBuffer.append(getSimOperatorName());
        stringBuffer.append("\n");

        stringBuffer.append("sim country iso:");
        stringBuffer.append(getSimCountryIso());
        stringBuffer.append("\n");

        stringBuffer.append("model:");
        stringBuffer.append(getModel());
        stringBuffer.append("\n");

        stringBuffer.append("manufacturer:");
        stringBuffer.append(getManufacturer());
        stringBuffer.append("\n");

        stringBuffer.append("hardware:");
        stringBuffer.append(getHardware());
        stringBuffer.append("\n");

        stringBuffer.append("brand:");
        stringBuffer.append(getBrand());
        stringBuffer.append("\n");

        stringBuffer.append("radio:");
        stringBuffer.append(getRadio());
        stringBuffer.append("\n");

        stringBuffer.append("device:");
        stringBuffer.append(getDevice());
        stringBuffer.append("\n");

        stringBuffer.append("product:");
        stringBuffer.append(getProduct());
        stringBuffer.append("\n");

        stringBuffer.append("board:");
        stringBuffer.append(getBoard());
        stringBuffer.append("\n");

        stringBuffer.append("incremental:");
        stringBuffer.append(getIncremental());
        stringBuffer.append("\n");

        stringBuffer.append("channel:");
        stringBuffer.append(getChannel());
        stringBuffer.append("\n");

        stringBuffer.append("releaseVersion:");
        stringBuffer.append(getReleaseVersion());
        stringBuffer.append("\n");

        stringBuffer.append("screenWidth:");
        stringBuffer.append(getScreenWidth());
        stringBuffer.append("\n");

        stringBuffer.append("screenHeight:");
        stringBuffer.append(getScreenHeight());
        stringBuffer.append("\n");

        stringBuffer.append("appVersion:");
        stringBuffer.append(getAppVersion());
        stringBuffer.append("\n");

        stringBuffer.append("createTime:");
        stringBuffer.append(getCreateTime());
        stringBuffer.append("\n");

        stringBuffer.append("fromApp:");
        stringBuffer.append(getFromApp());
        stringBuffer.append("\n");

        stringBuffer.append("cpuAbi:");
        stringBuffer.append(getCpuAbi());
        stringBuffer.append("\n");

        stringBuffer.append("cpuAbi2:");
        stringBuffer.append(getCpuAbi2());
        stringBuffer.append("\n");

        stringBuffer.append("fingerprint:");
        stringBuffer.append(getFingerprint());
        stringBuffer.append("\n");

        return stringBuffer.toString();
    }

    public Map<String, String> getMapRequestParam() {
        Map<String, String> requestParam = new HashMap<>();

        requestParam.put("imei", getImei());
        requestParam.put("androidId", getAndroidId());
        requestParam.put("wifiMac", getWifiMac());
        requestParam.put("wifiSsid", getWifiSsid());
        requestParam.put("wifiBSsid", getWifiBSsid());
        requestParam.put("phoneNum", getPhoneNum());
        requestParam.put("iccid", getIccid());
        requestParam.put("imsi", getImsi());
        requestParam.put("simStatus", getSimStatus());
        requestParam.put("simOperatorId", getSimOperatorId());
        requestParam.put("simOperatorName", getSimOperatorName());
        requestParam.put("simCountryIso", getSimCountryIso());
        requestParam.put("model", getModel());
        requestParam.put("manufacturer", getManufacturer());
        requestParam.put("hardware", getHardware());
        requestParam.put("brand", getBrand());
        requestParam.put("radio", getRadio());
        requestParam.put("device", getDevice());
        requestParam.put("product", getProduct());
        requestParam.put("board", getBoard());
        requestParam.put("incremental", getIncremental());
        requestParam.put("channel", getChannel());
        requestParam.put("releaseVersion", getReleaseVersion());
        requestParam.put("screenWidth", getScreenWidth());
        requestParam.put("screenHeight", getScreenHeight());
        requestParam.put("appVersion", getAppVersion());
        requestParam.put("createTime", getCreateTime());
        requestParam.put("fromApp", getFromApp());
        requestParam.put("cpuAbi", getCpuAbi());
        requestParam.put("cpuAbi2", getCpuAbi2());
        requestParam.put("fingerprint", getFingerprint());
        requestParam.put("romName", getRomName());
        requestParam.put("display", getDisplay());
        requestParam.put("cpu", getCpu());
        requestParam.put("type", getType());
        requestParam.put("serial", getSerial());
        requestParam.put("baseOS", getBaseOS());
        requestParam.put("sdkVersion", getSdkVersion() + "");
        requestParam.put("bootloader", getBootloader());
        requestParam.put("host", getHost());
        requestParam.put("user", getUser());
        requestParam.put("xdpi", getXdpi() + "");
        requestParam.put("ydpi", getYdpi() + "");
        requestParam.put("density", getDensity() + "");
        requestParam.put("densityDpi", getDensityDpi() + "");
        requestParam.put("allMemory", getAllMemory() + "");
        requestParam.put("availMemory", getAvailMemory() + "");
        requestParam.put("availSpaceOfSDC", getAvailSpaceOfSDC() + "");
        requestParam.put("availSpaceOfData", getAvailSpaceOfData() + "");
        requestParam.put("vivoCid", getVivoCid());
        requestParam.put("vivoBuildNumber", getVivoBuildNumber());

        return requestParam;
    }
}
