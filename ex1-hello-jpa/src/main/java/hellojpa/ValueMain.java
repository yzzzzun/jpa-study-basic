/**
 * FileName : ValueMain.java
 * Created 	: 2021. 1. 12.
 * Author 	: youngjun.jin
 * Summary 	:
 *
 * 이 문서의 모든 저작권 및 지적 재산권은 youngjun.jin에게 있습니다.
 * 이 문서의 어떠한 부분도 허가 없이 복제 또는 수정 하거나, 전송할 수 없습니다.
 */
package hellojpa;

/**
 * @author youngjun.jin
 */
public class ValueMain {

	public static void main(String[] args) {

		int a = 10;
		int b = 10;

		System.out.println("a == b = " + (a == b));

		Address addr1 = new Address("city", "street", "100");
		Address addr2 = new Address("city", "street", "100");

		System.out.println("addr1 == addr2 = " + (addr1 == addr2));
		System.out.println("addr1 equals addr2 = " + (addr1.equals(addr2)));
	}
}
