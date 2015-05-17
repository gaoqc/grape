package tools.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import bean.Person;
@WebService
public interface IPersonsService
{
    @WebMethod(action="newPerson")
    public Person newPeron(@WebParam(name="person")Person peron);

    public Person updatePeron(Person person);

    public Person deletePeron(Person persons);

}
