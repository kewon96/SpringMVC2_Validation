package hello.itemservice.domain.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data @AllArgsConstructor
@Builder
public class Item {

    private Long id;

    private String itemName;

    private Integer price;

    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
