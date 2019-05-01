package magazinestore.dao;

import magazinestore.entity.Utenti;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO extends JpaDAO<Utenti> implements GenericDAO<Utenti> {
    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Utenti create(Utenti user) {
        return super.create(user);
    }

    @Override
    public Utenti update(Utenti user) {
        return super.update(user);
    }

    @Override
    public Utenti get(Object userId) {
        return super.find(Utenti.class, userId);
    }
    
    public Utenti findByEmail(String email) {
    	
    	List<Utenti> listUsers = super.findWithNamedQuery("Users.findByEmail", "email", email);
		if (listUsers != null && listUsers.size() > 0) {
			return listUsers.get(0);
		}
		
		return null;
    }

    @Override
    public void delete(Object userId) {
        super.delete(Utenti.class, userId);
    }

    @Override
    public List<Utenti> listAll() {
        return super.findWithNamedQuery("Users.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Users.countAll");
    }
    
}
