/*
    Mark Fowler
    CEN-4025C-24672
    2/25/24

    The Delete class allows the user to delete an item from the list.
 */
package entity;

import jakarta.persistence.*;

public class Delete {
    /*
        DeleteEntry()
        Purpose: Deletes entry from the database using the provided String. Returns if entry was found.
        Return Type: Boolean
        Arguments: String
     */
    public boolean DeleteEntry(String entry) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        boolean noResult;
        try {
            transaction.begin();

            Query verifyTask = entityManager.createNativeQuery("select * from list where task = " + "'" + entry + "'",ListEntity.class);

            noResult = false;

            if (!verifyTask.getResultList().isEmpty()) {
                Query deleteTask = entityManager.createNativeQuery("DELETE from list where task = " + "'" + entry + "'");
                deleteTask.executeUpdate();
            } else {
                noResult = true;
            }

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return noResult;
    }
}
