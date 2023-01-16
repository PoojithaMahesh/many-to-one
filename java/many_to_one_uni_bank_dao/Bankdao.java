package many_to_one_uni_bank_dao;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni_bank_dto.Bank;

public class Bankdao {
public EntityManager getEntityManager() {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	return entityManagerFactory.createEntityManager();
	
}
public void saveBank(Bank bank) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(bank);
	entityTransaction.commit();
}
public void updateBank(int id,Bank bank) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Bank bank1=entityManager.find(Bank.class, id);
	if(bank1!=null) {
		bank.setId(id);
		entityTransaction.begin();
		entityManager.merge(bank);
		entityTransaction.commit();
		
	}else {
		System.out.println("id is not present");
	}
}
public void deleteBank(int id) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Bank bank1=entityManager.find(Bank.class, id);
	entityTransaction.begin();
	entityManager.remove(bank1);
	entityTransaction.commit();
	
}
public void getBankById(int id) {
	EntityManager entityManager=getEntityManager();
	Bank bank=entityManager.find(Bank.class, id);
	System.out.println(bank);
}
public void getAllBank() {
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select b from Bank b");
	List<Bank> list=query.getResultList();
	System.out.println(list);
}

}
