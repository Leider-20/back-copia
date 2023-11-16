package co.udea.ssmu.api.model.jpa.dto.rate;


import co.udea.ssmu.api.model.jpa.dto.serviceType.ServiceTypeDTO;

public class RateDTO {

    private Integer id;
    private ServiceTypeDTO serviceType;
    private Double distanceTraveled;
    private Double baseRate;
    private Double coveredKmRate;
    private Double rateKm;
    private Double hourlyRate;
    private Double multiplierFactor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ServiceTypeDTO getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceTypeDTO serviceType) {
        this.serviceType = serviceType;
    }

    public Double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(Double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public Double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(Double baseRate) {
        this.baseRate = baseRate;
    }

    public Double getCoveredKmRate() {
        return coveredKmRate;
    }

    public void setCoveredKmRate(Double coveredKmRate) {
        this.coveredKmRate = coveredKmRate;
    }

    public Double getRateKm() {
        return rateKm;
    }

    public void setRateKm(Double rateKm) {
        this.rateKm = rateKm;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Double getMultiplierFactor() {
        return multiplierFactor;
    }

    public void setMultiplierFactor(Double multiplierFactor) {
        this.multiplierFactor = multiplierFactor;
    }
}
