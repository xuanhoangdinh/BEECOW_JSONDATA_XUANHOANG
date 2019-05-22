
package ObjectPageJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonData {

    @SerializedName("Login")
    @Expose
    private Login login;
    @SerializedName("ExpectedMsg")
    @Expose
    private ExpectedMsg expectedMsg;
    @SerializedName("CreateProduct")
    @Expose
    private CreateProduct createProduct;

    public Login LoginPage() {
        return login;
    }

    public ExpectedMsg ExpectedMsgPage() {
        return expectedMsg;
    }

    public CreateProduct CreateProductPage() {
        return createProduct;
    }

}
