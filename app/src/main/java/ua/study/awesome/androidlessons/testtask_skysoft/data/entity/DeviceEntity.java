package ua.study.awesome.androidlessons.testtask_skysoft.data.entity;

public class DeviceEntity {

    private int id;
    private String name;
    private String description;

    public DeviceEntity(int id, String name, String description){

        this.id = id;
        this.name = name;
        this.description = description;

    }

    public DeviceEntity(DeviceEntity deviceEntity) {
        this.id = deviceEntity.getId();
        this.name = deviceEntity.getName();
        this.description = deviceEntity.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}