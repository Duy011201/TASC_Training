package CreationalPattern.FactoryMethod;

public class FactoryPattern {
//	// Lớp Product - Interface hoặc Abstract
//	interface Product {
//		void create();
//	}
//
//	// Các lớp con của Product
//	class ProductA implements Product {
//		public void create() {
//			System.out.println("Product A created");
//		}
//	}
//
//	class ProductB implements Product {
//		public void create() {
//			System.out.println("Product B created");
//		}
//	}
//
//	// Factory Pattern
//	class ProductFactory {
//		public static Product createProduct(String type) {
//			if (type.equals("A")) {
//				return new ProductA();
//			} else if (type.equals("B")) {
//				return new ProductB();
//			}
//			return null;
//		}
//	}
//
//	// Sử dụng Factory
//	Product product = ProductFactory.createProduct("A");
//	product.create();  // Output: "Product A created"
}
