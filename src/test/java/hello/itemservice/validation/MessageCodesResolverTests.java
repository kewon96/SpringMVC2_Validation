package hello.itemservice.validation;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageCodesResolverTests {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    /**
     * ObjectError와 관련된 에러처리
     */
    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
        for(String message: messageCodes) {
            System.out.println("message = " + message);
        }

        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    /**
     * FieldError와 관련된 에러처리
     */
    @Test
    void messageCodesResolverField() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);

        for(String message: messageCodes) {
            System.out.println("message = " + message);
        }

//        bindingResult.rejectValue("itemName", "required");
//        new FieldError("item", "itemName", null, false, messageCodes, null, null);

        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }

}
