/*
    Mark Fowler
    CEN-4025C-24672
    2/25/24

    The List class allows the user to run a result list query
 */
package entity;

import jakarta.persistence.*;
import java.util.ArrayList;

public class List {
    /*
        GetList()
        Purpose: Returns all results found using a result list query
        Return Type: ArrayList<String>
        Arguments: N/A
     */
    public ArrayList<String> GetList(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        ArrayList<String> listOfTasks = new ArrayList<>();

        try {
            transaction.begin();

            Query viewList = entityManager.createNativeQuery("SELECT * from list", ListEntity.class);
            for (Object o : viewList.getResultList()){
                listOfTasks.add(o.toString());
            }

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return listOfTasks;
    }
}
