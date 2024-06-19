/*
    Mark Fowler
    CEN-4025C-24672
    2/25/24

    The Add class allows the user to add an item to the list.
 */
package entity;

import jakarta.persistence.*;

public class Add {
    /*
        AddEntry()
        Purpose: Adds new entry to the database using the provided String.
        Return Type: N/A
        Arguments: String
     */
    public void AddEntry(String entry){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            ListEntity newTask = new ListEntity();

            newTask.setTask(entry);
            entityManager.persist(newTask);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
