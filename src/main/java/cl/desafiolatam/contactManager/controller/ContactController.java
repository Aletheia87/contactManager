package cl.desafiolatam.contactManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.desafiolatam.contactManager.modelo.Contacto;
import cl.desafiolatam.contactManager.service.imp.ContactServiceImp;

@Controller
@RequestMapping(value="contactManager")
public class ContactController {
	
	@Autowired
	ContactServiceImp contactServiceImp;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getContactList(ModelMap modelo) {
		modelo.put("listaContacto", contactServiceImp.getContactList());
		return "contactManager";
		
	}
	
	@RequestMapping(value="/addContact", method=RequestMethod.POST)
	public String addContact(ModelMap modelo, @ModelAttribute Contacto contacto) {
		contactServiceImp.addContact(contacto);
		modelo.put("listaContacto", contactServiceImp.getContactList());
		return "contactManager";
		
	}
	
	@RequestMapping(value="/deleteContact", method=RequestMethod.GET)
	public String deleteContact(ModelMap modelo, @RequestParam(value = "id") int idContacto) {
		contactServiceImp.deleteContact(idContacto);
		modelo.put("listaContacto", contactServiceImp.getContactList());
		return "contactManager";

	}
}
