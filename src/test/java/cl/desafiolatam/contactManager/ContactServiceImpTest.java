package cl.desafiolatam.contactManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import cl.desafiolatam.contactManager.modelo.Contacto;
import cl.desafiolatam.contactManager.service.ContactService;


@SpringBootTest
@ContextConfiguration(classes = ConfiguradorSpring.class)
@TestMethodOrder(OrderAnnotation.class)
public class ContactServiceImpTest {
	
	@Autowired
	Contacto contacto;
	@Autowired
	ContactService contactService;
	
	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("setUp");
		contacto.setIdContacto(1);
		contacto.setNombre("Carolina");
		contacto.setApellidoPaterno("Diaz");
		contacto.setApellidoMaterno("Araya");
		contacto.setDireccion("Calle Falsa 123");
		contacto.setTelefono(999999999);
		contactService.addContact(contacto);

	}
	
	@Test 
	@Order(1)
	public void addContactTest() {
		Assertions.assertEquals(contacto, contactService.getContactList().get(0));

	}
	
	@Test
	@Order(2)
	public void getContactListTest() {
		Assertions.assertNotNull(contactService.getContactList());
	}
	
	@Test
	@Order(3)
	public void deleteContactTest() {
		int id = 1;
		contactService.deleteContact(id);
		Assertions.assertEquals(0, contactService.getContactList().indexOf(contacto));

		
	}

}
