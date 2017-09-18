package com.example.uploaddevice;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by Bird1 on 16/10/12.
 */
public class DeviceInfo {
    private String imei = "";

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        if (StringUtils.isNotEmpty(imei)) {
            this.imei = imei;
        }
    }

    private String roN="";
    public String getRoN(){
        return roN;
    }
    public void setRoN(String roN){
        this.roN=roN;
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

    private String incrementa = "";

    public String getIncrementa() {
        return incrementa;
    }

    public void setIncrementa(String incrementa) {
        if (StringUtils.isNotEmpty(incrementa)) {
            this.incrementa = incrementa;
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

    private String androidVersion = "";

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        if (StringUtils.isNotEmpty(androidVersion)) {
            this.androidVersion = androidVersion;
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
        stringBuffer.append(getIncrementa());
        stringBuffer.append("\n");

        stringBuffer.append("channel:");
        stringBuffer.append(getChannel());
        stringBuffer.append("\n");

        stringBuffer.append("androidVersion:");
        stringBuffer.append(getAndroidVersion());
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

        requestParam.put("DeviceInfo.imei", getImei());
        requestParam.put("DeviceInfo.androidId", getAndroidId());
        requestParam.put("DeviceInfo.wifiMac", getWifiMac());
        requestParam.put("DeviceInfo.wifiSsid", getWifiSsid());
        requestParam.put("DeviceInfo.wifiBSsid", getWifiBSsid());
        requestParam.put("DeviceInfo.phoneNum", getPhoneNum());
        requestParam.put("DeviceInfo.iccid", getIccid());
        requestParam.put("DeviceInfo.imsi", getImsi());
        requestParam.put("DeviceInfo.simStatus", getSimStatus());
        requestParam.put("DeviceInfo.simOperatorId", getSimOperatorId());
        requestParam.put("DeviceInfo.simOperatorName", getSimOperatorName());
        requestParam.put("DeviceInfo.simCountryIso", getSimCountryIso());
        requestParam.put("DeviceInfo.model", getModel());
        requestParam.put("DeviceInfo.manufacturer", getManufacturer());
        requestParam.put("DeviceInfo.hardware", getHardware());
        requestParam.put("DeviceInfo.brand", getBrand());
        requestParam.put("DeviceInfo.radio", getRadio());
        requestParam.put("DeviceInfo.device", getDevice());
        requestParam.put("DeviceInfo.product", getProduct());
        requestParam.put("DeviceInfo.board", getBoard());
        requestParam.put("DeviceInfo.incrementa", getIncrementa());
        requestParam.put("DeviceInfo.channel", getChannel());
        requestParam.put("DeviceInfo.androidVersion", getAndroidVersion());
        requestParam.put("DeviceInfo.screenWidth", getScreenWidth());
        requestParam.put("DeviceInfo.screenHeight", getScreenHeight());
        requestParam.put("DeviceInfo.appVersion", getAppVersion());
        requestParam.put("DeviceInfo.createTime", getCreateTime());
        requestParam.put("DeviceInfo.fromApp", getFromApp());
        requestParam.put("DeviceInfo.cpuAbi", getCpuAbi());
        requestParam.put("DeviceInfo.cpuAbi2", getCpuAbi2());
        requestParam.put("DeviceInfo.fingerprint", getFingerprint());
        requestParam.put("DeviceInfo.roN", getRoN());

        return requestParam;
    }
}
