package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_id")
	private Long id;
	private String name;
	
	@Embedded
	private Address address;

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();

	
	
	/**
	 * address를 반환합니다.
	 * @author youngjun.jin
	 * @return address
	 */
	public Address getAddress() {
		return this.address;
	}

	/**
	 * address 초기화 합니다.
	 * @author youngjun.jin
	 * @param address 초기화 값
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * orders를 반환합니다.
	 * @author youngjun.jin
	 * @return orders
	 */
	public List<Order> getOrders() {
		return this.orders;
	}

	/**
	 * orders 초기화 합니다.
	 * @author youngjun.jin
	 * @param orders 초기화 값
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
