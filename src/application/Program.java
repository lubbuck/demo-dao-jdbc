package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("==== Teste 1 FindById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("==== Teste 2 FindByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> sellersByDepartment = sellerDao.findByDepartment(department);

		for (Seller sellerTemp : sellersByDepartment) {
			System.out.println(sellerTemp);
		}

		System.out.println("==== Teste 3 FindAll ====");
		List<Seller> allSellers = sellerDao.findAll();

		for (Seller sellerTemp : allSellers) {
			System.out.println(sellerTemp);
		}

		System.out.println("==== Teste 4 Insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Seller inserido " + newSeller.getId());
		
		
		System.out.println("==== Teste 5 Update ====");
		seller = sellerDao.findById(1);
		seller.setName("Wayne");
		seller.setEmail("wayne@gmail.com");
		sellerDao.update(seller);
		System.out.println("Seller updated ");
		
		System.out.println("==== Teste 6 delete ====");
		sellerDao.deleteById(19);
		System.out.println("Seller deleted ");
	}
}
