package co.udea.ssmu.api.model.jpa.mapper.paymentMethod;

import co.udea.ssmu.api.model.jpa.dto.paymentMethod.PaymentMethodDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.paymentMethod.PaymentMethod;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface paymentMethodMapper extends EntityMapper<PaymentMethodDTO, PaymentMethod> {
}
