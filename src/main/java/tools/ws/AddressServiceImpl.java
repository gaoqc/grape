package tools.ws;

import javax.jws.WebService;
import bean.Address;
@WebService(endpointInterface="tools.ws.IAddressService")
public class AddressServiceImpl implements IAddressService
{

    @Override
    public Address add()
    {
        
        return null;
    }

    @Override
    public Address update()
    {
         System.out.println("update");
        return null;
    }

    @Override
    public Address delete()
    {
        
        return null;
    }

}
