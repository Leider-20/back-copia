package co.udea.ssmu.api.model.jpa.dto.cities;

public class CityDTO {
    private Integer id;
    private String name;
    private Integer percentage;

    public CityDTO(Integer id, String name, Integer percentage) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
