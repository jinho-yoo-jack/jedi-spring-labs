package sw.sustainable.springlabs.fpay.presentation.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderItem {
    @Min(1)
    private int itemIdx;

    private UUID productId;

    @NotBlank
    private String productName;

    private int price;    // 가격

    @Min(1)
    private int quantity; // 수량

    private int amounts;  // price * quantity

}