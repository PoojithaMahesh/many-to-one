package many_to_one_uni_bank_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni_bank_dto.Bank;
import many_to_one_uni_bank_dto.Branch;

public class Branchdao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
		
	}
	public void saveBranch(Branch branch) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Bank bank=branch.getBank();
		entityTransaction.begin();
		entityManager.persist(bank);
		entityManager.persist(branch);
		entityTransaction.commit();
	}
	public void updateBranch(int id ,Branch branch) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch2=entityManager.find(Branch.class, id);
		if(branch2!=null) {
			branch.setId(id);
			branch.setBank(branch2.getBank());
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
			
		}else {
			System.out.println("id is not present");
		}
	}
	public void deleteBranch(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, id);
		entityTransaction.begin();
		entityManager.remove(branch);
		entityTransaction.commit();
		
	}
	public void getBranchById(int id) {
		EntityManager entityManager=getEntityManager();
		Branch branch=entityManager.find(Branch.class, id);
		System.out.println(branch);
	}
	public void getAllBranch() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select b from Branch b");
		List<Bank> list=query.getResultList();
		System.out.println(list);
	}
}
