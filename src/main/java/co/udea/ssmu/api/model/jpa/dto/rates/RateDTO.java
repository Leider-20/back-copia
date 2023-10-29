package co.udea.ssmu.api.model.jpa.dto.rates;
import java.util.Date;

public class RateDTO {

    private Integer id;
    private Integer price;
    private Integer surcharge;
    private Date begin_date;
    private Date end_date;

    @Override
    public String toString() {
        return "RateDTO{" +
                "id=" + id +
                ", price=" + price +
                ", surcharge=" + surcharge +
                ", begin_date=" + begin_date +
                ", end_date=" + end_date +
                '}';
    }

    public RateDTO(Integer id, Integer price, Integer surcharge, Date begin_date, Date end_date) {
        this.id = id;
        this.price = price;
        this.surcharge = surcharge;
        this.begin_date = begin_date;
        this.end_date = end_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(Integer surcharge) {
        this.surcharge = surcharge;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
