package ws.restful.datamodel.Customer;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "createCustomerRsp", propOrder = {
    "id"
})

public class CreateCustomerRsp {

    private Long id;

    public CreateCustomerRsp() {
    }

    public CreateCustomerRsp(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
