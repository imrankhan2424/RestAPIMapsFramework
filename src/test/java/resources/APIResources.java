package resources;

public enum APIResources {
    AddplaceAPI("/maps/api/place/add/json"),
    GetplaceAPI("/maps/api/place/get/json"),
    DeleteplaceAPI("/maps/api/place/delete/json");
    private String path;
    APIResources(String path) {
        this.path=path;
    }

    public String getPath(){
        return path;
    }

}
