package application;

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
		List<Seller> sellers = sellerDao.findByDepartment(new Department(2, null));

		for (Seller sellerTemp : sellers) {
			System.out.println(sellerTemp);
		}

	}
}
