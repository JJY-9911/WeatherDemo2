package com.example.menu.dto;

import java.util.List;
/**
 {
 "code": "200",
 "updateTime": "2023-06-06T09:35+08:00",
 "fxLink": "https://www.qweather.com/weather/beijing-101010100.html",
 "daily": [
 {
 "fxDate": "2023-06-06",
 "sunrise": "04:46",
 "sunset": "19:42",
 "moonrise": "22:15",
 "moonset": "06:09",
 "moonPhase": "亏凸月",
 "moonPhaseIcon": "805",
 "tempMax": "35",
 "tempMin": "22",
 "iconDay": "100",
 "textDay": "晴",
 "iconNight": "150",
 "textNight": "晴",
 "wind360Day": "180",
 "windDirDay": "南风",
 "windScaleDay": "3-4",
 "windSpeedDay": "16",
 "wind360Night": "225",
 "windDirNight": "西南风",
 "windScaleNight": "3-4",
 "windSpeedNight": "16",
 "humidity": "19",
 "precip": "0.0",
 "pressure": "994",
 "vis": "25",
 "cloud": "25",
 "uvIndex": "11"
 },
 {
 "fxDate": "2023-06-07",
 "sunrise": "04:45",
 "sunset": "19:43",
 "moonrise": "23:04",
 "moonset": "07:19",
 "moonPhase": "亏凸月",
 "moonPhaseIcon": "805",
 "tempMax": "36",
 "tempMin": "22",
 "iconDay": "305",
 "textDay": "小雨",
 "iconNight": "150",
 "textNight": "晴",
 "wind360Day": "225",
 "windDirDay": "西南风",
 "windScaleDay": "1-2",
 "windSpeedDay": "3",
 "wind360Night": "315",
 "windDirNight": "西北风",
 "windScaleNight": "1-2",
 "windSpeedNight": "3",
 "humidity": "25",
 "precip": "2.5",
 "pressure": "997",
 "vis": "25",
 "cloud": "60",
 "uvIndex": "11"
 },
 {
 "fxDate": "2023-06-08",
 "sunrise": "04:45",
 "sunset": "19:43",
 "moonrise": "23:45",
 "moonset": "08:36",
 "moonPhase": "亏凸月",
 "moonPhaseIcon": "805",
 "tempMax": "32",
 "tempMin": "20",
 "iconDay": "100",
 "textDay": "晴",
 "iconNight": "150",
 "textNight": "晴",
 "wind360Day": "315",
 "windDirDay": "西北风",
 "windScaleDay": "3-4",
 "windSpeedDay": "24",
 "wind360Night": "0",
 "windDirNight": "北风",
 "windScaleNight": "1-2",
 "windSpeedNight": "3",
 "humidity": "20",
 "precip": "0.0",
 "pressure": "996",
 "vis": "25",
 "cloud": "25",
 "uvIndex": "11"
 },
 {
 "fxDate": "2023-06-09",
 "sunrise": "04:45",
 "sunset": "19:44",
 "moonrise": "",
 "moonset": "09:54",
 "moonPhase": "亏凸月",
 "moonPhaseIcon": "805",
 "tempMax": "34",
 "tempMin": "20",
 "iconDay": "100",
 "textDay": "晴",
 "iconNight": "151",
 "textNight": "多云",
 "wind360Day": "315",
 "windDirDay": "西北风",
 "windScaleDay": "3-4",
 "windSpeedDay": "16",
 "wind360Night": "45",
 "windDirNight": "东北风",
 "windScaleNight": "1-2",
 "windSpeedNight": "3",
 "humidity": "33",
 "precip": "0.0",
 "pressure": "997",
 "vis": "24",
 "cloud": "25",
 "uvIndex": "10"
 },
 {
 "fxDate": "2023-06-10",
 "sunrise": "04:45",
 "sunset": "19:44",
 "moonrise": "00:18",
 "moonset": "11:10",
 "moonPhase": "亏凸月",
 "moonPhaseIcon": "805",
 "tempMax": "30",
 "tempMin": "18",
 "iconDay": "101",
 "textDay": "多云",
 "iconNight": "104",
 "textNight": "阴",
 "wind360Day": "315",
 "windDirDay": "西北风",
 "windScaleDay": "3-4",
 "windSpeedDay": "16",
 "wind360Night": "0",
 "windDirNight": "北风",
 "windScaleNight": "1-2",
 "windSpeedNight": "3",
 "humidity": "44",
 "precip": "0.0",
 "pressure": "1001",
 "vis": "24",
 "cloud": "25",
 "uvIndex": "11"
 },
 {
 "fxDate": "2023-06-11",
 "sunrise": "04:45",
 "sunset": "19:45",
 "moonrise": "00:47",
 "moonset": "12:24",
 "moonPhase": "下弦月",
 "moonPhaseIcon": "806",
 "tempMax": "32",
 "tempMin": "20",
 "iconDay": "101",
 "textDay": "多云",
 "iconNight": "151",
 "textNight": "多云",
 "wind360Day": "0",
 "windDirDay": "北风",
 "windScaleDay": "1-2",
 "windSpeedDay": "3",
 "wind360Night": "225",
 "windDirNight": "西南风",
 "windScaleNight": "1-2",
 "windSpeedNight": "3",
 "humidity": "36",
 "precip": "0.0",
 "pressure": "1001",
 "vis": "25",
 "cloud": "25",
 "uvIndex": "11"
 },
 {
 "fxDate": "2023-06-12",
 "sunrise": "04:45",
 "sunset": "19:45",
 "moonrise": "01:12",
 "moonset": "13:37",
 "moonPhase": "残月",
 "moonPhaseIcon": "807",
 "tempMax": "34",
 "tempMin": "23",
 "iconDay": "100",
 "textDay": "晴",
 "iconNight": "150",
 "textNight": "晴",
 "wind360Day": "225",
 "windDirDay": "西南风",
 "windScaleDay": "1-2",
 "windSpeedDay": "3",
 "wind360Night": "225",
 "windDirNight": "西南风",
 "windScaleNight": "1-2",
 "windSpeedNight": "3",
 "humidity": "19",
 "precip": "0.0",
 "pressure": "992",
 "vis": "25",
 "cloud": "25",
 "uvIndex": "11"
 }
 ],
 "refer": {
 "sources": [
 "QWeather",
 "NMC",
 "ECMWF"
 ],
 "license": ["CC BY-SA 4.0"]
 }
 */

public class WeatherSevenDTO {

    private String code;

    private String updateTime;

    private String fxLink;

    private List<DailyDTO> daily;

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

    public List<DailyDTO> getDaily() {
        return daily;
    }

    public void setDaily(List<DailyDTO> daily) {
        this.daily = daily;
    }

    public ReferDTO getRefer() {
        return refer;
    }

    public void setRefer(ReferDTO refer) {
        this.refer = refer;
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

    public static class DailyDTO {
        private String fxDate;
        private String sunrise;
        private String sunset;
        private String moonrise;

        private String moonset;

        private String moonPhase;
        private String moonPhaseIcon;
        private String tempMax;
        private String tempMin;
        private String iconDay;

        private String textDay;
        private String iconNight;

        private String textNight;
        private String wind360Day;
        private String windDirDay;
        private String windScaleDay;
        private String windSpeedDay;
        private String wind360Night;

        private String windDirNight;
        private String windScaleNight;
        private String windSpeedNight;
        private String humidity;
        private String precip;
        private String pressure;

        private String vis;
        private String cloud;
        private String uvIndex;

        public String getFxDate() {
            return fxDate;
        }

        public void setFxDate(String fxDate) {
            this.fxDate = fxDate;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getMoonrise() {
            return moonrise;
        }

        public void setMoonrise(String moonrise) {
            this.moonrise = moonrise;
        }

        public String getMoonset() {
            return moonset;
        }

        public void setMoonset(String moonset) {
            this.moonset = moonset;
        }

        public String getMoonPhase() {
            return moonPhase;
        }

        public void setMoonPhase(String moonPhase) {
            this.moonPhase = moonPhase;
        }

        public String getMoonPhaseIcon() {
            return moonPhaseIcon;
        }

        public void setMoonPhaseIcon(String moonPhaseIcon) {
            this.moonPhaseIcon = moonPhaseIcon;
        }

        public String getTempMax() {
            return tempMax;
        }

        public void setTempMax(String tempMax) {
            this.tempMax = tempMax;
        }

        public String getTempMin() {
            return tempMin;
        }

        public void setTempMin(String tempMin) {
            this.tempMin = tempMin;
        }

        public String getIconDay() {
            return iconDay;
        }

        public void setIconDay(String iconDay) {
            this.iconDay = iconDay;
        }

        public String getTextDay() {
            return textDay;
        }

        public void setTextDay(String textDay) {
            this.textDay = textDay;
        }

        public String getIconNight() {
            return iconNight;
        }

        public void setIconNight(String iconNight) {
            this.iconNight = iconNight;
        }

        public String getTextNight() {
            return textNight;
        }

        public void setTextNight(String textNight) {
            this.textNight = textNight;
        }

        public String getWind360Day() {
            return wind360Day;
        }

        public void setWind360Day(String wind360Day) {
            this.wind360Day = wind360Day;
        }

        public String getWindDirDay() {
            return windDirDay;
        }

        public void setWindDirDay(String windDirDay) {
            this.windDirDay = windDirDay;
        }

        public String getWindScaleDay() {
            return windScaleDay;
        }

        public void setWindScaleDay(String windScaleDay) {
            this.windScaleDay = windScaleDay;
        }

        public String getWindSpeedDay() {
            return windSpeedDay;
        }

        public void setWindSpeedDay(String windSpeedDay) {
            this.windSpeedDay = windSpeedDay;
        }

        public String getWind360Night() {
            return wind360Night;
        }

        public void setWind360Night(String wind360Night) {
            this.wind360Night = wind360Night;
        }

        public String getWindDirNight() {
            return windDirNight;
        }

        public void setWindDirNight(String windDirNight) {
            this.windDirNight = windDirNight;
        }

        public String getWindScaleNight() {
            return windScaleNight;
        }

        public void setWindScaleNight(String windScaleNight) {
            this.windScaleNight = windScaleNight;
        }

        public String getWindSpeedNight() {
            return windSpeedNight;
        }

        public void setWindSpeedNight(String windSpeedNight) {
            this.windSpeedNight = windSpeedNight;
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

        public String getUvIndex() {
            return uvIndex;
        }

        public void setUvIndex(String uvIndex) {
            this.uvIndex = uvIndex;
        }
    }
}
