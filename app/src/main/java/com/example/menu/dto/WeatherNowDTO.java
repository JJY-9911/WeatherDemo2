package com.example.menu.dto;

import java.util.List;

/**
 {
   "code": "200",
   "updateTime": "2020-06-30T22:00+08:00",
   "fxLink": "http://hfx.link/2ax1",
   "now": {
     "obsTime": "2020-06-30T21:40+08:00",
     "temp": "24",
     "feelsLike": "26",
     "icon": "101",
     "text": "多云",
     "wind360": "123",
     "windDir": "东南风",
     "windScale": "1",
     "windSpeed": "3",
     "humidity": "72",
     "precip": "0.0",
     "pressure": "1003",
     "vis": "16",
     "cloud": "10",
     "dew": "21"
   },
   "refer": {
     "sources": [
       "QWeather",
       "NMC",
       "ECMWF"
     ],
     "license": [
       "QWeather Developers License"
     ]
   }
 }
 */
public class WeatherNowDTO {

    private String code;

    private String updateTime;

    private String fxLink;

    private NowDTO now;

    private ReferDTO refer;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getFxLink() {
        return fxLink;
    }

    public void setFxLink(String fxLink) {
        this.fxLink = fxLink;
    }

    public NowDTO getNow() {
        return now;
    }

    public void setNow(NowDTO now) {
        this.now = now;
    }

    public ReferDTO getRefer() {
        return refer;
    }

    public void setRefer(ReferDTO refer) {
        this.refer = refer;
    }

    public static class NowDTO {

        private String obsTime;

        private String temp;

        private String feelsLike;

        private String icon;

        private String text;

        private String wind360;

        private String windDir;

        private String windScale;

        private String windSpeed;

        private String humidity;

        private String precip;

        private String pressure;
    
        private String vis;
    
        private String cloud;
    
        private String dew;

        public String getObsTime() {
            return obsTime;
        }

        public void setObsTime(String obsTime) {
            this.obsTime = obsTime;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(String feelsLike) {
            this.feelsLike = feelsLike;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getWind360() {
            return wind360;
        }

        public void setWind360(String wind360) {
            this.wind360 = wind360;
        }

        public String getWindDir() {
            return windDir;
        }

        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        public String getWindScale() {
            return windScale;
        }

        public void setWindScale(String windScale) {
            this.windScale = windScale;
        }

        public String getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(String windSpeed) {
            this.windSpeed = windSpeed;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getPrecip() {
            return precip;
        }

        public void setPrecip(String precip) {
            this.precip = precip;
        }

        public String getPressure() {
            return pressure;
        }

        public void setPressure(String pressure) {
            this.pressure = pressure;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public String getCloud() {
            return cloud;
        }

        public void setCloud(String cloud) {
            this.cloud = cloud;
        }

        public String getDew() {
            return dew;
        }

        public void setDew(String dew) {
            this.dew = dew;
        }
    }

    public static class ReferDTO {

        private List<String> sources;

        private List<String> license;

        public List<String> getSources() {
            return sources;
        }

        public void setSources(List<String> sources) {
            this.sources = sources;
        }

        public List<String> getLicense() {
            return license;
        }

        public void setLicense(List<String> license) {
            this.license = license;
        }
    }
}
