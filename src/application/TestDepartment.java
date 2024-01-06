package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class TestDepartment {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("==== Teste 1 FindById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);

		System.out.println("==== Teste 2 FindAll ====");
		List<Department> allDepartments = departmentDao.findAll();

		for (Department departmentTemp : allDepartments) {
			System.out.println(departmentTemp);
		}

		System.out.println("==== Teste 3 Insert ====");
		Department newDepartment = new Department(null, "Notas");
		departmentDao.insert(newDepartment);
		System.out.println("Department inserido " + newDepartment.getId());

		System.out.println("==== Teste 4 Update ====");
		department = departmentDao.findById(1);
		department.setName("Testada");
		departmentDao.update(department);
		System.out.println("Department updated ");

		System.out.println("==== Teste 5 delete ====");
		departmentDao.deleteById(4);
		System.out.println("Department deleted ");

	}
}
