
// Nama : Dafa Rizky Fahreza
// NIM  : 10119113
// Kelas: IF-3

package com.example.tubes_akb;

public class ListMaps {
    private long id;
    private String title, desc, latitude, longitude;

    public ListMaps(){

    }

    public ListMaps(String title, String desc, String latitude, String longitude) {
        this.title = title;
        this.desc = desc;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


}
