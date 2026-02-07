package programs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CreateConnectionCrud {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		System.out.println("Connection established");
		System.out.println("table is created");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//insert
	TableClass t1=new TableClass();
		t1.setId(1);
		t1.setName("aradhya");
		t1.setPhone(645465445);
		
		TableClass t2=new TableClass();
		t2.setId(2);
		t2.setName("pradhya");
		t2.setPhone(64546265);
	
		TableClass t3=new TableClass();
		t3.setId(3);
		t3.setName("sradhya");
		t3.setPhone(64565985);
		
		TableClass t4=new TableClass();
		t4.setId(4);
		t4.setName("qradhya");
		t4.setPhone(645445);
		System.out.println("The values are inserted");
		
		//update by using class object 1
		
//		TableClass t5=new TableClass();
//		t5.setId(1);
//		t5.setName("adhya");
//		t5.setPhone(6454645);
//		System.out.println("The values are updated");
		
		et.begin();
		//insert
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		em.persist(t4);
		
//		em.merge(t5);
		
//		update using find function
		TableClass t6=em.find(TableClass.class,2);
		t6.setName("kadhya");
		t6.setPhone(741085245);
		System.out.println("The values are updated");
		
//		Fetch row by using find function
		TableClass t7=em.find(TableClass.class,2);
		System.out.println("ID:"+t7.getId()+" "+"Name:"+t7.getName()+" "+"Phone:"+t7.getPhone());
		System.out.println("values fetched");
		
//		Fetch all
		TypedQuery<TableClass> q=em.createQuery("select t from TableClass t", TableClass.class);
		List<TableClass> list=q.getResultList();
		for(TableClass t8:list) {
			System.out.println("ID:"+t8.getId()+" "+"Name:"+t8.getName()+" "+"Phone:"+t8.getPhone());
		}   																																																																																																																																																																																							
		System.out.println("all values fetched");
		
//		DELETE row
		TableClass t8=em.find(TableClass.class, 4);
		em.remove(t8);
		System.out.println("the values are deleted");
		
//		DELETE ALL
		Query q1=em.createQuery("delete from TableClass");
		q1.executeUpdate();
		System.out.println("all values deleted");
		
		et.commit();
		 }}