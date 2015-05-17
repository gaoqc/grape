package tools.ws;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import bean.Person;
 
@WebService(endpointInterface="tools.ws.IPersonsService") 
public class PersonsServiceImpl implements IPersonsService
{
    
    


    @Override
    public Person newPeron(Person person)
    {
        person.setName("new_person");
        return person;
    }

    @Override
    public Person updatePeron(Person person)
    {
        person.setName("update_person");
        return person;
    }

    @Override
    public Person deletePeron(Person person)
    {
        person.setName("delete_person");
        return person;
    }
    
    public static void main(String[] args)
    {
        String personSerciceUrl="http://localhost:8080/ws/personService";
        String addressSerciceUrl="http://localhost:8080/ws/addressService";
        Endpoint.publish(personSerciceUrl,new PersonsServiceImpl());
        Endpoint.publish(addressSerciceUrl,new AddressServiceImpl());
        
    }

}
