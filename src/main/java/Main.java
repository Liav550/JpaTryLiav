import entity.Users;
import jakarta.persistence.*;

import java.util.List;

/**
 * @author liavb
 * name: Liav Bengayev
 * id: 325364537
 * date: 30/01/2023
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try
        {
//            transaction.begin();
//            Users u = new Users();
//            u.setUserName("babushka");
//            u.setPhoneNumber("0549573957");
//            u.setEmail("bab@gmail.com");
//            u.setFirstName("Nehorai");
//            u.setLastName("Babai");
//            entityManager.persist(u);
            TypedQuery<Users> listOfQueries = entityManager.createNamedQuery("Users.idAbove10",Users.class);
            List<Users> lst = listOfQueries.getResultList();
            for(Users e : lst)
            {
                System.out.println(e.toString());
            }
            transaction.commit();
        }
        finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
