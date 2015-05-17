package tools.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import bean.Address;

@WebService
public interface IAddressService
{
    @WebMethod(action="addAddressAction",operationName="addOperation")
    public Address add();
    @WebMethod(exclude=true)
    public Address update();
    
    public Address delete();

}
