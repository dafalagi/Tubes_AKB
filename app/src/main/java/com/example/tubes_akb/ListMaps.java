
// Nama : Saeful Anwar Oktariansah
// NIM  : 10119094
// Kelas: IF-3

package com.example.tubes_akb;

public class ListMaps {
    private long id;
    private String title, desc, created, latitude, longitude;

    public ListMaps(String title, String desc, String latitude, String longitude) {
        this.title = title;
        this.desc = desc;
        this.created = created;
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
    //    public ListMaps(){}
//    public ListMaps(String title, String desc, String created, String latitude, String longitude){
//        this.title = title;
//        this.desc = desc;
//        this.created = created;
//        this.latitude = latitude;
//        this.longitude = longitude;
//    }
//    public ListMaps(long id, String title, String desc, String created, String latitude, String longitude)
//    {
//        this.id = id;
//        this.title = title;
//        this.desc = desc;
//        this.created = created;
//        this.latitude = latitude;
//        this.longitude = longitude;
//    }
//
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
//    public String getCreated() {
//        return created;
//    }
//
//    public void setCreated(String created) {
//        this.created = created;
//    }
//
//    public String getLatitude(){
//        return latitude;
//    }
//
//    public void setLatitude(String latitude){
//        this.latitude = latitude;
//    }
//
//    public String getLongitude(){
//        return longitude;
//    }
//
//    public void setLongitude(String latitude){
//        this.longitude = latitude;
//    }
}
