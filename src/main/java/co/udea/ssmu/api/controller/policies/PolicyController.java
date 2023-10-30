package co.udea.ssmu.api.controller.policies;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.ssmu.api.model.jpa.dto.policies.PolicyDTO;
import co.udea.ssmu.api.services.policies.facade.PolicyFacade;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.common.StandardResponse;
import co.udea.ssmu.api.utils.exception.NoPoliciesFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/policies")
public class PolicyController {
    private final PolicyFacade policyFacade;
    private final Messages messages;

    @Autowired
    public PolicyController(PolicyFacade policyFacade, Messages messages) {
        this.policyFacade = policyFacade;
        this.messages = messages;
    }

    @GetMapping("/list")
    public List<PolicyDTO> getPolicyNames() {
        List<PolicyDTO> policyNames = policyFacade.getAllPolicies();
        policyNames.sort(Comparator.comparing(PolicyDTO::getId));
        return policyNames;
    }

    @GetMapping("/latest")
    public PolicyDTO getLatestPolicy() {
        List<PolicyDTO> policyNames = policyFacade.getAllPolicies();
        if (!policyNames.isEmpty()) {
            policyNames.sort(Comparator.comparing(PolicyDTO::getId).reversed());
            return policyNames.get(0);
        } else {
            throw new NoPoliciesFoundException("No se encontraron políticas.");
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Guardar políticas de pago a los socios")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = PolicyDTO.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La política fue guardada exitosamente"),
            @ApiResponse(responseCode = "400", description = "La petición es inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta") })
    public ResponseEntity<StandardResponse<PolicyDTO>> save(@Valid @RequestBody PolicyDTO policyDTO) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK,
                messages.get("policies.save.successful"),
                policyFacade.createPolicy(policyDTO)));

    }

}
