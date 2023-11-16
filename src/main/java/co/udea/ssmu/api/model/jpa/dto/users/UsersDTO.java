package co.udea.ssmu.api.model.jpa.dto.users;


import co.udea.ssmu.api.model.jpa.dto.paymentMethod.PaymentMethodDTO;
import co.udea.ssmu.api.model.jpa.model.services.Service;

import java.util.List;

public class UsersDTO {

    private Integer id;
    private PaymentMethodDTO paymentMethod;
    private String name;
    private String phone;
    private String email;
    private String document;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentMethodDTO getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodDTO paymentMethod) {
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
}
