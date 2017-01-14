/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import facade.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.User;

/**
 *
 * @author mewsha
 */
@Stateless
public class UserEjb extends AbstractFacade<User> {

    @PersistenceContext(unitName = "JSF_TESTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserEjb() {
        super(User.class);
    }

    public List<User> findByType(int type) {
        try {
            return this.getEntityManager()
                    .createQuery("SELECT a FROM User a WHERE a.type = ?1")
                    .setParameter(1, type)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace(); //print error on server log
            return null;
        }
    }
}
