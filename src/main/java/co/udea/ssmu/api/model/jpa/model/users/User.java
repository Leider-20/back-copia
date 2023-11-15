package co.udea.ssmu.api.model.jpa.model.users;

import co.udea.ssmu.api.model.jpa.model.paymentMethod.PaymentMethod;
import co.udea.ssmu.api.model.jpa.model.services.Service;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "paymentMethod")
    private PaymentMethod paymentMethod;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "phone")
    private String phone;
    @NotNull
    @Column(name = "email")
    private String email;
    @NotNull
    @Column(name = "document")
    private String document;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Service> services;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
