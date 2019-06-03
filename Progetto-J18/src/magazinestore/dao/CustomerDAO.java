package magazinestore.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import magazinestore.entity.Cliente;
import magazinestore.entity.Utenti;

public class CustomerDAO extends JpaDAO<Cliente> implements GenericDAO<Cliente> {

	/*public CustomerDAO(EntityManager entityManager) {
		super(entityManager);
	}*/


	@Override
	public Cliente create(Cliente customer) {
		customer.setRegisterDate(new Date());
		return super.create(customer);
	}


	@Override
	public Cliente get(Object id) {
		return super.find(Cliente.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Cliente.class, id);
	}

	@Override
	public List<Cliente> listAll() {
		return super.findWithNamedQuery("Cliente.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Cliente.countAll");
	}

	public Cliente findByEmail(String email) {
    	
    	List<Cliente> listCustomers = super.findWithNamedQuery("Cliente.findByEmail", "email", email);
		if (!listCustomers.isEmpty()) {
			return listCustomers.get(0);
		}
		
		return null;
    }
}
